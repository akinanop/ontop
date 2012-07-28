package it.unibz.krdb.obda.owlrefplatform.core.reformulation;

import it.unibz.krdb.obda.model.Atom;
import it.unibz.krdb.obda.model.CQIE;
import it.unibz.krdb.obda.model.DatalogProgram;
import it.unibz.krdb.obda.model.OBDADataFactory;
import it.unibz.krdb.obda.model.OBDAException;
import it.unibz.krdb.obda.model.OBDAQuery;
import it.unibz.krdb.obda.model.Predicate;
import it.unibz.krdb.obda.model.Term;
import it.unibz.krdb.obda.model.Variable;
import it.unibz.krdb.obda.model.impl.OBDADataFactoryImpl;
import it.unibz.krdb.obda.ontology.Axiom;
import it.unibz.krdb.obda.ontology.ClassDescription;
import it.unibz.krdb.obda.ontology.OClass;
import it.unibz.krdb.obda.ontology.Ontology;
import it.unibz.krdb.obda.ontology.OntologyFactory;
import it.unibz.krdb.obda.ontology.Property;
import it.unibz.krdb.obda.ontology.PropertySomeClassRestriction;
import it.unibz.krdb.obda.ontology.PropertySomeRestriction;
import it.unibz.krdb.obda.ontology.impl.OntologyFactoryImpl;
import it.unibz.krdb.obda.ontology.impl.SubClassAxiomImpl;
import it.unibz.krdb.obda.ontology.impl.SubPropertyAxiomImpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeWitnessRewriter implements QueryRewriter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static OBDADataFactory fac = OBDADataFactoryImpl.getInstance();
	private static OntologyFactory ontFactory = OntologyFactoryImpl.getInstance();
	
	private static final Logger log = LoggerFactory.getLogger(TreeWitnessRewriter.class);

	private TreeWitnessReasonerLite reasoner = new TreeWitnessReasonerLite();
	
	
	@Override
	public void setTBox(Ontology ontology) {
		reasoner.setTBox(ontology);
	}
	
	@Override
	public void setCBox(Ontology sigma) {
		// TODO Auto-generated method stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	private static Atom getAtom(URI name, List<Term> terms) {
		return fac.getAtom(fac.getPredicate(name, terms.size()), terms);
	}



	private void rewriteCQ(CQIE cqie, DatalogProgram output) throws URISyntaxException {

		TreeWitnessQueryGraph query = new TreeWitnessQueryGraph(cqie);
		
		Set<TreeWitness> tws = getReducedSetOfTreeWitnesses(query);	
		
		{
			List<Atom> mainbody = new ArrayList<Atom>(query.getEdges().size());
			int pairIndex = 0;
			for (TreeWitnessQueryGraph.Edge edge : query.getEdges()) {
				System.out.println(edge);
				edge.setName(getQName(edge.getAtoms().toArray(new Atom[0])[0].getPredicate().getName(), ++pairIndex));				
				mainbody.add(getAtom(edge.getName(), query.getVariables()));
			}
		
			// if no binary predicates -- TO BE REWRITTEN
			if (mainbody.size() == 0)
				for (Atom a : cqie.getBody())
					mainbody.add(getAtom(getExtName(a.getPredicate().getName()), a.getTerms()));

			output.appendRule(fac.getCQIE(cqie.getHead(), mainbody));
		}

		for (TreeWitnessQueryGraph.Edge edge : query.getEdges()) {
			List<Atom> extAtoms = new ArrayList<Atom>(edge.getAtoms().size()); 
			for (Atom aa : edge.getAtoms()) {
				extAtoms.add(getAtom(getExtName(aa.getPredicate().getName()), aa.getTerms()));
				//log.debug("PREDICATE: " + aa.getPredicate());
				//for (Term t : aa.getTerms())
				//	log.debug("   TERM " +  t + " OF TYPE " + t.getClass());
			}

			output.appendRule(fac.getCQIE(getAtom(edge.getName(), query.getVariables()), extAtoms));
					
			for (TreeWitness tw : tws)
				if (tw.getDomain().contains(edge.getTerm0()) && tw.getDomain().contains(edge.getTerm1())) {
					// TREE WITNESS FORMULAS
					List<Atom> twf = new LinkedList<Atom>();
					List<Term> roots = new LinkedList<Term>(tw.getRoots());
					Term r0 = roots.get(0);
					twf.add(fac.getAtom(fac.getClassPredicate(getExtName(tw.getGenerator())), r0));
					for (Term rt : roots)
						if (!rt.equals(roots.get(0)))
							twf.add(fac.getEQAtom(rt, r0));
					for (Atom c : tw.getRootType()) {
						// TODO: REWRITE TO TAKE REFLEXIVITY INTO ACCOUNT
						if (c.getArity() == 1)
							twf.add(fac.getAtom(fac.getClassPredicate(getExtName(c.getPredicate().getName())), r0));
					}
					output.appendRule(fac.getCQIE(getAtom(edge.getName(), query.getVariables()), twf));
				}
				
		}

		Set<PropertySomeClassRestriction> gen = new HashSet<PropertySomeClassRestriction>();
		for (TreeWitness tw : tws)
			gen.add(tw.getGenerator());
		
		for (CQIE ext : getExtPredicates(cqie, gen))
			output.appendRule(ext);
	}
	
	@Override
	public OBDAQuery rewrite(OBDAQuery input) throws OBDAException {
		DatalogProgram dp = (DatalogProgram) input;
		DatalogProgram output = fac.getDatalogProgram(); // (cqie.getHead().getPredicate());

		for (CQIE cqie : dp.getRules()) {
			try {
				rewriteCQ(cqie, output);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		log.debug("REWRITTEN PROGRAM\n" + output);			
		DatalogProgram simplified = DatalogQueryServices.simplify(output,dp.getRules().get(0).getHead().getPredicate());
		log.debug("SIMPLIFIED PROGRAM\n" + simplified);
		DatalogProgram flattenned = DatalogQueryServices.flatten(simplified,dp.getRules().get(0).getHead().getPredicate());
		log.debug("FLATTENED PROGRAM\n" + flattenned);
		return flattenned;
//		return simplified;
	}

	private List<CQIE> getExtPredicates(CQIE cqie, Set<PropertySomeClassRestriction> gencon) throws URISyntaxException {																															

		List<CQIE> list = new LinkedList<CQIE>();
		
		Set<Predicate> exts = new HashSet<Predicate>();
		for (Atom a : cqie.getBody())
			exts.add(a.getPredicate());

		// GENERATING CONCEPTS

		for (PropertySomeClassRestriction some : gencon) {
			log.debug("GEN CON EXT: " + gencon);
			
			//exts.add(some.getPredicate());
			
			Term x = fac.getVariable("x");
			Atom genAtom = fac.getAtom(fac.getClassPredicate(getExtName(some)), x);

			//for (Predicate c : tbox.getConcepts())
			//	if (isSubsumed(c, some))
			//	{
			//		log.debug("EXT COMPUTE SUBCLASSES: " + c);
			//		list.add(fac.getCQIE(extAtom, fac.getAtom(c, x)));
			//	}

			//{
			//	Term w = fac.getVariable("w");
			//	Predicate someExt = fac.getObjectPropertyPredicate(getExtName(some.getPredicate().getName()));
			//	Atom ra = //getRoleAtom(some, x, w);
			//			(!some.isInverse()) ? fac.getAtom(someExt, x, w) : fac.getAtom(someExt, w, x);
			//	log.debug("ROLE ATOM: " + ra);
			//	// COMM
			//	// if(r.isSubsumed(f.getOWLObjectSomeValuesFrom(some.getProperty(),
			//	// f.getOWLThing()), some))
			//	list.add(fac.getCQIE(extAtom, ra));
			//}

			for (Property subprop : reasoner.getSubProperties(ontFactory.createObjectProperty(some.getPredicate().getName(), some.isInverse()))) {
				log.debug("PROPERTY: " + subprop);
				PropertySomeClassRestriction subgenconcept = ontFactory.createPropertySomeClassRestriction(subprop.getPredicate(), subprop.isInverse(), some.getFiller());
				for (ClassDescription subc : reasoner.getSubConcepts(subgenconcept)) {
					log.debug("  SUBCONCEPT: " + subc);
					 if (subc instanceof OClass) {
						log.debug("RULE FOR " + some + " DEFINED BY " + subc);
						list.add(fac.getCQIE(genAtom, fac.getAtom(((OClass)subc).getPredicate(), x)));
					 }
					 else if (subc instanceof PropertySomeClassRestriction) {
						 PropertySomeClassRestriction twg = (PropertySomeClassRestriction)subc;
						 Term w = fac.getVariable("w");
						 Atom a = (!twg.isInverse()) ? 
									fac.getAtom(twg.getPredicate(), x, w) : fac.getAtom(twg.getPredicate(), w, x);
						 list.add(fac.getCQIE(genAtom, a)); // TODO: filler 						 
					 }				
				}
			}
			
			for (Predicate role : reasoner.getRoles()) { 
			//	if (!p.isOWLBottomObjectProperty()) {
			//		if(isSubsumed(f.getOWLObjectSomeValuesFrom(p, f.getOWLThing()), some)) {
				{
					PropertySomeClassRestriction twg = ontFactory.createPropertySomeClassRestriction(role, false, reasoner.owlThing);
					if (reasoner.getSubConcepts(some).contains(twg)) {
						log.debug("RULE FOR " + some + " DEFINED BY " + twg);
						exts.add(role);
						Predicate someExt = fac.getObjectPropertyPredicate(getExtName(role.getName()));
						list.add(fac.getCQIE(genAtom, fac.getAtom(someExt, x, fac.getVariable("w"))));
					}
				}
				{
					PropertySomeClassRestriction twg = ontFactory.createPropertySomeClassRestriction(role, true, reasoner.owlThing);
					if (reasoner.getSubConcepts(some).contains(twg)) {
						log.debug("RULE FOR " + some + " DEFINED BY " + twg);
						exts.add(role);
						Predicate someExt = fac.getObjectPropertyPredicate(getExtName(role.getName()));
						list.add(fac.getCQIE(genAtom, fac.getAtom(someExt, fac.getVariable("w"), x)));
					}
				}
			//	list.add(fac.getCQIE(extAtom, getRoleAtom(p, x,
			// * w))); continue; }
			// * 
			// * for (OWLClassExpression c: getClasses()) if (!c.isOWLNothing() &&
			// * isSubsumed(f.getOWLObjectSomeValuesFrom(p, c), some))
			// * list.add(getCQIE(new Atom(uri, x), getRoleAtom(p, x, w), new
			// * Atom(new URI(c.asOWLClass().getIRI().toString()), w))); }
			}
		}

		
		 for (Predicate pred : exts) { 
			 log.debug("EXT PREDICATE: " + pred);
			 if (pred.getArity() == 1) { 
				 Term x = fac.getVariable("x");
				 Atom extAtom = fac.getAtom(fac.getClassPredicate(getExtName(pred.getName())), x); 		  
				 list.add(fac.getCQIE(extAtom, fac.getAtom(pred, x)));
				 
				 for (ClassDescription subc : reasoner.getSubConcepts(ontFactory.createClass(pred))) 
					 if (subc instanceof OClass) 
						 list.add(fac.getCQIE(extAtom, fac.getAtom(((OClass)subc).getPredicate(), x)));
					 else if (subc instanceof PropertySomeClassRestriction) {
						 PropertySomeClassRestriction twg = (PropertySomeClassRestriction)subc;
						 Term w = fac.getVariable("w");
						 Atom a = (!twg.isInverse()) ? 
									fac.getAtom(twg.getPredicate(), x, w) : fac.getAtom(twg.getPredicate(), w, x);
						 list.add(fac.getCQIE(extAtom, a)); // TODO: filler 						 
					 }
		  
				 //for (OWLObjectPropertyExpression p: r.getProperties()) 
				//	 if (!p.isOWLBottomObjectProperty() && r.isSubsumed(f.getOWLObjectSomeValuesFrom(p, f.getOWLThing()), ac))
				//		 list.add(getCQIE(getAtom(ext, x), getRoleAtom(p, x, fac.getVariable("w")))); 
			 } 
			 else if (pred.getArity() == 2) { 
				Term x = fac.getVariable("x");
				Term y = fac.getVariable("y"); 
				Atom extAtom = fac.getAtom(fac.getObjectPropertyPredicate(getExtName(pred.getName())), x, y);
				 
				for (Property sub : reasoner.getSubProperties(ontFactory.createProperty(pred)))
					list.add(fac.getCQIE(extAtom, (!sub.isInverse()) ? 
								fac.getAtom(sub.getPredicate(), x, y) : fac.getAtom(sub.getPredicate(), y, x))); 
			 } 
		 }
		 return list;
	}

	
	private static URI getExtName(URI name) throws URISyntaxException {
		return new URI(name.getScheme(), name.getSchemeSpecificPart(), "EXT_" + name.getFragment());
	}

	private static URI getExtName(PropertySomeClassRestriction some) throws URISyntaxException {
		URI property = some.getPredicate().getName();
		String fillerName = (some.getFiller() != null) ? some.getFiller().getPredicate().getName().getFragment() : "T";
		return new URI(property.getScheme(), property.getSchemeSpecificPart(), "EXT_" + property.getFragment()
				+ (some.isInverse() ? "_I_" : "_") + fillerName);
	}

	private static URI getQName(URI name, int pos) throws URISyntaxException {
		return new URI(name.getScheme(), name.getSchemeSpecificPart(), "Q_" + pos + "_" + name.getFragment());
	}

	private Set<TreeWitness> getReducedSetOfTreeWitnesses(TreeWitnessQueryGraph query) {
		Set<TreeWitness> treewitnesses = getTreeWitnesses(query);

		Set<TreeWitness> subtws = new HashSet<TreeWitness>(treewitnesses.size());
		for (TreeWitness tw : treewitnesses) {
			boolean subsumed = false;
			for (TreeWitness tw1 : treewitnesses)
				if (!tw.equals(tw1) && tw.getDomain().equals(tw1.getDomain()) && tw.getRoots().equals(tw1.getRoots()))
					if(reasoner.getSubConcepts(tw.getGenerator()).contains(tw1.getGenerator())) {
						log.debug("SUBSUMED: " + tw + " BY " + tw1);
						subsumed = true;
						break;
					}
			if (!subsumed)
				subtws.add(tw);
		}
		return subtws;
	}

	private Set<TreeWitness> getTreeWitnesses(TreeWitnessQueryGraph query) {
		log.debug("QUANTIFIED VARIABLES: " + query.getQuantifiedVariables());
		
		Set<TreeWitness> treewitnesses = new HashSet<TreeWitness>();
		
		for (Term v : query.getQuantifiedVariables()) {
			log.debug("VARIABLE " + v); 
			 
			treewitnesses.addAll(getTreeWitnessesForEdge(query, query.getIncidentEdges(v), Collections.singleton(v), 
					Collections.singleton(v), new HashSet<Atom>()));
		}
		
		 Set<TreeWitness> delta = new HashSet<TreeWitness>(); 
		 do 
			 for (TreeWitness tw : treewitnesses) 
				 if (tw.allRootsBound()) {
					 Set<TreeWitness> twa = new HashSet<TreeWitness>(); 
					 twa.add(tw);
					 saturateTreeWitnesses(query, treewitnesses, delta, new HashSet<TreeWitnessQueryGraph.Edge>(), twa); 
				 }
				 else
					 log.debug("IGNORING " + tw + " DUE TO NON-BOUND ROOTS");
		 while (treewitnesses.addAll(delta));
	
		return treewitnesses;
	}

	private void saturateTreeWitnesses(TreeWitnessQueryGraph query, Set<TreeWitness> completeTWs, Set<TreeWitness> delta, Set<TreeWitnessQueryGraph.Edge> handle, Set<TreeWitness> merged) { 
		boolean saturated = true; 
		
		for (TreeWitnessQueryGraph.Edge edge : query.getEdges()) { 
			if (handle.contains(edge)) {
				log.debug("HANDLE " + handle + " ALREADY CONTAINS EDGE " + edge);
				continue;
			}
			for (TreeWitness tw : merged) { 
				Term edgeRoot = null; 
				Term edgeNonRoot = null;
				if (tw.getRoots().contains(edge.getTerm0())) { 
					edgeRoot = edge.getTerm0(); 
					edgeNonRoot = edge.getTerm1(); 
				} 
				else if (tw.getRoots().contains(edge.getTerm1())) { 
					edgeRoot = edge.getTerm1(); 
					edgeNonRoot = edge.getTerm0(); 
				} 
				else 
					continue;
				
				log.debug("EDGE " + edge + " IS ADJACENT TO THE TREE WITNESS " + tw); 

				boolean found = false;
				for (TreeWitness twa : merged)
					if (twa.getDomain().contains(edgeNonRoot)) {
						log.debug("  HOWEVER IS CONTAINED IN " + twa);
						found = true;
					}
				if (found)
					continue;
				
				saturated = false; 
				for (TreeWitness twa : completeTWs)  
					if (twa.allRootsBound() && 
							twa.getRoots().contains(edgeRoot) && 
							twa.getDomain().contains(edgeNonRoot)) {
						Set<TreeWitness> newMerged = new HashSet<TreeWitness>(merged); 
						newMerged.add(twa);
						log.debug("    ATTACHING A TREE WITNESS " + twa);
						saturateTreeWitnesses(query, completeTWs, delta, handle, newMerged); 
					} 
				
				Set<TreeWitnessQueryGraph.Edge> newHandle = new HashSet<TreeWitnessQueryGraph.Edge>(handle); 
				newHandle.add(edge);
				log.debug("    ATTACHING A HANDLE " + edge);
				saturateTreeWitnesses(query, completeTWs, delta, newHandle, merged);  
			} 
		}

		// the roots of tree witnesses in merged are bound variables
				
		if (saturated && (handle.size() != 0)) { 
			log.debug("CHEKCING WHETHER THE HANDLE " + handle + " CAN BE ATTACHED TO THE FOLLOWING: "); 
			Set<Term> intdomain = new HashSet<Term>();
			Set<Term> introots = new HashSet<Term>();
			Set<Atom> endtype = new HashSet<Atom>(); 
			for (TreeWitness tw : merged) {
				log.debug("  " + tw);
				intdomain.addAll(tw.getDomain());
				introots.addAll(tw.getRoots());
				endtype.addAll(tw.getRootType());
			}
			delta.addAll(getTreeWitnessesForEdge(query, handle, introots, intdomain, endtype));
		}
	}
	 
	private List<TreeWitness> getTreeWitnessesForEdge(TreeWitnessQueryGraph query, Set<TreeWitnessQueryGraph.Edge> handle, Set<Term> introots, Set<Term> intdomain, Set<Atom> endtype) {		
		List<Property> props = new ArrayList<Property>(); 
		List<Atom> roottype = new ArrayList<Atom>(); 
		Set<Term> roots = new HashSet<Term>(); 

		for (TreeWitnessQueryGraph.Edge edge : handle)
			for (Atom a : edge.getAtoms()) {
				if ((a.getArity() == 1) || ((a.getArity() == 2) && a.getTerm(0).equals(a.getTerm(1)))) {
						// unary predicate or loop
						if (introots.contains(a.getTerm(0)))
							endtype.add(a);
						else
							roottype.add(a);
				}						
				else {
					assert (a.getArity() == 2); 
					if (introots.contains(a.getTerm(1))) {
						props.add(ontFactory.createProperty(a.getPredicate(), false));
						roots.add(a.getTerm(0)); 
					} 
					else {
						assert (introots.contains(a.getTerm(0)));
						props.add(ontFactory.createProperty(a.getPredicate(), true)); 
						roots.add(a.getTerm(1)); 
					}
				}
			} 
		// TODO: edges with all terms among roots!
		
		log.debug("  PROPERTIES " + props);
		log.debug("  ENDTYPE " + endtype);
		log.debug("  ROOTTYPE " + roottype);
	 
		List<TreeWitness> treewitnesses = new LinkedList<TreeWitness>();
		for (PropertySomeClassRestriction g : reasoner.getGenerators()) 
			if (isTreeWitness(g, props, endtype)) { 
				TreeWitness tw = new TreeWitness(g, roots, 
						query.getQuantifiedVariables().containsAll(roots), roottype, 
						intdomain); 
				log.debug("TREE WITNESS: " + tw);
				treewitnesses.add(tw); 
			} 
				
		return treewitnesses;
	}
	
	 private boolean isTreeWitness(PropertySomeClassRestriction g, List<Property> edges, Set<Atom> endtype) { 
		log.debug("      CHECKING " + g);		 
		for (Atom a : endtype) {
			 if (a.getArity() == 2) {
				 log.debug("        NO LOOPS AT ENDPOINTS: " + a);
				 return false; 
			 }
			 assert (a.getArity() == 1);
			 ClassDescription con = ontFactory.createClass(a.getPredicate());
			 if (!reasoner.getSubConcepts(con).contains(g.getFiller())) {
				 log.debug("        ENDTYPE TOO SPECIFIC: " + con + " FOR " + g.getFiller());
				 return false;
			 }
			 else
				 log.debug("        ENDTYPE IS FINE: " + con + " FOR " + g.getFiller());
		}
		Property genp = ontFactory.createProperty(g.getPredicate(), g.isInverse());
		for (Property p : edges) {
			if (!reasoner.getSubProperties(p).contains(genp)) {
				log.debug("        PROPERTY TOO SPECIFIC: " + p + " FOR " + genp);
				return false;
			}
			else
				log.debug("        PROPERTY IS FINE: " + p + " FOR " + genp);
		}
		log.debug("         ALL MATCHED"); 
		return true; 
	}

	 
}
