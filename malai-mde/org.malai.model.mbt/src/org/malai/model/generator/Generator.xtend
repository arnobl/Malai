package org.malai.model.generator

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.ArrayList
import java.util.Hashtable
import java.util.List
import fr.inria.diverse.malai.*
import org.malai.model.generator.graph.Graph
import org.malai.model.generator.graph.GraphNode

import static extension org.malai.model.aspect.InteractorAspect.*
import fr.inria.diverse.interactiveSystem.interactiveSystem
import fr.inria.diverse.IAFlowGraph.InteractionTransition

/*
 * Store all created context and for each select the next interactor to be visited
 */
class Generator
{
	/**
	 * The interactive system model
	 */
	protected var interactiveSystem interactiveSystem
	
	/**
	 * Instruments from the system
	 */
	public var List<Instrument> allInstruments
	
	/** 
	 * Contexts created by visited Interactors
	 *
	 * Each interaction adds solved action/ activated instrument
	 * and then creates a new Context
	 */
	protected var List<Context> contexts
	
	/**
	 * Hashtable to store computed Graph from a Interactor
	 * Avoid to generate Graph each time of Interactor.visit()
	 */
	var Hashtable<Interactor,IAFlowGraphPart> graphTable
	
	//Help to "attach" context to each other
	public var GraphNode currentNode
	
	new(interactiveSystem systemModel){

		allInstruments = systemModel.instruments
		
		interactiveSystem = systemModel		
		contexts = new ArrayList
		graphTable = new Hashtable
		
		cache4Interactors()
		
		var Context newContext = new Context(interactiveSystem.instruments.filter[e | e.initiallyActivated].toList , new ArrayList<Action>())
		addContext(newContext)	
	}

	/**
	 * Entry point
	 * Generate possibles execution paths from the Instruments passed to the generator.
	 * The result is a list of tests cases, which are list of transitions
	 * 
	 * (exponential)
	 */
	def Graph run(){
		val result = new Graph
		//Init root node
		contexts.head.attachNode = result.createNode()
		result.rootNode = contexts.head.attachNode
		currentNode = result.rootNode
		
		//Then visit interactors
		while (!contexts.isEmpty){
			val currentContext = contexts.head
			currentNode = currentContext.attachNode
	
			while(!currentContext.visitableInteractor.empty){
				var nodeContexts = new ArrayList<Context>();
				var currentContextCopy = currentContext.copy()
				//Visit all interactors, the first one will become the new current node
				var int i = currentContext.visitableInteractor.size - 1
				while(i >= 0){
					var Interactor currentInteractor = currentContext.visitableInteractor.get(i)
					
					//Update graph
					var GraphNode nextNode = result.createNode()
					nextNode.relatedInteractor = currentInteractor
					currentNode.addChildren(nextNode)
						
					if(i == 0){ //Stay in the current context
						currentInteractor.visit(currentContext, this)
						currentNode = nextNode
						nodeContexts.add(currentContext)
					}
					else{ //Create a new context
						var newContext = currentContext.copy()
						newContext.attachNode = nextNode
						addContext(newContext)
						nodeContexts.add(newContext)
						
						currentInteractor.visit(newContext, this)
					}
					i = i - 1
				}	
				//Update Interactors counters in new contexts
				i = currentContextCopy.visitableInteractor.size - 1
				while(i >= 0){
					val Interactor currentInteractor = currentContextCopy.visitableInteractor.get(i)
					
					nodeContexts.forEach[context | currentInteractor.incrVisitCounter(context)] // "Breadth First Search"
//					currentLink.incrVisitCounter(nodeContexts.get(nodeContexts.size - i - 1)) // "Depth First Search"
					
					i = i - 1
				}
			}
			contexts.remove(currentContext)
		}
		
//		saveActionInteractions("demo/dot/interactions")
//		writeFile("demo/dot/","level1.dot",result.toString)
//		writeFile("demo/dot/","level2.dot",this.toString(result))
//		writeFile("demo/","script.sh","for i in `find \\`pwd\\` -type f | grep .dot$`\ndo\n	dot $i -Tsvg -O\ndone")
		
		Graph.printPaths(result.rootNode)
//		printPaths(result.rootNode)
		
		println("DONE (Tree with "+ result.numberOfLeafs + " leafs)")
		
		return result
	}
	
	/**
	 * Convert all Interactors of all Instruments to graph and store them 
	 * into a cache
	 */
	def void cache4Interactors() {
		
		interactiveSystem.instruments.forEach[i |
			i.interactors.forEach[l |
				if(!graphTable.containsKey(l)){
					var graphPart = new IAFlowGraphPart(l)
					graphPart.reduce
					
					val mapping = interactiveSystem.mapping.findFirst[map | map.interactor == l]
					if(mapping != null){
						graphPart.allTransitions.forEach[tr |
							var bind = mapping.binds.findFirst[bind | bind.transition.name == tr.concreteTransition.name]
							println(bind)
							tr.getRelatedWidgetIDs.addAll(bind.widgetIDs)
						]
					}
					
					graphTable.put(l,graphPart)
				}
			]
		]
	}
	
