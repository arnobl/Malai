package org.malai.model.main

import java.util.List
import fr.inria.diverse.interactiveSystem.interactiveSystem
import org.malai.model.generator.Generator
import fr.inria.diverse.IAFlowGraph.InteractionTransition
import org.malai.model.generator.AllPairGenerator

class MainClass
{
	def List<List<InteractionTransition>> visitModel(interactiveSystem is) {
		println("Generating...")
		var Generator gen  = new Generator(is)
		var graph = gen.run()
		return gen.getAllPaths(graph)		
	}
	
	def List<List<InteractionTransition>> visitModelWithPairs(interactiveSystem is) {
		println("Generating test cases...")
		var AllPairGenerator pairsGen  = new AllPairGenerator(is)
		var graph = pairsGen.run()
		
		println("Number of pairs = " + pairsGen.all_pairs.size)
		println("Number of covered pairs = " + pairsGen.coverage)
		println("Number of sequences = " + graph.numberOfLeafs)
		
		return pairsGen.getAllPaths(graph)
	}
}