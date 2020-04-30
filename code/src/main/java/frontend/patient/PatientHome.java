package frontend.patient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

import backend.classes.Diagnosis;
import backend.classes.Doctor;
import backend.classes.Notes;
import backend.classes.Perscription;
import businesslayer.CShareObjects;

public class PatientHome extends PatientGenericScreen{

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
		String [] params = {"Breast Cancer"};
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
		String[] medColNames = {"Prescription","Dosage"};
		
		String [] f = {"PatientID"};
		String [] pa = {((backend.classes.Patient)p.getUser()).getPatientID()};
		List<Object> list = serv.getData(CShareObjects.PRESCRIPTION, f, pa);
		List<String[]> stringList = new ArrayList<String[]>();
		
		for(Object object : list) {
			Perscription pres = (Perscription) object;
			DecimalFormat df = new DecimalFormat("####0.00");
			String [] element = {pres.getPerscriptionName(), "Dosage is " + df.format(pres.getDosage()) + " a day."};
			stringList.add(element);
		}
		String[][] meds = new String[stringList.size()][2];
		stringList.toArray(meds);
		
		JTable medTable = new JTable(meds, medColNames);
		JScrollPane scrollMeds = new JScrollPane(medTable);
		medListPane.add(scrollMeds);
		
		String [] nFields = {"PatientID"};
		String [] nParams = {((backend.classes.Patient)p.getUser()).getPatientID()};
		list = serv.getData(CShareObjects.NOTES, nFields, nParams);
		List<String> doctorList = new ArrayList<String>();
		
		for(Object object : list) {
			//doctorList.add(((Notes)object).getDoctorID());
			
			Notes note = (Notes) object;
			String doctorID = note.getDoctorID();
			
			String [] dFields = {"ID"};
			String [] dParams = {doctorID};
			List<Object> doctorL = serv.getData(CShareObjects.DOCTOR, dFields, dParams);
			String doctorName = "";
			for(Object d : doctorL) {
				doctorName = ((Doctor)d).getFullName();
			}
					
			if(!doctorList.contains(doctorName)) {
				doctorList.add(doctorName);
			}
			
		}
		String[] doctors = new String [doctorList.size()];
		doctorList.toArray(doctors);
		
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
