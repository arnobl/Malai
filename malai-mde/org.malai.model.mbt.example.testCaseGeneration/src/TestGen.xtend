
import org.eclipse.emf.common.util.URI
import org.malai.model.main.MainClass
import org.eclipse.emf.ecore.resource.Resource
import fr.inria.diverse.interactiveSystem.interactiveSystem
import java.util.List
import org.malai.model.mbt.api.TestProcessor
import java.util.Map
import org.MalaiStandaloneSetup
import fr.inria.diverse.interactiveSystem.InteractiveSystemPackage

class TestGen{
	def static void main(String[] args) {
		
		var Resource res = MalaiStandaloneSetup::load(URI::createURI("test.malai"))
//		var Resource res = MalaiStandaloneSetup::load(URI::createURI("demo.malai"))
		val interactiveSystem is = res.contents.get(0) as interactiveSystem
		var main = new MainClass()
		var testCases = main.visitModel(is)

//		testCases.forEach[ testCase |
////			var testCase = testCases.get(0)
//			var ui = new UIExample()
//			var testProc = new TestProcessor(is,ui.widgets)
//			var result = testProc.process(testCase,100)
//			
//			//Print TestCase with concrete values
//			var StringBuffer str = new StringBuffer
//			var int i = 0
//			while(i < testCase.size){
//				str.append(testCase.get(i).concreteTransition.event.name+"("+ printValues(result.get(i)) +")>")
//				i = i + 1
//			}
//			var content = str.toString
//			println("["+content.substring(0,content.length-1)+"]")
//			ui.dispose
//		]
		
	}
	
	//Helper to print List<Object>
	def static String printValues(Map<String,List<Object>> mappedValues){
		val StringBuffer str = new StringBuffer
		mappedValues.keySet.forEach[widgetID |
			str.append("["+widgetID+":")
			mappedValues.get(widgetID).forEach[value|
				str.append(value.toString+" ")
			]
			str.append("]")
		]
		return str.toString
	}
	
}