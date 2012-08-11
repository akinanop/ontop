package it.unibz.krdb.obda.owlrefplatform.core.reformulation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibz.krdb.obda.model.Atom;
import it.unibz.krdb.obda.model.Term;
import it.unibz.krdb.obda.ontology.PropertySomeClassRestriction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TreeWitness class defines tree witnesses as in the KR 2012 paper
 *     each tree witness is determined by its domain, roots and the \exists R.B concept 
 *           that generates a tree in the TBox canonical model to embed the tree witness
 *     each instance also stores those atoms of the query with all terms among the roots of the tree witness 
 *      
 *     all this information is enough to produce the tree witness formula tw_f 
 * @author roman
 *
 */

public class TreeWitness {
	private Set<Term> domain; // terms that are covered by the tree witness
	private Set<Term> roots;   // terms that are mapped onto the root of the tree witness
	private Set<Atom> roottype; // atoms of the query that contain only the roots of the tree witness
	                            // these atoms must hold true for this tree witness to be realised
	private TreeWitnessGenerator gen; // the \exists R.B concept that realises the tree witness 
	                                          // in the canonical model of the TBox

	private boolean allRootsBound;

	public TreeWitness(TreeWitnessGenerator gen, Set<Term> roots, boolean allRootsBound, Set<Atom> roottype, Set<Term> nonroots) {
		this.gen = gen;
		this.roots = roots;
		this.allRootsBound = allRootsBound;
		this.roottype = roottype;
		this.domain = new HashSet<Term>(roots);
		domain.addAll(nonroots);
	}

	public Set<Term> getRoots() {
		return roots;
	}
	
	public boolean allRootsBound() {
		return allRootsBound;
	}
	
	public Set<Term> getDomain() {
		return domain;
	}
	
	public TreeWitnessGenerator getGenerator() {
		return gen;
	}
	
	public Set<Atom> getRootType() {
		return roottype;
	}
	
	@Override
	public String toString() {
		return "tree witness generated by " + gen + "\n    with domain " + domain + " and roots " + roots + " of type " + roottype;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TreeWitness) {
			TreeWitness other = (TreeWitness)obj;
			return (this.hashCode() == other.hashCode()) && 
					this.gen.equals(other.gen) &&
					this.roots.equals(other.roots) && 
					this.roottype.equals(other.roottype) && 
					this.domain.equals(other.domain);			
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return gen.hashCode() ^ roots.hashCode() ^ roottype.hashCode() ^ domain.hashCode(); 
	}
}
