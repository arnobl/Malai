package org.malai.model.generator

import fr.inria.diverse.interactiveSystem.interactiveSystem
import java.util.List
import fr.inria.diverse.malai.Interactor
import java.util.ArrayList
import fr.inria.diverse.malai.Action
import org.malai.model.generator.graph.Graph
import org.malai.model.generator.graph.GraphNode
import static extension org.malai.model.aspect.InteractorAspect.*
import java.util.HashMap
import java.util.HashSet

class AllPairGenerator extends Generator{
	
	val HashSet<List> visited //store visited pairs
	val HashMap<Interactor,HashMap<Interactor,List<Interactor>>> rapidAccess //rapid access to pairs
	val List<List<Interactor>> pairs //Probable pairs of Interactors
	
	new(interactiveSystem systemModel) {
		super(systemModel)
		
		visited = new HashSet
		rapidAccess = new HashMap
		pairs = all_pairs()
		pairs.forEach[pair | 
			var HashMap<Interactor,List<Interactor>> map = rapidAccess.get(pair.get(0))
			if(map == null){
				map = new HashMap
				rapidAccess.put(pair.get(0),map)
			}
			map.put(pair.get(1),pair)
		]
	}
	
	override Graph run(){
		
		val pairs = all_pairs()
		
		val result = new Graph
		//Init root node
		contexts.head.attachNode = result.createNode()
		result.rootNode = contexts.head.attachNode
		currentNode = result.rootNode
		
		//Then visit interactors
		while (!contexts.isEmpty){
			val currentContext = contexts.head
			currentNode = currentContext.attachNode
			var Interactor currentInteractor = currentNode.relatedInteractor

			//Visit all interactors
			var int i = currentContext.visitableInteractor.size - 1
			while(i >= 0){
				var Interactor nextInteractor = currentContext.visitableInteractor.get(i)
				
				var pair = getPair(currentInteractor,nextInteractor)
				if(currentInteractor == null){ //Is the root node
					//Update graph
					var GraphNode nextNode = result.createNode()
					nextNode.relatedInteractor = nextInteractor
					currentNode.addChildren(nextNode)
						
					var newContext = currentContext.copy()
					newContext.attachNode = nextNode
					addContext(newContext)
					
					nextInteractor.visit(newContext, this)
				}
				else if(!visited.contains(pair)){ //Pair not yet visited
					//Update graph
					var GraphNode nextNode = result.createNode()
					nextNode.relatedInteractor = nextInteractor
					currentNode.addChildren(nextNode)
						
					var newContext = currentContext.copy()
					newContext.attachNode = nextNode
					addContext(newContext)
					
					nextInteractor.visit(newContext, this)

					visited.add(pair)

				}
				i = i - 1
			}
			contexts.remove(currentContext)
		}
		
		return result
	}
	
	def int getCoverage(){
		return visited.size
	}
	
	/**
	 * Find the pair of these two Interactors
	 * Return null if not found
	 */
	def getPair(Interactor one, Interactor two){
		var levelOne = rapidAccess.get(one)
		if(levelOne == null){
			return null
		} 
		else{
			var pair = levelOne.get(two)
			return pair
		}
	}
	
//	def void visit(Link lastLink, Context context, List<List<Link>> visitablePairs){
//		
//		if(visitablePairs.empty){
//			return
//		}
//		
//		val visitables = context.visitableLink
//		val pair = select(lastLink, visitables, visitablePairs)
//		
//		if(pair != null){
//			visitablePairs.remove(pair)
//			pair.get(1).visit(context,)
//			visitablePairs.add(pair)
//		}
//		else{
//			//some unvisitables pair
//		}
//		
//	}
	
	/**
	 * Compute all pairs of Interactors
	 * Pairs where the first Interactor deactivate the Instrument of the second Interactor are not included 
	 */
	def List<List<Interactor>> all_pairs(){
		val List<List<Interactor>> res = new ArrayList
		
		val List<Interactor> range = new ArrayList
		range.addAll(this.interactiveSystem.instruments.map[interactors].flatten)
		
		range.forEach[interactor1 |
			range.forEach[interactor2 | 
				if(!interactor1.action.deactivatedInstruments.contains(interactor2.instrument)){
					var pair = new ArrayList
					pair.add(interactor1)
					pair.add(interactor2)
					res.add(pair)
//					println(link1.name+","+link2.name)
				}
			]
		]
		
		res
	}
	
	/**
	 * Find the first pair that pair(0) == lastInteractor and pair(1) is in visitables
	 * Return null if none
	 */
	def List<Interactor> select(Interactor lastInteractor, List<Interactor> visitables, List<List<Interactor>> visitablePairs){
		var pair = visitablePairs.findFirst[p |
			visitables.exists[nextInteractor | isEqual(lastInteractor, nextInteractor, p)]
		]
		return pair
	}
	
	/**
	 * Return true if one == pair(0) and two == pair(1)
	 */
	def boolean isEqual(Interactor one, Interactor two, List<Interactor> pair){
		return (pair.size == 2 && pair.get(0) == one && pair.get(1) == two)
	}
}