package org.malai.model.aspect

import fr.inria.triskell.k3.Aspect
import fr.inria.triskell.k3.OverrideAspectMethod
import java.util.ArrayList
import java.util.List
import org.malai.action.Action
import org.malai.instrument.Instrument
import org.malai.instrument.Link
import org.malai.interaction.AbortingState
import org.malai.interaction.Interaction
import org.malai.interaction.InteractionFactory
import org.malai.interaction.State
import org.malai.interaction.TerminalState
import org.malai.interaction.Transition
import org.malai.model.conditionSolver.Parser
import org.malai.model.generator.Context
import org.malai.model.generator.Generator

import static extension org.malai.model.aspect.ActionAspect.*
import static extension org.malai.model.aspect.LinkAspect.*
import static extension org.malai.model.aspect.StateAspect.*
import static extension org.malai.model.aspect.TransitionAspect.*

@Aspect(className=typeof(Instrument))
class InstrumentAspect {

	def void visit(Context context, Generator generator) {
		_self.links.forEach[elem | elem.visit(context, generator)]
	}
}

@Aspect(className=typeof(Link))
class LinkAspect{
	
	/**
	 * Retrieve the number of visits in this Context
	 */
	def int getVisitCounter(Context context) {
		var Integer visitCounter = context.linksCounters.get(_self)
		if(visitCounter == null){
			return 0
		}
		return visitCounter
	}
	
	/**
	 * Increment the number of visits in this Context
	 */
	def void incrVisitCounter(Context context ) {
		var int visitCounter = _self.getVisitCounter(context)
		context.linksCounters.put(_self, visitCounter+1)
	}

	/**
	 * Visits the link and creates contexts for each possibles interactions
	 */
	def void visit(Context context, Generator generator) {
	
		_self.incrVisitCounter(context)
		
		_self.interaction.states.forEach[state|
			
			if(state instanceof TerminalState){
				var newContext = context.copy()
				newContext.attachNode = generator.currentNode
				generator.addContext(newContext)
				_self.action.visit(newContext)
			}
		]
	}
}


@Aspect(className=typeof(Interaction))
class InteractionAspect{

	/**
	 * Visits all paths and return paths to TerminalState & AbortingState
	 */
	def List<List<Transition>>  visit(Context context) {

		_self.states.forEach[s | s.nbVisits = 0]
		
		if(_self.initState != null) {
			var List<Transition> visitedTransitions = new ArrayList<Transition>()
			return _self.initState.visit(context,visitedTransitions)
		}
		else{
			return new ArrayList<List<Transition>>();
		}
	}
}
	
@Aspect(className=typeof(State))
class StateAspect{

	var int nbVisits
	
	/**
	 * Config: Number of allowed loops
	 */
	def int nbMaxVisits() {
		return 3
	}

	/**
	 * Return all paths to finals states from this State
	 */
	def List<List<Transition>> visit(Context context, List<Transition> visitedTransition) {
	
		val result = new ArrayList<List<Transition>>()
	
		if(_self.nbVisits == 0) {				
			//Spliting transitions with condition parsing
			val List<Transition> toBeAdded = new ArrayList<Transition>()
			_self.outputTransitions.forEach[elem | 
				if(elem.condition != null) {
					toBeAdded.addAll(_self.splitTransition(elem))
				}
				]
			_self.outputTransitions.addAll(toBeAdded)
		}
		
		if(_self.nbVisits < _self.nbMaxVisits) {
			_self.nbVisits = _self.nbVisits + 1		
			_self.outputTransitions.forEach[elem | 
					visitedTransition.add(elem)
					var List<List<Transition>> paths
					paths = elem.visit(context,visitedTransition)
					result.addAll(paths.filter[e | e.size() > 0])
					visitedTransition.remove(elem)
				]
		}		
		return result		
	}
	
	/**
	 * If a condition is linked to the transition, it will be solved and the transition
	 * will be split as many as solutions found.
	 * 
	 * @return Copies of 't'
	 */
	def List<Transition> splitTransition(Transition t) {
		val res = new ArrayList<Transition>()

		if (t.conditionSolution == null) {
			var parser = new Parser()
			var List<String> sols = parser.getSolutions(t.condition)
			sols.forEach[sol,index |
				if(index == 0) {
					t.conditionSolution = sol
					}
				else{
					var Transition newTr = t.copy()
					newTr.conditionSolution = sol
					res.add(newTr)
				}
				]
		}
		return res
	}
}

@Aspect(className=typeof(TerminalState))
class TerminalStateAspect extends StateAspect{

	/**
	 * Return a collection containing the path to the TerminalState
	 */
	@OverrideAspectMethod
	def List<List<Transition>> visit(Context context, List<Transition> visitedTransition) {
		
		var result = new ArrayList<List<Transition>>
		val List<Transition> clonedPath = new ArrayList<Transition>()
		visitedTransition.forEach[e | clonedPath.add(e)] //Protection to side effect
		result.add(clonedPath)
		return result
	}
}

@Aspect(className=typeof(AbortingState))
class AbortingStateAspect extends StateAspect{

	/**
	 * Return a collection containing the path to the AbordingState
	 */
	@OverrideAspectMethod
	def List<List<Transition>> visit(Context context, List<Transition> visitedTransition) {
		
		var result = new ArrayList<List<Transition>>()
		val List<Transition> clonedPath = new ArrayList<Transition>()
		visitedTransition.forEach[e | clonedPath.add(e)] //Protection to side effect
		result.add(clonedPath)
		return result;
	}
}
	
@Aspect(className=typeof(Transition))
class TransitionAspect{

	//If not null: the transition was splited to catch solutions of the condition
	var String conditionSolution

	def List<List<Transition>> visit(Context context, List<Transition> visitedTransition) {
		return _self.outputState.visit(context,visitedTransition)
	}
	
	//Dummy clone
	def Transition copy() {
		var result = InteractionFactory.eINSTANCE.createTransition();
		result.inputState = _self.inputState
		result.outputState = _self.outputState
		result.description = _self.description
		result.event = _self.event
		result.condition = _self.condition
		result.actions = _self.actions
		result.name = _self.name
		result.hid = _self.hid
		return result
	}
	
}


@Aspect(className=typeof(Action))
class ActionAspect{

	/**
	 * Update the context
	 */
	def void visit(Context context) {
		//This action may cancel resolved actions
		val ArrayList toRemove = new ArrayList() 
		context.resolvedActions.forEach[action | 
			if(action.cancelledBy.exists[dep | _self.name.equals(dep.name)]){
				toRemove.add(action)
			}
		]
		toRemove.forEach[cancelled | context.resolvedActions.remove(cancelled)]
		
		context.addSolvedAvtion(_self)
	}
}