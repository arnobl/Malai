package org.malai.model.generator.graph

import java.util.ArrayList
import java.util.List
import org.malai.instrument.Link

/**
 * Structure to store links between Interaction-Action flow graph
 */
class Graph{
	
	public GraphNode rootNode = new GraphNode(this)
	
	package List<GraphNode> nodes = new ArrayList
	
	def GraphNode createNode(){
		return new GraphNode(this)
	}
	
	def String print(){
		val StringBuffer res = new StringBuffer
		res.append("digraph OutputGraph {\n")
		nodes.forEach[node | res.append(node.print)]
		res.append("}")
		return res.toString
	}
}

class GraphNode
{
	public Graph container
	public Link relatedLink
	private List<GraphNode> childrenNode
	
	package new(Graph container_) {
		childrenNode = new ArrayList
		container = container_
		container.nodes.add(this)
	}
	
	def void addChildren(GraphNode child){
		childrenNode.add(child)
		container.nodes.add(child)
	}
	
	def String print(){
		val StringBuffer res = new StringBuffer
		res.append(this.hashCode+"[label=\""+relatedLink.interaction.name+"\\n"+relatedLink.action.name+"\"]\n")
		childrenNode.forEach[child | res.append(this.hashCode+"->"+child.hashCode+"\n")]
		return res.toString
	}
}