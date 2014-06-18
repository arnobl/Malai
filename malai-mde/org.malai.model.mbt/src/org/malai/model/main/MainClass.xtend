package org.malai.model.main

import java.util.List
import fr.inria.diverse.interactiveSystem.interactiveSystem
import org.malai.model.generator.Generator
import fr.inria.diverse.IAFlowGraph.InteractionTransition

class MainClass
{
	def List<List<InteractionTransition>> visitModel(interactiveSystem is) {
		println("Generating...")
		var Generator gen  = new Generator(is)
		var graph = gen.run()
		return gen.getAllPaths(graph)		
	}
}