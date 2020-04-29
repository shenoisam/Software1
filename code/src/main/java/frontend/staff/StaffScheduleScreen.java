package frontend.staff;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StaffScheduleScreen extends GenericStaffScreen{

	StaffScheduleScreen(StaffRunner r) {
		super(r);
		// TODO Auto-generated constructor stub
	}
	public void createAndShowGUI(Container pane) {
		JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		ProvidersSchedule table = new ProvidersSchedule();
		table.setOpaque(true);
		
		JPanel aboutPatient = new JPanel();
		
		aboutPatient.setLayout(new BoxLayout(aboutPatient, BoxLayout.X_AXIS));
		
		JButton name = new JButton("Patient Name");
		
		aboutPatient.add(name);
		
		name = new JButton("Provider's Name");
		
		aboutPatient.add(name);
		
		JPanel aboutPatient2 = new JPanel();
		
		middleOfScreen.add(aboutPatient);
		
		
		aboutPatient2.setLayout(new BoxLayout(aboutPatient2, BoxLayout.X_AXIS));
	      
		//aboutPatient2.setLayout(new BoxLayout(aboutPatient2, BoxLayout.X_AXIS));
		
		name = new JButton("Select Date");
		
		aboutPatient2.add(name);
		
		name = new JButton("Schedule Appointment");
		
		aboutPatient2.add(name);
		
		middleOfScreen.add(aboutPatient2);
		
		middleOfScreen.add(table);
		
		
		
		pane.add(middleOfScreen);
		
		buttonAdder(pane);
	}

}
