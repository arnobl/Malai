package org.malai.model.mbt.api;

import java.util.ArrayList;
import java.util.List;
import fr.inria.diverse.interactiveSystem.interactiveSystem
import fr.inria.diverse.IAFlowGraph.InteractionTransition
import java.util.Map
import java.util.HashMap

/**
 * This class associates concretes values on tests cases from an interactive system 
 */
public class TestProcessor {
	
	var Mapper mapper;
	var interactiveSystem interactiveSystem;

	/**
	 * Register Widget associations
	 * 
	 * @param model Interactive system model where tests cases come from
	 * @param widgets Testable widgets from the tested UI
	 */
	new(interactiveSystem model,List<TestedWidget> widgets) {
		
		interactiveSystem = model;
		mapper = new Mapper();
		widgets.forEach[widget | mapper.register(widget)]
	}
	
	/**
	 * Process the given test case on the UI in order to associate its concretes values
	 * 
	 * @testCase list of transitions composing the test case
	 * @delay waiting time between two transitions processed in milliseconds
	 */
	def List<Map<String,List<Object>>> process(List<InteractionTransition> testCase, int delay){
		
		val List<Map<String,List<Object>>> result = new ArrayList
		
		for(InteractionTransition tr : testCase){
			
			val Map<String,List<Object>> mappedValues = new HashMap; //related widgets and their possibles values
			try {
				//Find widget
				var relatedWidgetIDs = tr.relatedWidgetIDs
				relatedWidgetIDs.forEach[widgetID | 
					var TestedWidget widget = mapper.findWidget(widgetID);
					
					//Ask for domains definition
					var List<DomainValue> domains = widget.getPossiblesValues(tr.getConcreteTransition().getEvent());
					
					//Choose values
					var List<Object> values = new ArrayList<Object>();
					for(DomainValue domain : domains){
						values.add(domain.pickup());
					}
					
					//Update testCase with concrete values
					mappedValues.put(widgetID,values)
					
					//Send values to the widget
					widget.execute(tr.concreteTransition.event, values);
				]
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			result.add(mappedValues);
			
			Thread.sleep(delay)
		}
		return result
	}
	
}
