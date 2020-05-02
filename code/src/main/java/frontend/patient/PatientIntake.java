package frontend.patient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

import businesslayer.CShareObjects;
import frontend.GenericEnum;

/**
 * Displays the patient intake form
 * for the patient to fill out
 *
 */
public class PatientIntake extends PatientGenericScreen {
	
	/**
	 * 
	 * @param frame
	 * @param p
	 */
	public PatientIntake(JFrame frame, PatientRunner  p) {
		super(frame, "Patient Intake",p);
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
	
	
	

	@Override
	protected void setMainPanel() {
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		JTextField firstName = new JTextField();
		firstName.setText(p.getUser().getFirstName());
		JTextField mInitial = new JTextField();
		JTextField lastName = new JTextField();
		lastName.setText(p.getUser().getLastName());
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
		otherPanel.add(new JLabel("Married:"));
		phone.setColumns(9);
		otherPanel.add(phone);
		
		sl.putConstraint(SpringLayout.NORTH, otherPanel, 5, SpringLayout.SOUTH, namePanel);
		intakePanel.add(otherPanel);
		
		JPanel addressPane = new JPanel();
		addressPane.setLayout(new FlowLayout());
		addressPane.add(new JLabel("Gender:"));
		address.setColumns(40);
		addressPane.add(address);
		
		sl.putConstraint(SpringLayout.NORTH, addressPane, 5, SpringLayout.SOUTH, otherPanel);
		intakePanel.add(addressPane);
		
		JLabel emergencyLabel = new JLabel("Demographic Information: ");
		sl.putConstraint(SpringLayout.NORTH, emergencyLabel, 5, SpringLayout.SOUTH,addressPane);
		
		intakePanel.add(emergencyLabel);
		JPanel emergencyPane = new JPanel();
		emergencyPane.setLayout(new FlowLayout());
		emergencyPane.add(new JLabel("Ethnicity:"));
		emergencyName.setColumns(15);
		emergencyPane.add(emergencyName);
		emergencyPane.add(new JLabel("Race:"));
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
		
		JButton submitPatient = new JButton("Submit");
		submitPatient.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
                  // Update patient 
	        	 
	        	 String [] fields =  {"ID"};
	        	 String [] params = {p.getUser().getID()};
	        	 String [] setFields = {"DOB","Gender","Race","Ethnicity"};
	        	 String date = "";
	        	 try {
	        		date =  new Date(dob.getText()).toString(); 
	        		
	        		
	        		
	        	 }catch(Exception ex){
	        		 dob.setBackground(Color.RED);
	        	 }
	        	 String [] sp = {date,emergencyName.getText(), emergencyPhone.getText(),address.getText(),p.getUser().getID() };
	        	 serv.update(CShareObjects.PATIENT,setFields, sp, fields, params);
	             
	          }
	       });
		
		
		sl.putConstraint(SpringLayout.NORTH, submitPatient, 5, SpringLayout.SOUTH, allergies);
		sl.putConstraint(SpringLayout.WEST, submitPatient, 5, SpringLayout.WEST, intakePanel);
		
		intakePanel.add(submitPatient);
		
		mainPanel.add(intakePanel);
		
	}
}
