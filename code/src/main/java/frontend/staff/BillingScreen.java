package frontend.staff;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BillingScreen extends GenericStaffScreen {

	BillingScreen(Runner r) {
		super(r);
		// TODO Auto-generated constructor stub
	}
    public void createAndShowGUI(Container pane) {
    	
    	// Can't figure this out yet...
		/*JTextArea StaffName = new JTextArea();
		StaffName.setText("Staff Name Here");
		frame.getContentPane().add(StaffName, BorderLayout.CENTER);*/

    	JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		TableWrap table = new TableWrap();
		table.setOpaque(true);
		
		JTextArea aboutPatient = new JTextArea();
		aboutPatient.setText("About the patient");
		
		middleOfScreen.add(table);
		
		middleOfScreen.add(aboutPatient);
		
		pane.add(middleOfScreen);
		
		buttonAdder(pane);
    }

}
