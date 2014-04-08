package org.malai.model.generator.graph

import java.util.ArrayList
import java.util.List
import fr.inria.diverse.malai.*
import java.io.FileWriter
import java.io.BufferedWriter

/**
 * Structure to store links between Interaction-Action flow graph
 */
class Graph{
	
	public GraphNode rootNode
	
	public List<GraphNode> nodes
	
	new(){
		nodes = new ArrayList<GraphNode>()
		rootNode = new GraphNode()
	}
	
	def GraphNode createNode(){
		var n = new GraphNode()
		nodes.add(n)
		return n
	}
	
	def int numberOfLeafs(){
		return nodes.filter[node | node.isLeaf].size
	}
	
	override String toString(){
		val StringBuffer res = new StringBuffer
		res.append("digraph OutputGraph {\n")
		nodes.forEach[node | res.append(node.toString)]
		res.append("}")
		return res.toString
	}
	
	def void save(String file){
		try{
			var FileWriter fw = new FileWriter(file, false);
			var BufferedWriter output = new BufferedWriter(fw);
			output.write(toString());
			output.flush();
			output.close();
		}
		catch(Exception e){
			println(e)
		}
	}
	
	/**
	 * Return the list of paths to final states (nodes without output transition)
	 */
	static def List<List<GraphNode>> getAllPath(GraphNode node){
		val List<List<GraphNode>> result = new ArrayList
		
		node.childrenNode.forEach[child | 
				var childPath = getAllPath(child)
				childPath.forEach[list | 
					list.add(0,node)
					result.add(list)
			]
		]
		
		if(result.empty){
			var one = new ArrayList
			one.add(node)
			result.add(one)
		}
		
		return result
	}
	
	/**
	 * Print paths to final states (nodes without output transition)
	 */
	static def void printPaths(GraphNode node){
		var paths = getAllPath(node)
		paths.forEach[path  | 
			println(path.join(" > ")[nodeLink | 
				if(nodeLink.relatedLink == null) "RootNode"
				else nodeLink.relatedLink.name
			])
		]
	}
}

class GraphNode
{
	public Link relatedLink
	public List<GraphNode> childrenNode
	
	package new() {
		childrenNode = new ArrayList
	}
	
	def void addChildren(GraphNode child){
		childrenNode.add(child)
	}
	
	def boolean isLeaf(){
		return childrenNode.size == 0
	}
	
	override String toString(){
		val StringBuffer res = new StringBuffer
		if(relatedLink == null) res.append(this.hashCode+"[label=\"RootNode\"]\n")
		else res.append(this.hashCode+"[label=\""+relatedLink.interaction.name+"\\n"+relatedLink.action.name+"\"]\n")
		childrenNode.forEach[child | res.append(this.hashCode+"->"+child.hashCode+"\n")]
		return res.toString
	}
}