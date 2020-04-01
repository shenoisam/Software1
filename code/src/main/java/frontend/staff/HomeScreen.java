package frontend.staff;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class HomeScreen extends GenericStaffScreen{

	HomeScreen(Runner r) {
		super(r);
		// TODO Auto-generated constructor stub
	}
	public void createAndShowGUI(Container pane) {
		JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		OfficeSchedule table = new OfficeSchedule();
		table.setOpaque(true);
		
		middleOfScreen.add(table);
		
		//middleOfScreen.add(aboutPatient);
		
		pane.add(middleOfScreen);
		
		buttonAdder(pane);
	}
   
}
