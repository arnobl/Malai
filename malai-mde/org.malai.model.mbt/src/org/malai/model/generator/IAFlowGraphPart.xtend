package org.malai.model.generator 
import java.util.List
import java.util.ArrayList
import fr.inria.IAFlowGraph.IAFlowGraphFactory
import fr.inria.IAFlowGraph.InteractionTransition
import org.malai.interaction.Transition
import org.malai.interaction.TerminalState
import org.malai.interaction.AbortingState
import org.malai.instrument.Link

import static extension org.malai.model.aspect.InteractionAspect.*


/**
 * Conversion of a Link to an IAFlowGraph
 * 
 * Contains an Interaction-Action flow graph
 * and paths from root to final/aborting states
 */
class IAFlowGraphPart{
	
	public List<List<InteractionTransition>> allPaths //Paths from root to final/aborting states
	
	public List<InteractionTransition> allTransitions
	public List<InteractionTransition> terminalTransitions
	public List<InteractionTransition> abortingTransitions
	
	new(Link link){
		allTransitions = new ArrayList<InteractionTransition>()
		terminalTransitions = new ArrayList<InteractionTransition>()
		abortingTransitions = new ArrayList<InteractionTransition>()
		allPaths = new ArrayList<List<InteractionTransition>>()
		
		var List<List<Transition>> paths = link.interaction.visit(new Context()) //need context parameter, but useless here
		paths.forEach[ p | addPathInGraph(p,link)]
	}
	
	/**
	 * Build the Interaction-Action flow graph from the path
	 * and store the path
	 * 
	 * @path Ordered transitions to be added in the graph
	 */
	private def void addPathInGraph(List<Transition> path, Link link){
		//Add path elements in the graph
		convertPath(path)
		
		//Store the path
		val List<InteractionTransition> convertedPath = new ArrayList<InteractionTransition>()
		path.forEach[tr |
			var firstTransition = allTransitions.findFirst[elem | elem.concreteTransition.equals(tr) ]
			convertedPath.add(firstTransition)
		]
		allPaths.add(convertedPath)
		
		//Bind Action on ending transitions
		terminalTransitions.forEach[elem | 
			elem.action = IAFlowGraphFactory.eINSTANCE.createResultingAction()
			elem.action.concreteAction = link.action
			elem.action.actionProduced = true
		]
		abortingTransitions.forEach[elem | 
			elem.action = IAFlowGraphFactory.eINSTANCE.createResultingAction()
			elem.action.concreteAction = link.action
			elem.action.actionProduced = false
		]
	}
	
	/** 
	 * Add Transitions of the path in the graph.
	 *
	 * @path Ordered transitions to be added in the graph
	 */
	private def void convertPath(List<Transition> path) {
		if(path.size > 0) {
			path.forEach[elem, index|
				if(! allTransitions.exists[e | e.concreteTransition.equals(elem)] ) {
					var InteractionTransition tr = IAFlowGraphFactory.eINSTANCE.createInteractionTransition()
					tr.concreteTransition = elem
					allTransitions.add(tr)
				}
	
				var InteractionTransition currentTransition = allTransitions.findFirst[e | e.concreteTransition.equals(elem) ]
				
				if(index > 0){
					var InteractionTransition from = allTransitions.findFirst[e | e.concreteTransition.equals(path.get(index-1)) ]
					if(!from.outgoingTransitions.contains(currentTransition))
						from.outgoingTransitions.add(currentTransition)
				}
				
				if(index == path.size-1){
					if(elem instanceof TerminalState ){
						terminalTransitions.add(currentTransition)
					}
					if(elem instanceof AbortingState ) {
						abortingTransitions.add(currentTransition)
					}
				}
			]
		}
	}
	
	/**
	 * Representation of the Interaction-Action flow graph in the DOT format
	 */
	def String print(){
		val StringBuffer res = new StringBuffer()
		res.append("digraph OutputGraph {\n")
		allTransitions.forEach[tr | 
			res.append(tr.hashCode+"[label=\""+tr.concreteTransition.name+"\"] \n")
			tr.outgoingTransitions.forEach[out | res.append(tr.hashCode+"->"+out.hashCode+"\n")]
		]
		res.append("}")
		return res.toString
	}
}