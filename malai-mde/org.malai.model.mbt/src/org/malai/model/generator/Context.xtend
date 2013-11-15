package org.malai.model.generator

import org.malai.action.Action
import java.util.List
import org.malai.instrument.Instrument
import org.malai.instrument.Link
import java.util.Hashtable
import java.util.ArrayList
import org.malai.model.generator.graph.GraphNode

import static extension org.malai.model.aspect.LinkAspect.*

/**
 * Represents the runtime state
 */
class Context
{		

	//Actions created by visited Links
	public List<Action> resolvedActions
	
	//Instruments activated by visited Actions
	public List<Instrument> activatedInstr
	
	//Visits counter for each Link 
	public Hashtable<Link,Integer> linksCounters
	
	//PARAMETER
	private int MAXVISITS
	
	//Root used to attach futur nodes of the context
	public GraphNode attachNode
	
	new(List<Instrument> activInstr, List<Action> resAction ) {
		MAXVISITS = 1
		resolvedActions = new ArrayList<Action>()
		resolvedActions.addAll(resAction)
		activatedInstr = new ArrayList<Instrument>()
		activatedInstr.addAll(activInstr)
		linksCounters = new Hashtable<Link,Integer>
	}
	
	/**
	 * Select the next Link to be visited from 
	 * all instruments activated
	 * 
	 * Strategy :
	 * Get the less visited link (and visitable)
	 * If none return null
	 */
	def Link nextLink() {	

		val findMinLink = [Link l1, Link l2 | if(l1.getVisitCounter(this) < l2.getVisitCounter(this)){ l1 } else { l2 }]
		val visitableMask = [Link link | isVisitable(link) && link.getVisitCounter(this) < MAXVISITS]
		
		//Get all links, keep just visitables and select the less visited
		return activatedInstr.map[instr| instr.links].flatten.filter(visitableMask).reduce(findMinLink)
	}
	
	/**
	 * Get all visitable links from all activated instruments
	 */
	def List<Link> getVisitableLink(){
		val visitableMask = [Link link | isVisitable(link) && link.getVisitCounter(this) < MAXVISITS]
		return activatedInstr.map[instr| instr.links].flatten.filter(visitableMask).toList
	}
	
	/**
	 * Add an executed action in the current context
	 */
	def void addSolvedAvtion(Action act) {
		resolvedActions.add(act)
	}
	
	/**
	 * Add a usable instrument 
	 */
	def void activateInstrument(Instrument instr) {
		activatedInstr.add(instr)
	}		

	/**
	 * Remove an instrument
	 */ 
	def inactivateInstrument(Instrument instr) {
		activatedInstr.remove(instr)
	}
	
	/**
	 * Return true if all dependencies of the link are resolved in this context
	 */
	def boolean isVisitable(Link link) {
		return link.action.dependencies.forall[dep | resolvedActions.contains(dep.srcAction)]
	}
	
	/**
	 * Clone the current instance of Context
	 */
	def Context copy(){
		val result = new Context(this.activatedInstr, this.resolvedActions)
		linksCounters.keySet.forEach[key | result.linksCounters.put(key,linksCounters.get(key))]
		return result
	}
	
	override String toString() {
		val res = new StringBuffer()
	
		res.append("-----------------------------------------\n")
		activatedInstr.forEach[ i | res.append("{"+ i.name +"}\n")]
		resolvedActions.forEach[a | res.append("["+ a.name +"]\n")]
		res.append("-----------------------------------------\n")
		
		return res.toString()
	}
}