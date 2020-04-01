package patienthomescreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class PatientIntake extends GenericScreen {
	public PatientIntake(JFrame frame) {
		super(frame, "Patient Intake");
		setTopBar();
		setSideBar();
		setMainPanel();
	}
	
	

	protected void setTopBar() {
		JPanel namePanel = new JPanel();
	    namePanel.setBorder(BorderFactory.createTitledBorder(""));
	    namePanel.setPreferredSize(new Dimension(500, 50));
	    namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
	    JLabel welcome = new JLabel("Welcome, ");
	    namePanel.add(welcome);
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
		
		viewTestResButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				PatientViewTest pi = new PatientViewTest(frame);
				frame.getContentPane().update(frame.getGraphics());
				
			}
			
		});
		
	}

	@Override
	protected void setMainPanel() {
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		JTextField firstName = new JTextField();
		JTextField mInitial = new JTextField();
		JTextField lastName = new JTextField();
		JTextField dob = new JTextField("mm/dd/yyyy");
		JTextField phone = new JTextField();
		JTextField address = new JTextField();
		
		JTextField emergencyName = new JTextField();
		JTextField emergencyPhone = new JTextField();
		
		JTextArea medHistoryField = new JTextArea(5, 40);
		
		JTextArea allergies = new JTextArea(4, 40);
		
		JPanel intakePanel = new JPanel();
		SpringLayout sl = new SpringLayout();
		intakePanel.setLayout(sl);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(0, 6));
		namePanel.add(new JLabel("First Name:"));
		namePanel.add(firstName);
		namePanel.add(new JLabel(" Middle Initial: "));
		namePanel.add(mInitial);
		namePanel.add(new JLabel(" Last Name:"));
		namePanel.add(lastName);
		
		sl.putConstraint(SpringLayout.NORTH, namePanel, 5, SpringLayout.NORTH, intakePanel);
		
		intakePanel.add(namePanel);
		
		JPanel otherPanel = new JPanel();
		otherPanel.setLayout(new GridLayout(0, 4));
		otherPanel.add(new JLabel("DOB:"));
		otherPanel.add(dob);
		otherPanel.add(new JLabel("Phone:"));
		phone.setColumns(9);
		otherPanel.add(phone);
		
		sl.putConstraint(SpringLayout.NORTH, otherPanel, 5, SpringLayout.SOUTH, namePanel);
		intakePanel.add(otherPanel);
		
		JPanel addressPane = new JPanel();
		addressPane.setLayout(new FlowLayout());
		addressPane.add(new JLabel("Address:"));
		address.setColumns(40);
		addressPane.add(address);
		
		sl.putConstraint(SpringLayout.NORTH, addressPane, 5, SpringLayout.SOUTH, otherPanel);
		intakePanel.add(addressPane);
		
		JLabel emergencyLabel = new JLabel("Emergency Contact: ");
		sl.putConstraint(SpringLayout.NORTH, emergencyLabel, 5, SpringLayout.SOUTH,addressPane);
		
		intakePanel.add(emergencyLabel);
		JPanel emergencyPane = new JPanel();
		emergencyPane.setLayout(new FlowLayout());
		emergencyPane.add(new JLabel("Name:"));
		emergencyName.setColumns(15);
		emergencyPane.add(emergencyName);
		emergencyPane.add(new JLabel("Phone:"));
		emergencyPhone.setColumns(10);
		emergencyPane.add(emergencyPhone);
		
		sl.putConstraint(SpringLayout.NORTH, emergencyPane, 5, SpringLayout.SOUTH, emergencyLabel);
		intakePanel.add(emergencyPane);
		
		JLabel medHistory = new JLabel("Medical History: ");
		sl.putConstraint(SpringLayout.NORTH, medHistory, 5, SpringLayout.SOUTH, emergencyPane);
		
		intakePanel.add(medHistory);
		
		medHistoryField.setLineWrap(true);
		medHistoryField.setWrapStyleWord(true);
		sl.putConstraint(SpringLayout.NORTH, medHistoryField, 5, SpringLayout.SOUTH, medHistory);
		sl.putConstraint(SpringLayout.WEST, medHistoryField, 5, SpringLayout.WEST, intakePanel);
		
		intakePanel.add(medHistoryField);
		
		JLabel allergiesLabel = new JLabel("Allergies: ");
		sl.putConstraint(SpringLayout.NORTH, allergiesLabel, 5, SpringLayout.SOUTH, medHistoryField);
		
		intakePanel.add(allergiesLabel);
		
		allergies.setLineWrap(true);
		allergies.setWrapStyleWord(true);
		sl.putConstraint(SpringLayout.NORTH, allergies, 5, SpringLayout.SOUTH, allergiesLabel);
		sl.putConstraint(SpringLayout.WEST, allergies, 5, SpringLayout.WEST, intakePanel);
		
		intakePanel.add(allergies);
		
		mainPanel.add(intakePanel);
		
	}
}
