package patienthomescreen;

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

import cshare.TestOrder;

public class PatientViewTest extends GenericScreen {

	public PatientViewTest(JFrame frame) {
		super(frame, "Patient View Test");
		setTopBar();
		setSideBar();
		setMainPanel();
	}
	
	protected void setMainPanel() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));		
		
		PatientTestTableModel ptModel = new PatientTestTableModel(new ArrayList<TestOrder>());
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
	    staffName.setText("<Patient Name>");
	    namePanel.add(staffName);
	      
	    // creating and adding an invisible panel to push out the appointment times
	    JPanel invisible = new JPanel();
	    namePanel.add(invisible);
	      
	    // creating the appointment time and location
	    JLabel nextAppointmentTitle  = new JLabel();
	    nextAppointmentTitle.setText("Your Next Appointment is at: ");
	    JLabel appointmentTime = new JLabel();
	    appointmentTime.setText("MM-DD-YY HH:mm ");
	      
	    // adding the time and location to the name panel
	    namePanel.add(nextAppointmentTitle);
	    namePanel.add(appointmentTime);
	    
	    
	    this.titlePanel.add(namePanel);
	}
	
	
	protected void setSideBar() {
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
		sidePanel.setPreferredSize(new Dimension(150, sidePanel.getHeight()));
		
		JButton intakeFormButton = new JButton("Patient Intake Form");
		sidePanel.add(intakeFormButton);
		
		JButton viewTestResButton = new JButton("View Test Result");
		sidePanel.add(viewTestResButton);
		
	}
	
}
