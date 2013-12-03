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
import static extension org.malai.model.aspect.TransitionAspect.*
import org.malai.instrument.Instrument
import org.malai.action.Action
import java.util.HashSet
import java.util.Collection
import java.util.HashMap
import java.util.Set

/**
 * Conversion of a Link to an IAFlowGraph
 * 
 * Contains an Interaction-Action flow graph
 * and paths from root to final/aborting states
 */
class IAFlowGraphPart{
	
	public List<List<InteractionTransition>> allPaths //Paths from root to final/aborting states
	
	public List<InteractionTransition> allTransitions
	public Collection<InteractionTransition> terminalTransitions
	public Collection<InteractionTransition> abortingTransitions
	
	new(){
		allTransitions = new ArrayList<InteractionTransition>()
		terminalTransitions = new HashSet<InteractionTransition>()
		abortingTransitions = new HashSet<InteractionTransition>()
		allPaths = new ArrayList<List<InteractionTransition>>()
	}
	
	new(Link link){
		allTransitions = new ArrayList<InteractionTransition>()
		terminalTransitions = new HashSet<InteractionTransition>()
		abortingTransitions = new HashSet<InteractionTransition>()
		allPaths = new ArrayList<List<InteractionTransition>>()
		
		var List<List<Transition>> paths = link.interaction.visit(new Context(new ArrayList<Instrument>, new ArrayList<Action> )) //need context parameter, but useless here
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
					if(elem.outputState instanceof TerminalState ){
						terminalTransitions.add(currentTransition)
					}
					if(elem.outputState instanceof AbortingState ) {
						abortingTransitions.add(currentTransition)
					}
				}
			]
		}
	}
	
	/**
	 * Representation of the Interaction-Action flow graph in the DOT format
	 */
	override String toString(){
		val StringBuffer res = new StringBuffer()
		res.append("digraph OutputGraph {\n")
		allTransitions.forEach[tr | 
			res.append(tr.hashCode+final2String(tr)+"[label=\""+condition2String(tr.concreteTransition)+tr.concreteTransition.event.name+"\"] \n")
			tr.outgoingTransitions.forEach[out | res.append(tr.hashCode+"->"+out.hashCode+"\n")]
		]
		res.append("}")
		return res.toString
	}
	
	/**
	 * @contentHashCode HashCode of the containing node 
	 */
	def String node2Graph(int contentHashCode){
		val StringBuffer res = new StringBuffer()
		allTransitions.forEach[tr | 
			res.append(contentHashCode+""+tr.hashCode+final2String(tr)+"[label=\""+condition2String(tr.concreteTransition)+tr.concreteTransition.event.name+"\"] \n")
			tr.outgoingTransitions.forEach[out | res.append(contentHashCode+""+tr.hashCode+"->"+contentHashCode+""+out.hashCode+"\n")]
		]
		return res.toString
	}
	
	def String condition2String(Transition t){
		if(t.conditionSolution != null) return t.conditionSolution+"\\n"
		return ""
	}
	
	def String final2String(InteractionTransition t){
		if(t.action!= null && t.action.actionProduced == true) return "[shape=box]"
		return ""
	}
	
	def void reduce(){
		val QuotientSet partition = Reducer.reduce(this)
		
		//First element of each class become the representative element
		val List<InteractionTransition> newAllTransitions = new ArrayList
		partition.partition.values.toSet.forEach[clazz | newAllTransitions.add(clazz.elements.get(0))]
		
		//Update outgoing transitions
		newAllTransitions.forEach[node | 
			val ArrayList<InteractionTransition> newOutput = new ArrayList
			node.outgoingTransitions.forEach[out |
				var tgtClass = partition.getEquivalenceClass(out)
				newOutput.add(tgtClass.elements.get(0))
			]
			node.outgoingTransitions.clear()
			node.outgoingTransitions.addAll(newOutput)
		]
		
		//Get new finals states
		val Collection<InteractionTransition> newTerminalTransitions = newAllTransitions.filter[t | t.action != null && t.action.actionProduced].toSet
		val Collection<InteractionTransition> newAbortingTransitions = newAllTransitions.filter[t | t.action != null && !t.action.actionProduced].toSet
		
		//Get new paths
		val List<List<InteractionTransition>> newAllPaths = new ArrayList
		allPaths.forEach[path |
			var newPath = path.map[tr | partition.getEquivalenceClass(tr).elements.get(0)].toList
			newAllPaths.add(newPath)
		]
		
		//Update the graph
		allTransitions = newAllTransitions
		terminalTransitions = newTerminalTransitions
		abortingTransitions = newAbortingTransitions
		allPaths = newAllPaths
	}
}

/**
 * Class to minimize a IAFlowGraphPart
 * 
 * ie: "equivalent" nodes are merged 
 */
class Reducer{

	/**
	 * Initial partition of an Interaction
	 * Final states are in one part, others states are in the other part
	 */
	private static def QuotientSet initPartition(List<InteractionTransition> init){
		
		var finalStates  = init.filter[state | state.outgoingTransitions.empty].toList
		var otherStates = init.filter[state | !state.outgoingTransitions.empty].toList
		
		val partOne = new EquivalenceClass(finalStates)
		val partTwo = new EquivalenceClass(otherStates)
		
		var List<EquivalenceClass> parts = new ArrayList<EquivalenceClass>()
		parts.add(partOne)
		parts.add(partTwo)
		
		return new QuotientSet(parts)
	}
	
