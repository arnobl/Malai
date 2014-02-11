import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.malai.model.mbt.api.TestedUI;
import org.malai.model.mbt.api.TestedWidget;


public class UIExample extends JFrame implements TestedUI{
	
	boolean isOpen;
	
	JButton activButton;
	JLabel iconLabel;
	ImageIcon openImg;
	ImageIcon closeImg;
	JSlider debitSlider;
	JLabel debitLabel;
	JLabel debitValueLabel;
	CustomWidget customWidget;
	
	public UIExample() {
		
		openImg = new ImageIcon("isOpen.png");
		closeImg = new ImageIcon("isClose.png");
		isOpen = false;
		
		setBounds(500, 500, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBorder(new TitledBorder("Vanne"));
		activButton = new JButton("Ouvrir");
		activButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(isOpen){
					activButton.setText("Ouvrir");
					debitValueLabel.setText("0 m³/s");
					iconLabel.setIcon(closeImg);
				}
				else{
					activButton.setText("Fermer");
					debitValueLabel.setText(debitSlider.getValue() +" m³/s");
					iconLabel.setIcon(openImg);
				}
				
				isOpen = !isOpen;
				debitSlider.setEnabled(isOpen);
			}
		});
		iconLabel = new JLabel(closeImg);
		debitSlider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
		debitSlider.setEnabled(isOpen);
		debitSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				 JSlider source = (JSlider)e.getSource();
				    if (!source.getValueIsAdjusting()) {
				        int newVal = (int)source.getValue();
				        debitValueLabel.setText(newVal +" m³/s");
				    }				
			}
		});
		debitLabel = new JLabel("Débit");
		debitValueLabel = new JLabel(debitSlider.getValue()+" m³/s");
		
		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new BoxLayout(buttonPan, BoxLayout.X_AXIS));
		buttonPan.add(activButton);
		buttonPan.add(Box.createRigidArea(new Dimension(5,0))); //space
		buttonPan.add(iconLabel);
		
		JPanel label_SliderPanel = new JPanel(); 
		label_SliderPanel.setLayout(new BoxLayout(label_SliderPanel, BoxLayout.Y_AXIS));
		label_SliderPanel.add(debitSlider);
//		label_SliderPanel.add(debitLabel);
		
		JPanel SliderPanel = new JPanel(); 
		SliderPanel.setLayout(new BoxLayout(SliderPanel, BoxLayout.X_AXIS));
		SliderPanel.add(label_SliderPanel);
		SliderPanel.add(Box.createRigidArea(new Dimension(5,0))); //space
		SliderPanel.add(debitValueLabel);
		
		contentPanel.add(buttonPan);
		contentPanel.add(SliderPanel);
		
		JPanel extendedContentPanel = new JPanel();
		extendedContentPanel.setLayout(new BoxLayout(extendedContentPanel, BoxLayout.X_AXIS));
		extendedContentPanel.add(contentPanel);
		customWidget = new CustomWidget();
		extendedContentPanel.add(customWidget);
		
		setContentPane(extendedContentPanel);
		
		setVisible(true);
	}
	
	public List<TestedWidget> getWidgets(){
		List<TestedWidget> result = new ArrayList<TestedWidget>();
		
		ButtonWidget w1 = new ButtonWidget(activButton);
		SliderWidget w2 = new SliderWidget(debitSlider);
		CustomWidgetWidget w3 = new CustomWidgetWidget(customWidget);
		
		result.add(w1);
		result.add(w2);
		result.add(w3);
		
		return result;
	}
	
	public static void main(String[] args) {
		JFrame frame = new UIExample();
	}
}
