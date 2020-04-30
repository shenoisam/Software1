package frontend.patient;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import backend.classes.TestOrder;

public class PatientViewTest extends PatientGenericScreen {

	public PatientViewTest(JFrame frame, PatientRunner p) {
		super(frame, "Patient View Test", p);
		setTopBar();
		setSideBar();
		setMainPanel();
	}
	
	protected void setMainPanel() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));		
		
		TestTableModel ptModel = new TestTableModel(new ArrayList<TestOrder>());
		JTable testTable = new JTable();
		testTable.setModel(ptModel);
		JScrollPane scrollPane = new JScrollPane(testTable);
		mainPanel.add(scrollPane);
		
		JLabel label = new JLabel("Information");
		label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		label.setOpaque(true);
		
		JPanel pane = new JPanel();
		pane.setOpaque(true);
		SpringLayout sl = new SpringLayout();
		sl.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, pane);
		sl.putConstraint(SpringLayout.EAST, label, -5, SpringLayout.EAST, pane);
		sl.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, pane);
		pane.setLayout(sl);
		pane.setPreferredSize(new Dimension(10, 100));
		pane.add(label);
		
		mainPanel.add(pane);
	}
	
	protected void setTopBar() {
		JPanel namePanel = new JPanel();
	    namePanel.setBorder(BorderFactory.createTitledBorder(""));
	    namePanel.setPreferredSize(new Dimension(500, 50));
	    namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
	    JLabel staffName = new JLabel();
	    staffName.setText(p.getUser().getFirstName() + " " + p.getUser().getLastName());
	    namePanel.add(staffName);
	      
	    // creating and adding an invisible panel to push out the appointment times
	    JPanel invisible = new JPanel();
	    namePanel.add(invisible);
	      
	    // creating the appointment time and location
	    JLabel nextAppointmentTitle  = new JLabel();
	    nextAppointmentTitle.setText("Your Next Appointment is at: ");
	    JLabel appointmentTime = new JLabel();
	    appointmentTime.setText(this.a.getAppointmentDate().toString());
	      
	    // adding the time and location to the name panel
	    namePanel.add(nextAppointmentTitle);
	    namePanel.add(appointmentTime);
	    
	    
	    this.titlePanel.add(namePanel);
	}
	
	

	
}
