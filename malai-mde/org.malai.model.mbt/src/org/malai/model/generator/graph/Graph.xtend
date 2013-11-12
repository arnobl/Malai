package org.malai.model.generator.graph

import java.util.ArrayList
import java.util.List
import org.malai.instrument.Link
import java.io.FileWriter
import java.io.BufferedWriter

/**
 * Structure to store links between Interaction-Action flow graph
 */
class Graph{
	
	public GraphNode rootNode
	
	package List<GraphNode> nodes
	
	new(){
		nodes = new ArrayList<GraphNode>()
		rootNode = new GraphNode()
	}
	
	def GraphNode createNode(){
		var n = new GraphNode()
		nodes.add(n)
		return n
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
			
		}
	}
}

class GraphNode
{
	public Link relatedLink
	private List<GraphNode> childrenNode
	
	package new() {
		childrenNode = new ArrayList
	}
	
	def void addChildren(GraphNode child){
		childrenNode.add(child)
	}
	
	override String toString(){
		val StringBuffer res = new StringBuffer
		res.append(this.hashCode+"[label=\""+relatedLink.interaction.name+"\\n"+relatedLink.action.name+"\"]\n")
		childrenNode.forEach[child | res.append(this.hashCode+"->"+child.hashCode+"\n")]
		return res.toString
	}
}