package frontend.patient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import backend.classes.Appointment;
import backend.classes.Diagnosis;
import businesslayer.CShareObjects;

public class PatientHome extends GenericScreen{

	public PatientHome(JFrame f, PatientRunner p) {
		super(f, "Patient Home", p);
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
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		JLabel infoLabel = new JLabel("Current Diagnosis:");
		
		
		String [] fields = {"Name"};
		String [] params = {"Hashimoto's"};
		List<Diagnosis> li = serv.getData(CShareObjects.DIAGNOSIS, fields, params);
		
		
		infoLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		JPanel pane = new JPanel();
		pane.setOpaque(true);
		SpringLayout sl = new SpringLayout();
		sl.putConstraint(SpringLayout.WEST, infoLabel, 5, SpringLayout.WEST, pane);
		sl.putConstraint(SpringLayout.EAST, infoLabel, -5, SpringLayout.EAST, pane);
		sl.putConstraint(SpringLayout.NORTH, infoLabel, 5, SpringLayout.NORTH, pane);
		
		infoLabel.setText(li.get(0).getName() + ":\n " + li.get(0).getDescription());
		pane.setLayout(sl);
		pane.setPreferredSize(new Dimension(10, 100));
		pane.add(infoLabel);
		
		mainPanel.add(pane);
		
		JPanel dataPane = new JPanel();
		dataPane.setLayout(new GridLayout(0 ,2));
		
		
		JPanel medListPane = new JPanel();
		medListPane.setLayout(new BoxLayout(medListPane, BoxLayout.PAGE_AXIS));
		medListPane.add(new JLabel("Current Medication: "));
		String[] medColNames = {"Presciption","Dosage"};
		
		//dummy data
		String[][] meds = {{"Tamiflu", "2 pills a day"},
							{"Doxycycline", "2 pills a day"}};
		
		JTable medTable = new JTable(meds, medColNames);
		JScrollPane scrollMeds = new JScrollPane(medTable);
		medListPane.add(scrollMeds);
		
		String[] doctors = {"Dr.Cerny", "Dr.Booth"};
		JList providersList = new JList(doctors);
		JPanel providerPane = new JPanel();
		providerPane.setLayout(new BoxLayout(providerPane, BoxLayout.PAGE_AXIS));
		providerPane.add(new JLabel("Current Providers:"));
		JScrollPane scrollProv = new JScrollPane(providersList);
		providerPane.add(scrollProv);
		
		dataPane.add(medListPane);
		dataPane.add(providerPane);
		
		mainPanel.add(dataPane);
		
	}
	
	
	
	

}
