package org.malai.model.generator

import java.util.List
import java.util.Hashtable
import java.util.ArrayList
import org.malai.model.generator.graph.GraphNode

import static extension org.malai.model.aspect.InteractorAspect.*
import fr.inria.diverse.malai.Interactor
import fr.inria.diverse.malai.Instrument
import fr.inria.diverse.malai.Action

/**
 * Represents the runtime state
 */
class Context
{		

	//Actions created by visited Interactors
	public List<Action> resolvedActions
	
	//Instruments activated by visited Actions
	public List<Instrument> activatedInstr
	
	//Visits counter for each Interactor 
	public Hashtable<Interactor,Integer> interactorsCounters
	
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
		interactorsCounters = new Hashtable<Interactor,Integer>
	}
	
	/**
	 * Select the next Interactor to be visited from 
	 * all instruments activated
	 * 
	 * Strategy :
	 * Get the less visited interactor (and visitable)
	 * If none return null
	 */
	def Interactor nextInteractor() {	

		val findMinInteractor = [Interactor l1, Interactor l2 | if(l1.getVisitCounter(this) < l2.getVisitCounter(this)){ l1 } else { l2 }]
		val visitableMask = [Interactor interactor | isVisitable(interactor) && interactor.getVisitCounter(this) < MAXVISITS]
		
		//Get all interactors, keep just visitables and select the less visited
		return activatedInstr.map[instr| instr.interactors].flatten.filter(visitableMask).reduce(findMinInteractor)
	}
	
	/**
	 * Get all visitable interactors from all activated instruments
	 */
	def List<Interactor> getVisitableInteractor(){
		val visitableMask = [Interactor interactor | isVisitable(interactor) && interactor.getVisitCounter(this) < MAXVISITS]
		return activatedInstr.map[instr| instr.interactors].flatten.filter(visitableMask).toList
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
	 * Return true if all dependencies of the interactor are resolved in this context
	 */
	def boolean isVisitable(Interactor interactor) {
		return interactor.action.dependencies.forall[dep | resolvedActions.contains(dep.srcAction)]
	}
	
	/**
	 * Clone the current instance of Context
	 */
	def Context copy(){
		val result = new Context(this.activatedInstr, this.resolvedActions)
		interactorsCounters.keySet.forEach[key | result.interactorsCounters.put(key,interactorsCounters.get(key))]
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