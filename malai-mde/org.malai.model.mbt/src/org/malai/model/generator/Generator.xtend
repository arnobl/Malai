package org.malai.model.generator

import java.util.List
import java.util.Hashtable
import org.malai.instrument.Instrument
import org.malai.instrument.Link
import java.util.ArrayList
import org.malai.action.Action
import org.malai.model.generator.graph.GraphNode
import org.malai.model.generator.graph.Graph

import static extension org.malai.model.aspect.LinkAspect.*


/*
 * Store all created context and for each select the next link to be visited
 */
class Generator
{
	/**
	 * Instruments from the system
	 */
	public var List<Instrument> allInstruments
	
	/** 
	 * Contexts created by visited Links
	 *
	 * Each interaction adds solved action/ activated instrument
	 * and then creates a new Context
	 */
	var List<Context> contexts
	
	/**
	 * Hashtable to store computed Graph from a Link
	 * Avoid to generate Graph each time of Link.visit()
	 */
	var Hashtable<Link,IAFlowGraphPart> graphTable
	
	//Help to "attach" context to each other
	public var GraphNode currentNode
	
	new(List<Instrument> instr){
		
		allInstruments = new ArrayList
		contexts = new ArrayList
		graphTable = new Hashtable
		
		cache4Links(instr)
		
		allInstruments.addAll(instr)
		var Context newContext = new Context(allInstruments.filter[e | e.initiallyActivated].toList , new ArrayList<Action>())
		addContext(newContext)	
	}

	/**
	 * Entry point
	 * 
	 * Creates the initial context and visits it, which will creates new contexts
	 * Then do the same for created contexts
	 *
	 * Return the Link Flow Graph corresponding to the possible executions
	 */
	def Graph run(){
	
		var result = new Graph

		var Context currentContext
		while (!contexts.isEmpty){
			currentContext = contexts.head
			
			//Root node
			if(currentContext.attachNode == null) {
				currentContext.attachNode = result.createNode()
				result.rootNode = currentContext.attachNode
				var Link currentLink
				if((currentLink = currentContext.nextLink()) != null){
					currentContext.attachNode.relatedLink = currentLink
					currentLink.visit(currentContext, this)
				}
			}
			
			currentNode = currentContext.attachNode 

			var Link currentLink
			while((currentLink = currentContext.nextLink()) != null){
				//Update graph
				var GraphNode nextNode = result.createNode()
				nextNode.relatedLink = currentLink
				currentNode.addChildren(nextNode)
				currentLink.visit(currentContext, this)
				
				currentNode = nextNode
			}
			
			contexts.remove(currentContext)
		}
		println("DONE")
		return result
	}
	
	/**
	 * Visit all possible Links. (exponential)
	 */
	def Graph run2(){
		val result = new Graph
		//Init root node
		contexts.head.attachNode = result.createNode()
		result.rootNode = contexts.head.attachNode
		currentNode = result.rootNode
		
		//Then visit links
		while (!contexts.isEmpty){
			val currentContext = contexts.head
			currentNode = currentContext.attachNode
	
			while(!currentContext.visitableLink.empty){
				//Visit all links, the first one will become the new current node
				var int i = currentContext.visitableLink.size - 1
				while(i >= 0){
					var Link currentLink = currentContext.visitableLink.get(i)
					
					//Update graph
					var GraphNode nextNode = result.createNode()
					nextNode.relatedLink = currentLink
					currentNode.addChildren(nextNode)
						
					if(i == 0){ //Stay in the current context
						currentLink.visit(currentContext, this)
						currentNode = nextNode
					}
					else{ //Create a new context
						var newContext = currentContext.copy()
						newContext.attachNode = nextNode
						addContext(newContext)
						
						currentLink.visit(newContext, this)
					}
					i = i - 1
				}				
			}
			contexts.remove(currentContext)
		}
		
		println("DONE (Tree with "+ result.numberOfLeafs + " leafs)")
		return result
	}
	
	/**
	 * Convert all Links of all Instruments to graph and store them 
	 * into a cache
	 */
	def void cache4Links(List<Instrument> instr) {
		
		instr.forEach[i |
			i.links.forEach[l |
				var graphPart = new IAFlowGraphPart(l)
				graphTable.put(l,graphPart)
				println(graphPart)
			]
		]
	
	}
	
	def void addContext(Context context) {
		contexts.add(context)
	}

}