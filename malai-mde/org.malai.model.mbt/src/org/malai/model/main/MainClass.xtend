package org.malai.model.main

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.malai.instrument.Instrument
import org.malai.instrument.InstrumentPackage
import org.malai.model.generator.Generator
import org.malai.model.generator.graph.Graph

class MainClass
{
	def void mainOperation() {	
		println("Hello from mainOperation !")
		
		var String mm_uri = "platform:/resource/org.malai.model/src/main/metamodel/instrument.ecore"
		var String m_uri = "platform:/resource/org.malai.model.examples/src/main/model/latexdraw/instruments/editingSelector.instrument"
		
		visitModel(loadModel(m_uri))
	}
	
	def Graph visitModel(List<Instrument> allInst) {
		
		var Generator gen  = new Generator(allInst)
		return gen.run()		
	}
	
	def List<Instrument> loadModel(String path){
		var fact = new XMIResourceFactoryImpl
		if (!EPackage.Registry.INSTANCE.containsKey(InstrumentPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(InstrumentPackage.eNS_URI, InstrumentPackage.eINSTANCE);
		}
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", fact);

		var rs = new ResourceSetImpl()

		var uri = URI.createURI(path);
		var resource = rs.getResource(uri, true);
		val List<Instrument> allInst = new ArrayList<Instrument>()
		resource.getContents.forEach [ elem |
			if (elem instanceof Instrument) {
				var Instrument inst = elem as Instrument
				allInst.add(inst)
			}
		]
		return allInst
	}
}