	def void saveActionInteractions(String dir){
		try{
			graphTable.keySet.forEach[key |
				writeFile(dir,key.interaction.name+"_"+key.action.name+".dot",graphTable.get(key).toString())
			]
		}
		catch(Exception e){
			println(e)
		}
	}
	
	def void writeFile(String dir, String file, String content){
		try{
			var File newDir = new File(dir)
			newDir.mkdirs
			
			var FileWriter fw = new FileWriter(dir+"/"+file, false);
			var BufferedWriter output = new BufferedWriter(fw);
			output.write(content);
			output.flush();
			output.close();
		}
		catch(Exception e){
			println(e)
		}
	}
	
	/**
	 * Convert a path from the graph of Interactors to paths of Transitions
	 */
	def List<List<InteractionTransition>> convert(List<GraphNode> path){
		var List<List<InteractionTransition>> result = new ArrayList
		
		val List<List<InteractionTransition>> processingPaths = new ArrayList
		val List<List<InteractionTransition>> abortingPaths = new ArrayList
		
		path.forEach[node |
			if(node.relatedInteractor != null){
				var graph = graphTable.get(node.relatedInteractor)
				var allPaths = graph.allPaths
				
				val List<List<InteractionTransition>> toAdd = new ArrayList
				if(processingPaths.empty){
					allPaths.forEach[p |
						var newPath = new ArrayList
						newPath.addAll(p)
						if(!newPath.last?.action.actionProduced){
							abortingPaths.add(newPath)
						}
						else{
							processingPaths.add(newPath)
						}
					]
				}
				else{
					val List<List<InteractionTransition>> toDel = new ArrayList
					if(allPaths.size != 0){
						toDel.addAll(processingPaths);
					}
					allPaths.forEach[tail | 
						processingPaths.forEach[before | 
							var newPath = new ArrayList
							newPath.addAll(before)
							newPath.addAll(tail)
							if(!newPath.last?.action.actionProduced){
								abortingPaths.add(newPath)
							}
							else{
								toAdd.add(newPath)
							}
						]
					]
					processingPaths.addAll(toAdd)
					processingPaths.removeAll(toDel);
				}
			}
		]
		
		result.addAll(abortingPaths)
		result.addAll(processingPaths)
		
		return result
	}
	
	def List<List<InteractionTransition>> getAllPaths(Graph graph){
		val List<List<InteractionTransition>> result = new ArrayList
		var paths = Graph.getAllPath(graph.rootNode)
		paths.forEach[p |
			result.addAll(convert(p))
		]
		return result
	}
	
	def printPaths(GraphNode root){
		var paths = Graph.getAllPath(root)
		paths.forEach[p |
			println("-----------------------------------------")
			convert(p).forEach[pa |
				println(pa.join("[",">","]",[tr|tr.concreteTransition.event.name]))
			]
		]
	}
	
	def toString(Graph graph){
		val StringBuffer res = new StringBuffer
		res.append("digraph OutputGraph {\n")
		
		graph.nodes.forEach[node |
			if(node.relatedInteractor == null){
				res.append(node.hashCode+"[label=\"RootNode\"]\n")
				//Connect root to init states of childs graphs
				node.childrenNode.forEach[child |
					val childSubGraph = graphTable.get(child.relatedInteractor)
					var List<InteractionTransition> initList = childSubGraph.allPaths.map[path | path.get(0)]
					val initStates = initList.toSet
					
					initStates.forEach[init | res.append(node.hashCode+"->"+child.hashCode+""+init.hashCode+"\n")]
					childSubGraph.abortingTransitions.forEach[abort | res.append(child.hashCode+""+abort.hashCode+"->"+node.hashCode+"[color=red]\n")]
				]
				}
			else{
				//Print the interaction graph
				val subGraph = graphTable.get(node.relatedInteractor)
				res.append(subGraph.node2Graph(node.hashCode))
				
				//Connect to other graph
				//interactor all init states of childs nodes with all terminal states of the current node
				node.childrenNode.forEach[child |
					val childSubGraph = graphTable.get(child.relatedInteractor)
					var List<InteractionTransition> initList = childSubGraph.allPaths.map[path | path.get(0)]
					val initStates = initList.toSet
					
					subGraph.terminalTransitions.forEach[endNode |
						initStates.forEach[init | res.append(node.hashCode+""+endNode.hashCode+"->"+child.hashCode+""+init.hashCode+"\n")]
						childSubGraph.abortingTransitions.forEach[abort | res.append(child.hashCode+""+abort.hashCode+"->"+node.hashCode+""+endNode.hashCode+"[color=red]\n")]
					]
				]
				//link aborting states
			}
		]
		
		res.append("}")
		return res.toString
	}
	
	def void addContext(Context context) {
		contexts.add(context)
	}

}