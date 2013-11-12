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
	var List<Instrument> allInstruments
	
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
	 * Return the Event Flow Graph corresponding to the possible executions
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
		result.save("test.dot")
		println("DONE")
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
			]
		]
	
	}
	
	def void addContext(Context context) {
		contexts.add(context)
	}

}