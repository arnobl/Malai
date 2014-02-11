import java.util.List
import org.malai.event.Event
import java.util.ArrayList
import javax.swing.JButton
import javax.swing.JSlider
import java.awt.Point
import org.malai.model.mbt.api.TestedWidget
import org.malai.model.mbt.api.DomainValue

class ButtonWidget implements TestedWidget{
	
	var JButton button;
	
	new(JButton b){
		button = b
	}
	
	override execute(Event event, List<Object> param) {
		
		button.doClick
//		throw new UnsupportedOperationException("Invalid parameters")
	}
	
	override getPossiblesValues(Event event) {
		
		if(event.name == "ButtonPressed"){
			return new ArrayList
		}
		throw new UnsupportedOperationException("Unsupported event")
	}
	
	override getID() {
		return "ButtonWidget_ID"
	}

}

class SliderWidget implements TestedWidget{
	
	var JSlider slider
	
	new(JSlider s){
		slider = s
	}
	
	override execute(Event event, List<Object> param) {
		if(param.size == 1 && param.get(0) instanceof Integer){
			var int minY = slider.minimum
			var int maxY = slider.maximum
			var y = param.get(0) as Integer
			if(minY <= y && y <= maxY){
				slider.setValue(y)
				return
			}
		}
		throw new UnsupportedOperationException("Invalid parameters")
	}
	
	override getPossiblesValues(Event event) {
		if(event.name == "SliderValueSetted"){
			var List<DomainValue> result = new ArrayList
			
			var DomainValue domain = [| 
				var int minY = slider.minimum
				var int maxY = slider.maximum
				return (Math.random * (maxY - minY) + minY ).intValue
			]
			
			result.add(domain)
			
			return result
		}
		throw new UnsupportedOperationException("Unsupported event")
	}
	
	override getID() {
		return "SliderWidget_ID"
	}
	
}

class CustomWidgetWidget implements TestedWidget{
	
	var CustomWidget customWidget
	var int mouseX
	var int mouseY
	
	new(CustomWidget c){
		customWidget = c
	}
	
	override execute(Event event, List<Object> param) {
		if( event.name == "MousePressed" && param.size == 2 
			&& param.get(0) instanceof Integer && param.get(1) instanceof Integer){
			customWidget.clicX = param.get(0) as Integer
			customWidget.clicY = param.get(1) as Integer
			mouseX = customWidget.clicX
			mouseY = customWidget.clicY
			return
		}
		else if( event.name == "MouseReleased" && param.size == 2
			&& param.get(0) instanceof Integer && param.get(1) instanceof Integer){
			var newX = param.get(0) as Integer
			var newY = param.get(1) as Integer
			customWidget.x = newX - (customWidget.clicX - customWidget.x);
			customWidget.y = newY - (customWidget.clicY - customWidget.y);
			return
		}
		else if( event.name == "MouseMoved" && param.size == 1 && param.get(0) instanceof Point){
			var point = param.get(0) as Point
			mouseX = point.x
			mouseY = point.y
			return
		}
		else if(event.name == "KeyPressed"){
			//TODO: unimplemented
			return
		}

		throw new UnsupportedOperationException("Invalid parameters")
	}
	
	override getPossiblesValues(Event event) {

		if(event.name == "MousePressed"){
			var List<DomainValue> result = new ArrayList
			
			var DomainValue domainX = [| 
				var minX = customWidget.x
				var maxX = minX + customWidget.SQUARE_SIZE
				return (Math.random * (maxX - minX) + minX ).intValue
			]
			
			var DomainValue domainY = [| 
				var minY = customWidget.y
				var maxY = minY + customWidget.SQUARE_SIZE
				return (Math.random * (maxY - minY) + minY ).intValue
			]
			
			result.add(domainX)
			result.add(domainY)
			
			return result
		}
		else if(event.name == "MouseReleased"){
			var List<DomainValue> result = new ArrayList
			
			var DomainValue domainX = [| 
				return mouseX
			]
			
			var DomainValue domainY = [| 
				return mouseY
			]
			
			result.add(domainX)
			result.add(domainY)
			
			return result
		}
		else if(event.name == "MouseMoved"){
			var List<DomainValue> result = new ArrayList
			
			var DomainValue domainPoint = [| 
				
				var int genX
				var int genY
				do{
					var minX = 0
					var maxX = minX + customWidget.width
					
					var minY = 0
					var maxY = minX + customWidget.width
					
					genX = (Math.random * (maxX - minX) + minX ).intValue
					genY = (Math.random * (maxY - minY) + minY ).intValue
				}while(genX == customWidget.clicX && genY == customWidget.clicY)
				
				var Point res = new Point(genX, genY)
				
				return res
			]

			result.add(domainPoint)
			
			return result
		}
		else if(event.name == "KeyPressed"){
			var List<DomainValue> result = new ArrayList
			return result
		}
		throw new UnsupportedOperationException("Unsupported event")
	}
	
	override getID() {
		return "CustomWidget_ID"
	}
	
}