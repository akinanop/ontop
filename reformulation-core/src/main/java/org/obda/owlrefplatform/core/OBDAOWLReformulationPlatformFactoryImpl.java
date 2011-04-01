package org.obda.owlrefplatform.core;

import inf.unibz.it.obda.api.controller.APIController;
import inf.unibz.it.obda.domain.DataSource;
import inf.unibz.it.obda.domain.OBDAMappingAxiom;
import inf.unibz.it.obda.owlapi.ReformulationPlatformPreferences;
import inf.unibz.it.obda.rdbmsgav.domain.RDBMSsourceParameterConstants;
import org.obda.owlrefplatform.core.abox.ABoxSerializer;
import org.obda.owlrefplatform.core.abox.ABoxToDBDumper;
import org.obda.owlrefplatform.core.abox.DAG;
import org.obda.owlrefplatform.core.abox.SemanticIndexMappingGenerator;
import org.obda.owlrefplatform.core.ontology.DLLiterOntology;
import org.obda.owlrefplatform.core.ontology.imp.DLLiterOntologyImpl;
import org.obda.owlrefplatform.core.ontology.imp.OWLAPITranslator;
import org.obda.owlrefplatform.core.queryevaluation.EvaluationEngine;
import org.obda.owlrefplatform.core.queryevaluation.JDBCEngine;
import org.obda.owlrefplatform.core.queryevaluation.JDBCUtility;
import org.obda.owlrefplatform.core.reformulation.DLRPerfectReformulator;
import org.obda.owlrefplatform.core.reformulation.QueryRewriter;
import org.obda.owlrefplatform.core.reformulation.TreeRedReformulator;
import org.obda.owlrefplatform.core.srcquerygeneration.ComplexMappingSQLGenerator;
import org.obda.owlrefplatform.core.srcquerygeneration.SimpleDirectQueryGenrator;
import org.obda.owlrefplatform.core.srcquerygeneration.SourceQueryGenerator;
import org.obda.owlrefplatform.core.unfolding.ComplexMappingUnfolder;
import org.obda.owlrefplatform.core.unfolding.DirectMappingUnfolder;
import org.obda.owlrefplatform.core.unfolding.UnfoldingMechanism;
import org.obda.owlrefplatform.core.viewmanager.MappingViewManager;
import org.obda.owlrefplatform.exception.OBDAOWLReformulaionPlatformFactoryException;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.sql.*;
import java.util.*;

/**
 * The implementation of the factory for creating reformulation's platform reasoner
 *
 * @author Manfred Gerstgrasser
 */

public class OBDAOWLReformulationPlatformFactoryImpl implements OBDAOWLReformulationPlatformFactory {

    private APIController apic;
    private ReformulationPlatformPreferences preferences;

    private final Logger log = LoggerFactory.getLogger(OBDAOWLReformulationPlatformFactoryImpl.class);


    @Override
    public void setOBDAController(APIController apic) {
        this.apic = apic;
        ABoxToDBDumper.getInstance().setAPIController(apic);
    }

    @Override
    public void setPreferenceHolder(ReformulationPlatformPreferences preference) {
        this.preferences = preference;
    }

