/*
 * Copyright (C) 2009-2013, Free University of Bozen Bolzano
 * This source code is available under the terms of the Affero General Public
 * License v3.
 * 
 * Please see LICENSE.txt for full license terms, including the availability of
 * proprietary exceptions.
 */
package it.unibz.krdb.obda.owlrefplatform.core.dagjgrapht;

import it.unibz.krdb.obda.ontology.BasicClassDescription;
import it.unibz.krdb.obda.ontology.Ontology;
import it.unibz.krdb.obda.ontology.OntologyFactory;
import it.unibz.krdb.obda.ontology.Property;
import it.unibz.krdb.obda.ontology.PropertySomeRestriction;
import it.unibz.krdb.obda.ontology.impl.OntologyFactoryImpl;

import java.util.HashSet;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Allows to reason over the TBox using  DAG or graph
 * 
 */

public class TBoxReasonerImpl implements TBoxReasoner {

	private final DefaultDirectedGraph<Property,DefaultEdge> propertyGraph; // test only
	private final DefaultDirectedGraph<BasicClassDescription,DefaultEdge> classGraph; // test only

	private final EquivalencesDAGImpl<Property> propertyDAG;
	private final EquivalencesDAGImpl<BasicClassDescription> classDAG;
	
	
	public TBoxReasonerImpl(Ontology onto) {
		propertyGraph = OntologyGraph.getPropertyGraph(onto);
		propertyDAG = new EquivalencesDAGImpl<Property>(propertyGraph);
		
		classGraph = OntologyGraph.getClassGraph(onto, propertyGraph, false);
		classDAG = new EquivalencesDAGImpl<BasicClassDescription>(classGraph);

		DAGBuilder.choosePropertyRepresentatives(propertyDAG);
		DAGBuilder.chooseClassRepresentatives(classDAG, propertyDAG);
	}

	private TBoxReasonerImpl(DefaultDirectedGraph<Property,DefaultEdge> propertyGraph, 
					DefaultDirectedGraph<BasicClassDescription,DefaultEdge> classGraph) {
		this.propertyGraph = propertyGraph;
		propertyDAG = new EquivalencesDAGImpl<Property>(propertyGraph);
		
		this.classGraph = classGraph;
		classDAG = new EquivalencesDAGImpl<BasicClassDescription>(classGraph);

		DAGBuilder.choosePropertyRepresentatives(propertyDAG);
		DAGBuilder.chooseClassRepresentatives(classDAG, propertyDAG);
	}

	


	@Override
	public String toString() {
		return propertyDAG.toString() + "\n" + classDAG.toString();
	}
	
	
		
	
	/**
	 * Return all the nodes in the DAG or graph
	 * 
	 * @return we return a set of set of description to distinguish between
	 *         different nodes and equivalent nodes. equivalent nodes will be in
	 *         the same set of description
	 */

	@Override
	public EquivalencesDAG<BasicClassDescription> getClasses() {
		return classDAG;
	}

	public EquivalencesDAG<Property> getProperties() {
		return propertyDAG;
	}
	
	
	// INTERNAL DETAILS
	

	
	
	@Deprecated // test only
	public DefaultDirectedGraph<BasicClassDescription,DefaultEdge> getClassGraph() {
		return classGraph;
	}
	
	@Deprecated // test only
	public DefaultDirectedGraph<Property,DefaultEdge> getPropertyGraph() {
		return propertyGraph;
	}
	
	@Deprecated // test only
	public int edgeSetSize() {
		return propertyDAG.edgeSetSize() + classDAG.edgeSetSize();
	}
	
	@Deprecated // test only
	public int vertexSetSize() {
		return propertyDAG.vertexSet().size() + classDAG.vertexSet().size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static TBoxReasonerImpl getChainReasoner2(Ontology onto) {
//		
//		return new TBoxReasonerImpl((OntologyGraph.getGraph(onto, true)));		
//	}
	
	/***
	 * Modifies the DAG so that \exists R = \exists R-, so that the reachability
	 * relation of the original DAG gets extended to the reachability relation
	 * of T and Sigma chains.
	 * 
	 * 
	 */
	
	public static TBoxReasonerImpl getChainReasoner(Ontology onto) {
		TBoxReasonerImpl tbox = new TBoxReasonerImpl(onto);
		
		
		EquivalencesDAG<BasicClassDescription> classes = tbox.getClasses();
		
		// move everything to a graph that admits cycles
		DefaultDirectedGraph<BasicClassDescription,DefaultEdge> modifiedGraph = 
				new  DefaultDirectedGraph<BasicClassDescription,DefaultEdge>(DefaultEdge.class);

		// clone all the vertex and edges from dag
		for (Equivalences<BasicClassDescription> v : classes) 
			modifiedGraph.addVertex(v.getRepresentative());
		
		for (Equivalences<BasicClassDescription> v : classes) {
			BasicClassDescription s = v.getRepresentative();
			for (Equivalences<BasicClassDescription> vp : classes.getDirectSuper(v))
				modifiedGraph.addEdge(s, vp.getRepresentative());
		}

		OntologyFactory fac = OntologyFactoryImpl.getInstance();
		HashSet<BasicClassDescription> processedNodes = new HashSet<BasicClassDescription>();
		
		for (Equivalences<BasicClassDescription> existsNode : classes) {
			BasicClassDescription node = existsNode.getRepresentative();
			
			if (!(node instanceof PropertySomeRestriction) || processedNodes.contains(node)) 
				continue;

			/*
			 * Adding a cycle between exists R and exists R- for each R.
			 */

			PropertySomeRestriction exists = (PropertySomeRestriction) node;
			Equivalences<BasicClassDescription> existsInvNode = classes.getVertex(
						fac.createPropertySomeRestriction(exists.getPredicate(), !exists.isInverse()));
			
			for (Equivalences<BasicClassDescription> children : classes.getDirectSub(existsNode)) {
				BasicClassDescription child = children.getRepresentative(); 
				if (!child.equals(existsInvNode))
					modifiedGraph.addEdge(child, existsInvNode.getRepresentative());
			}
			for (Equivalences<BasicClassDescription> children : classes.getDirectSub(existsInvNode)) {
				BasicClassDescription child = children.getRepresentative(); 
				if (!child.equals(existsNode))
					modifiedGraph.addEdge(child, existsNode.getRepresentative());
			}

			for (Equivalences<BasicClassDescription> parents : classes.getDirectSuper(existsNode)) {
				BasicClassDescription parent = parents.getRepresentative(); 
				if (!parent.equals(existsInvNode))
					modifiedGraph.addEdge(existsInvNode.getRepresentative(), parent);
			}

			for (Equivalences<BasicClassDescription> parents : classes.getDirectSuper(existsInvNode)) {
				BasicClassDescription parent = parents.getRepresentative(); 
				if (!parent.equals(existsInvNode))
					modifiedGraph.addEdge(existsNode.getRepresentative(), parent);
			}

			processedNodes.add(existsNode.getRepresentative());
			processedNodes.add(existsInvNode.getRepresentative());
		}

		/* Collapsing the cycles */
		return new TBoxReasonerImpl(tbox.propertyGraph, modifiedGraph);
	}

}
