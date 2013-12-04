package org.malai.model.mbt.api;

import java.util.ArrayList;
import java.util.List;
import org.malai.interactiveSystem.interactiveSystem;
import fr.inria.IAFlowGraph.InteractionTransition;

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
	def List<List<Object>> process(List<InteractionTransition> testCase, int delay){
		
		val List<List<Object>> mappedValues = new ArrayList<List<Object>>();
		
		for(InteractionTransition tr : testCase){
			
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
					mappedValues.add(values);
					
					//Send values to the widget
					widget.execute(tr.concreteTransition.event, values);
				]
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(delay)
		}
		return mappedValues
	}
	
}
