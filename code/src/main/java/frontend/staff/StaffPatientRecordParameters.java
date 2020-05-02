package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.classes.Diagnosis;
import backend.classes.Doctor;
import backend.classes.Patient;
import backend.classes.Perscription;
import businesslayer.CShareObjects;
import frontend.GenericEnum;

public class StaffPatientRecordParameters extends GenericStaffScreen {
   private String ageRangeToLookAt;
   private String diagnosisToLookAt;
   private String doctorsToLookAt;
   private String presciptionsToLookAt;
   
   StaffPatientRecordParameters(StaffRunner r) {
      super(r);
      // TODO Auto-generated constructor stub
   }

   private void parameters(Container pane) {
      // creating panel to store all of the parameters
      JPanel main = new JPanel();
      
      JPanel titlePanel = new JPanel();
      titlePanel.setLayout(new GridLayout(1, 3));
      titlePanel.setBorder(BorderFactory.createTitledBorder(""));
      titlePanel.setBackground(Color.GRAY);
      JPanel fillerPanel1 = new JPanel();
      fillerPanel1.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel1);
      JLabel title = new JLabel("Select Parameters for Patient Records");
      title.setFont(title.getFont().deriveFont(15f));
      titlePanel.add(new JLabel(""));
      titlePanel.add(title);
      JPanel fillerPanel2 = new JPanel();
      fillerPanel2.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel2);
      titlePanel.add(new JLabel(""));

      // creating parameter #1
      /*JPanel ageRange = new JPanel();
      ageRange.setBorder(BorderFactory.createTitledBorder("Age Range"));
      JComboBox<String> age = new JComboBox<String>();
      age.addItem("n/a");
      age.addItem("0 – 5");
      age.addItem("6 – 12");
      age.addItem("13 – 19");
      age.addItem("20 – 35");
      age.addItem("36 - 50");
      age.addItem("50 - 65");
      age.addItem("66 - 80");
      age.addItem("80+");
      ageRange.add(age);*/

      // creating parameter #2
      JPanel diagnosis = new JPanel();
      diagnosis.setBorder(BorderFactory.createTitledBorder("Diagnosis"));
      JComboBox<String> allDiagnosis = new JComboBox<String>();
      String [] fields = {};
      String [] params = {};
      List<Diagnosis> diags = serv.getData(CShareObjects.DIAGNOSIS,fields,params);
       allDiagnosis.addItem("");
      for (Diagnosis d : diags) {
    	  
    	  allDiagnosis.addItem(	d.getName());
      }
      diagnosis.add(allDiagnosis);
      // creating parameter #3
      
      List<Doctor> docs = serv.getData(CShareObjects.DOCTOR,fields,params);
      JPanel doctor = new JPanel();
      doctor.setBorder(BorderFactory.createTitledBorder("Doctor"));
      JComboBox<String> allDoctors = new JComboBox<String>();
      allDoctors.addItem("");
      for (Doctor d : docs) {
    	  allDoctors.addItem(d.getFullName());
      }
      doctor.add(allDoctors);

      // creating parameter #4
      JPanel prescrip = new JPanel();
     
      List<Perscription > pres = serv.getData(CShareObjects.PRESCRIPTION,fields,params);
      prescrip.setBorder(BorderFactory.createTitledBorder("Prescriptions"));
      JComboBox<String> allPrescrips = new JComboBox<String>();
      allPrescrips.addItem("");
      for (Perscription d : pres) {
    	  allPrescrips.addItem(d.getPerscriptionName());
      }
      prescrip.add(allPrescrips);
      
      main.add(titlePanel);
     
      main.add(diagnosis);
      main.add(doctor);
      main.add(prescrip);
      
      JButton submit = new JButton("Submit");
      submit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 int ndx = allDoctors.getSelectedIndex();
        	 String id ="";
        	 if (ndx > 0) {
        		 id =  docs.get(ndx).getDoctorID();
        	 }
        	 System.out.println(allDiagnosis.getSelectedItem().toString());
        	 List<Patient> pat_Data = serv.bigDataQuery( id , allDiagnosis.getSelectedItem().toString(), allPrescrips.getSelectedItem().toString());
        	 if( pat_Data.size()< 1) {
        	    pat_Data = new ArrayList<Patient>(); 
        	 }
       
             r.specialDisplay(pat_Data);
         }
      });

      main.add(submit);
      
      // adding the main panel to the container sent in
      pane.add(main);
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      parameters(pane);
      staffSideBar(pane);
   }

   public String getAgeRangeToLookAt() {
      return ageRangeToLookAt;
   }

   public String getDiagnosisToLookAt() {
      return diagnosisToLookAt;
   }

   public String getDoctorsToLookAt() {
      return doctorsToLookAt;
   }

   public String getPresciptionsToLookAt() {
      return presciptionsToLookAt;
   }

}
