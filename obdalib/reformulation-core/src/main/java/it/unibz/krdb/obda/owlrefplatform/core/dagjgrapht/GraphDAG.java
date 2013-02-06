package it.unibz.krdb.obda.owlrefplatform.core.dagjgrapht;

/** Interface for the GraphDAG class that starting from a graph build a DAG 
 * considering equivalences, redundancies and transitive reduction */

public interface GraphDAG {


	//obtain the graph
	public DAGImpl getDAG();


}
