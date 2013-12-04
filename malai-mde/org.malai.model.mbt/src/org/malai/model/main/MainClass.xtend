package org.malai.model.main

import fr.inria.IAFlowGraph.InteractionTransition
import java.util.List
import org.malai.interactiveSystem.interactiveSystem
import org.malai.model.generator.Generator

class MainClass
{
	def List<List<InteractionTransition>> visitModel(interactiveSystem is) {
		
		var Generator gen  = new Generator(is)
		return gen.run()		
	}
}