    /**
     * Creates a new reformulation platform reasoner.
     */
    @Override
    public OWLReasoner createReasoner(OWLOntologyManager manager) {

        if (apic == null) {
            throw new NullPointerException("APIController not set");
        }
        if (preferences == null) {
            throw new NullPointerException("ReformulationPlatformPreferences not set");
        }

        //String useMem = (String)
        boolean useInMemoryDB = (Boolean) preferences.getCurrentValue(ReformulationPlatformPreferences.USE_INMEMORY_DB);
        String unfoldingMode = (String) preferences.getCurrentValue(ReformulationPlatformPreferences.UNFOLDING_MECHANMISM);
        boolean createMappings = (Boolean) preferences.getCurrentValue(ReformulationPlatformPreferences.CREATE_TEST_MAPPINGS);
        String reformulationTechnique = (String) preferences.getCurrentValue(ReformulationPlatformPreferences.REFORMULATION_TECHNIQUE);

        OBDAOWLReformulationPlatform reasoner = null;
        QueryRewriter rewriter;
        TechniqueWrapper techniqueWrapper;
        UnfoldingMechanism unfMech = null;
        SourceQueryGenerator gen = null;
        DataSource ds;
        EvaluationEngine eval_engine;
        DAG dag = null;

        try {
            Set<OWLOntology> ontologies = manager.getOntologies();
            URI uri = null;
            if (ontologies.size() > 0) {
                uri = ontologies.iterator().next().getURI();
            }
            DLLiterOntology ontology = new DLLiterOntologyImpl(uri);

            log.debug("Translating ontologies");
            OWLAPITranslator translator = new OWLAPITranslator();
            Set<URI> uris = new HashSet<URI>();
            for (OWLOntology onto : ontologies) {
                uris.add(onto.getURI());
                DLLiterOntology aux = translator.translate(onto);
                ontology.addAssertions(aux.getAssertions());
            }

            if (useInMemoryDB) {
                log.debug("Using in an memory database");
                String driver = "org.h2.Driver";
                String url = "jdbc:h2:mem:";
                String dbname = "aboxdump";
                String username = "sa";
                String password = "";
                Connection connection;

                DataSource source = new DataSource(URI.create("http://www.obda.org/ABOXDUMP"));
                source.setParameter(RDBMSsourceParameterConstants.DATABASE_DRIVER, driver);
                source.setParameter(RDBMSsourceParameterConstants.DATABASE_NAME, dbname);
                source.setParameter(RDBMSsourceParameterConstants.DATABASE_PASSWORD, password);
                source.setParameter(RDBMSsourceParameterConstants.DATABASE_URL, url);
                source.setParameter(RDBMSsourceParameterConstants.DATABASE_USERNAME, username);
                source.setParameter(RDBMSsourceParameterConstants.IS_IN_MEMORY, "true");
                source.setParameter(RDBMSsourceParameterConstants.USE_DATASOURCE_FOR_ABOXDUMP, "true");

                apic.getDatasourcesController().addDataSource(source);
                apic.getDatasourcesController().setCurrentDataSource(source.getSourceID());

                connection = DriverManager.getConnection(url + dbname, username, password);
                if (unfoldingMode.equals("semantic")) {
                    //perform semantic import
                    dag = new DAG(ontologies);
                    ABoxSerializer.recreate_tables(connection);
                    ABoxSerializer.ABOX2DB(ontologies, dag, connection);
                } else {
                    //perform direct import
                    String[] types = {"TABLE"};

                    ResultSet set = connection.getMetaData().getTables(null, null, "%", types);
                    Vector<String> drops = new Vector<String>();
                    while (set.next()) {
                        String table = set.getString(3);
                        drops.add("DROP TABLE " + table);
                    }
                    set.close();

                    Statement st = connection.createStatement();
                    for (String drop_table : drops) {
                        st.executeUpdate(drop_table);
                    }
                    try {
                        ABoxToDBDumper.getInstance().materialize(ontologies, connection, source.getSourceID(), createMappings);
                    } catch (SQLException e) {
                        throw new OBDAOWLReformulaionPlatformFactoryException(e);
                    }
                }
                ds = source;
                eval_engine = new JDBCEngine(connection);

            } else {
                log.debug("Using a persistent database");

                Collection<DataSource> sources = apic.getDatasourcesController().getAllSources().values();
                if (sources == null || sources.size() == 0) {
                    throw new Exception("No datasource selected");
                } else if (sources.size() > 1) {
                    throw new Exception("Currently the reasoner can only handle one datasource");
                } else {
                    ds = sources.iterator().next();
                }
                eval_engine = new JDBCEngine(ds);
            }


            if ("dlr".equals(reformulationTechnique)) {
                rewriter = new DLRPerfectReformulator(ontology.getAssertions());
            } else if ("improved".equals(reformulationTechnique)) {
                rewriter = new TreeRedReformulator(ontology.getAssertions());
            } else {
                throw new IllegalArgumentException("Invalid value for argument: " + ReformulationPlatformPreferences.REFORMULATION_TECHNIQUE);
            }

            if ("complex".equals(unfoldingMode)) {
                List<OBDAMappingAxiom> mappings = apic.getMappingController().getMappings(ds.getSourceID());
                MappingViewManager viewMan = new MappingViewManager(mappings);
                unfMech = new ComplexMappingUnfolder(mappings, viewMan);
                JDBCUtility util = new JDBCUtility(ds.getParameter(RDBMSsourceParameterConstants.DATABASE_DRIVER));
                gen = new ComplexMappingSQLGenerator(ontology, viewMan, util);
            } else if ("direct".equals(unfoldingMode)) {
                unfMech = new DirectMappingUnfolder();
                gen = new SimpleDirectQueryGenrator(apic.getIOManager().getPrefixManager(), ontology, uris);
            } else if ("semantic".equals(unfoldingMode)) {
                // create t-dag, sigma-dag, create mappings, compute t'

                SemanticIndexMappingGenerator.GenMapping(dag, apic);

                List<OBDAMappingAxiom> mappings = apic.getMappingController().getMappings(ds.getSourceID());
                MappingViewManager viewMan = new MappingViewManager(mappings);
                unfMech = new ComplexMappingUnfolder(mappings, viewMan);
                JDBCUtility util = new JDBCUtility(ds.getParameter(RDBMSsourceParameterConstants.DATABASE_DRIVER));
                gen = new ComplexMappingSQLGenerator(ontology, viewMan, util);

            } else {
                log.error("Invalid parameter {}", ReformulationPlatformPreferences.UNFOLDING_MECHANMISM);
            }

            techniqueWrapper = new BolzanoTechniqueWrapper(unfMech, rewriter, gen, eval_engine, apic);
            log.debug("Done setting up the technique wrapper");
            reasoner = new OBDAOWLReformulationPlatform(apic, manager, techniqueWrapper);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reasoner;
    }

    public String getReasonerName() {
        // assume for now that preferences define the reasoner name
        return preferences.toString();
    }
}