	/**
	 * Compute the refinement of the partition
	 */
	static def QuotientSet reduce(IAFlowGraphPart graph){

		var oldPartition = initPartition(graph.allTransitions)
		var newPartition = oldPartition.slice

		while(!oldPartition.equals(newPartition)){
			oldPartition = newPartition
			newPartition = oldPartition.slice
		}
		return newPartition
	}
}

/**
 * Set of equivalences classes of a graph
 * Nodes of a same graph are in only one equivalence class
 */
class QuotientSet{
	
	protected HashMap<InteractionTransition,EquivalenceClass> partition
	
	new(){
		partition = new HashMap<InteractionTransition,EquivalenceClass>()
	}
	new(List<EquivalenceClass> classes){
		partition = new HashMap<InteractionTransition,EquivalenceClass>()
		classes.forEach[equalClass |
			equalClass.elements.forEach[elem | partition.put(elem,equalClass)]
		]
	}
	
	def put(InteractionTransition i, EquivalenceClass c){
		partition.put(i,c)
	}
	
	def EquivalenceClass getEquivalenceClass(InteractionTransition node){
		return partition.get(node)
	}
	
	/**
	 * Compare two partitions
	 */
	def equals(QuotientSet other){
		var boolean result = true
		
		var srcClasses = partition.values.toSet
		var tgtClasses = other.partition.values.toSet
		for(EquivalenceClass srcClass : srcClasses){
			if(!tgtClasses.exists[tgtClass | srcClass.equals(tgtClass)]) return false
		}
		
		return result
	}
	
	/**
	 * Compute one iteration of the partition refinement
	 * 
	 * Each elements of an equivalence class of the partition must have the 
	 * same name and the same outgoing equivalences classes, otherwise the
	 * equivalence class is sliced
	 */
	def QuotientSet slice(){
		
		val newPartition = new QuotientSet()
		
		var classes = partition.values.toSet
		classes.forEach[equalClass |
			
			var firstElem = equalClass.elements.get(0)
			var newClass = new EquivalenceClass()
			newClass.add(firstElem)
			newPartition.put(firstElem,newClass)
			
			if(equalClass.elements.size > 1){
				var int i = 1
				while( i < equalClass.elements.size){
					val elem = equalClass.elements.get(i)
					//Try to add elem in an existing class
					var isAdded = false
					var int j = 0
					while(j < i && !isAdded){
						var prevElem = equalClass.elements.get(j)
						if(isInSameClass(elem, prevElem)){
							newPartition.getEquivalenceClass(prevElem).add(elem)
							newPartition.put(elem,newPartition.getEquivalenceClass(prevElem))
							isAdded = true
						}
						j = j + 1
					}
					//If not added in an existing class, create its own class
					if(!isAdded){
						var ownClass = new EquivalenceClass()
						ownClass.add(elem)
						newPartition.put(elem,ownClass)
					}
					i = i + 1;
				}
			}
		]
		return newPartition
	}
	
	/**
	 * Compare concrete transition and outgoing equivalences classes
	 */
	def boolean isInSameClass(InteractionTransition node1, InteractionTransition node2){
		var boolean result = true
		
		//Look if nodes can't be merged
		if(node1.concreteTransition.event != node2.concreteTransition.event) return false
		if(node1.concreteTransition.conditionSolution != node2.concreteTransition.conditionSolution) return false
		if(node1.action == null && node2.action != null) return false
		if(node1.action != null && node2.action == null) return false
		if(node1.action?.actionProduced != node2.action?.actionProduced ||
			node1.action?.concreteAction != node2.action?.concreteAction )
			return false
		
		//Get classes where outgoing transitions are ending
		var Set<EquivalenceClass> out1 = node1.outgoingTransitions.map[elem | partition.get(elem)].toSet
		var Set<EquivalenceClass> out2 = node2.outgoingTransitions.map[elem | partition.get(elem)].toSet
		if(out1.size != out2.size) return false
		if(!out1.containsAll(out2)) return false
		
		return result
	}
	
	override String toString(){
		val StringBuffer result = new StringBuffer
		
		partition.values.toSet.forEach[clazz | 
			result.append(clazz.elements.join("{",",","}",[e | e.concreteTransition.event.name+"["+e.concreteTransition.hashCode+"]"]))
		]
		
		return result.toString
	}
}

/**
 * A subset of nodes from the graph
 */
class EquivalenceClass{
	
	//Nodes
	package List<InteractionTransition> elements
	
	new(){
		elements = new ArrayList<InteractionTransition>()
	}
	
	new(List<InteractionTransition> elems){
		elements = new ArrayList<InteractionTransition>()
		elements.addAll(elems)
	}
	
	def add(InteractionTransition e){
		elements.add(e)
	}
	
	def remove(InteractionTransition e){
		elements.remove(e)
	}
	
	/**
	 * Compare two EquivalenceClass
	 */
	def equals(EquivalenceClass other){
		var boolean result = false
		
		if(elements.size == other.elements.size){
			result = elements.containsAll(other.elements)
		}
		
		return result
	}
}