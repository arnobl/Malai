package org.malai.model.generator

import fr.inria.diverse.interactiveSystem.interactiveSystem
import java.util.List
import fr.inria.diverse.malai.Link
import java.util.ArrayList
import fr.inria.diverse.malai.Action
import org.malai.model.generator.graph.Graph
import org.malai.model.generator.graph.GraphNode
import static extension org.malai.model.aspect.LinkAspect.*
import java.util.HashMap
import java.util.HashSet

class AllPairGenerator extends Generator{
	
	val HashSet<List> visited //store visited pairs
	val HashMap<Link,HashMap<Link,List<Link>>> rapidAccess //rapid access to pairs
	val List<List<Link>> pairs //Probable pairs of Links
	
	new(interactiveSystem systemModel) {
		super(systemModel)
		
		visited = new HashSet
		rapidAccess = new HashMap
		pairs = all_pairs()
		pairs.forEach[pair | 
			var HashMap<Link,List<Link>> map = rapidAccess.get(pair.get(0))
			if(map == null){
				map = new HashMap
				rapidAccess.put(pair.get(0),map)
			}
			map.put(pair.get(1),pair)
		]
	}
	
	def Graph run(interactiveSystem is){
		
		val pairs = all_pairs()
		
		val result = new Graph
		//Init root node
		contexts.head.attachNode = result.createNode()
		result.rootNode = contexts.head.attachNode
		currentNode = result.rootNode
		
		//Then visit links
		while (!contexts.isEmpty){
			val currentContext = contexts.head
			currentNode = currentContext.attachNode
			var Link currentLink = currentNode.relatedLink

			//Visit all links
			var int i = currentContext.visitableLink.size - 1
			while(i >= 0){
				var Link nextLink = currentContext.visitableLink.get(i)
				
				var pair = getPair(currentLink,nextLink)
				if(currentLink == null){ //Is the root node
					//Update graph
					var GraphNode nextNode = result.createNode()
					nextNode.relatedLink = nextLink
					currentNode.addChildren(nextNode)
						
					var newContext = currentContext.copy()
					newContext.attachNode = nextNode
					addContext(newContext)
					
					nextLink.visit(newContext, this)
				}
				else if(!visited.contains(pair)){ //Pair not yet visited
					//Update graph
					var GraphNode nextNode = result.createNode()
					nextNode.relatedLink = nextLink
					currentNode.addChildren(nextNode)
						
					var newContext = currentContext.copy()
					newContext.attachNode = nextNode
					addContext(newContext)
					
					nextLink.visit(newContext, this)

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
	 * Find the pair of these two Links
	 * Return null if not found
	 */
	def getPair(Link one, Link two){
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
	 * Compute all pairs of Links
	 * Pairs where the first Link deactivate the Instrument of the second Link are not included 
	 */
	def List<List<Link>> all_pairs(){
		val List<List<Link>> res = new ArrayList
		
		val List<Link> range = new ArrayList
		range.addAll(this.interactiveSystem.instruments.map[links].flatten)
		
		range.forEach[link1 |
			range.forEach[link2 | 
				if(!link1.action.deactivatedInstruments.contains(link2.instrument)){
					var pair = new ArrayList
					pair.add(link1)
					pair.add(link2)
					res.add(pair)
//					println(link1.name+","+link2.name)
				}
			]
		]
		
		res
	}
	
	/**
	 * Find the first pair that pair(0) == lastLink and pair(1) is in visitables
	 * Return null if none
	 */
	def List<Link> select(Link lastLink, List<Link> visitables, List<List<Link>> visitablePairs){
		var pair = visitablePairs.findFirst[p |
			visitables.exists[nextLink | isEqual(lastLink, nextLink, p)]
		]
		return pair
	}
	
	/**
	 * Return true if one == pair(0) and two == pair(1)
	 */
	def boolean isEqual(Link one, Link two, List<Link> pair){
		return (pair.size == 2 && pair.get(0) == one && pair.get(1) == two)
	}
}