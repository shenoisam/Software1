package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslayer.CShareObjects;
import frontend.GenericEnum;

import java.util.List;
import backend.classes.*;

/**
 * displays the staff schedule
 *
 */
public class StaffScheduleScreen extends GenericStaffScreen {

   StaffScheduleScreen(StaffRunner r) {
      super(r);
   }

   private void showSchedule(Container pane) {
      JPanel middleOfScreen = new JPanel();
      middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS));

      JPanel titlePanel = new JPanel();
      titlePanel.setLayout(new GridLayout(1, 3));
      titlePanel.setBorder(BorderFactory.createTitledBorder(""));
      titlePanel.setBackground(Color.GRAY);
      JPanel fillerPanel1 = new JPanel();
      fillerPanel1.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel1);
      JLabel title = new JLabel("Create Appointment");
      title.setFont(title.getFont().deriveFont(15f));
      titlePanel.add(new JLabel(""));
      titlePanel.add(title);
      JPanel fillerPanel2 = new JPanel();
      fillerPanel2.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel2);
      titlePanel.add(new JLabel(""));

      middleOfScreen.add(titlePanel);

      // panel that stores the information on the new appointment
      JPanel makingApptPanel = new JPanel();
      makingApptPanel.setLayout(new BoxLayout(makingApptPanel, BoxLayout.X_AXIS));

      // creating a drop down menu for Patients names
      JPanel patientName = new JPanel();
      patientName.setBorder(BorderFactory.createTitledBorder("Patient Name"));

      // creating drop down menu for patient name
      /**
       * TODO NEED TO ADD DATA TO THE THING TO GET THE REAL PATIENTS FROM THE DATABASE
       */
      
      String [] fields = {};
      String [] params = {};
      final List<Patient> pats = serv.getData(CShareObjects.PATIENT, fields, params);
      // creating the drop down menu
      final JComboBox<String> patients = new JComboBox<String>();
      for(Patient pat : pats) {
    	  patients.addItem(pat.getFullName());
      }

      patientName.add(patients);

      makingApptPanel.add(patientName);

      // creating a drop down menu for providers names
      JPanel providerName = new JPanel();
      providerName.setBorder(BorderFactory.createTitledBorder("Provider's Name"));

      // creating drop down menu for providers name
   
      final JComboBox<String> providers = new JComboBox<String>();
      final List<Doctor> docs = serv.getData(CShareObjects.DOCTOR, fields, params);
      for(Doctor pat : docs) {
    	  providers.addItem(pat.getFullName());
      }

      providerName.add(providers);

      makingApptPanel.add(providerName);

      JPanel aboutPatient2 = new JPanel();

      middleOfScreen.add(makingApptPanel);

      aboutPatient2.setLayout(new BoxLayout(aboutPatient2, BoxLayout.X_AXIS));

      // creating a drop down menu to select date
      JPanel date = new JPanel();
      date.setBorder(BorderFactory.createTitledBorder("Select Date and Time"));

      // creating drop down menu for dates
      /**
       * TODO NEED TO ADD DATA TO THE THING TO GET THE REAL DATES FROM THE DATABASE
       */
  
      final DateTimePicker picker = new DateTimePicker();
      date.add(picker);

      makingApptPanel.add(date);

      JButton name = new JButton("Schedule");
      
      name.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              LocalDateTime lt = LocalDateTime.ofInstant(picker.getDate().toInstant(), picker.getTimeFormat().getCalendar().getTimeZone().toZoneId());
              String [] fields = {"DateVal" , "DoctorID", " PatientID"};
              Doctor d = docs.get(providers.getSelectedIndex());
              Patient pat = pats.get(patients.getSelectedIndex());
              String [] params = {lt.toString(),d.getID(), pat.getID()};
              
              boolean b = serv.insert(CShareObjects.APPOINTMENT, fields, params);
              if(b) {
            	  System.out.println("Success");
              }
           }
        });;

      /**
       * TODO CREATE ACTION FOR THIS BUTTON THAT SENDS EVERYTHING TO THE DATABASE
       */

      aboutPatient2.add(name);
      makingApptPanel.add(aboutPatient2);

      middleOfScreen.add(makingApptPanel);

      titlePanel = new JPanel();
      titlePanel.setLayout(new GridLayout(1, 3));
      titlePanel.setBorder(BorderFactory.createTitledBorder(""));
      titlePanel.setBackground(Color.GRAY);
      fillerPanel1 = new JPanel();
      fillerPanel1.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel1);
      title = new JLabel("Provider's Schedule");
      title.setFont(title.getFont().deriveFont(15f));
      titlePanel.add(new JLabel(""));
      titlePanel.add(title);
      fillerPanel2 = new JPanel();
      fillerPanel2.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel2);
      titlePanel.add(new JLabel(""));

      middleOfScreen.add(titlePanel);

      // create the table to show the provider schedule
      ProvidersSchedule table = new ProvidersSchedule();
      table.setOpaque(true);
      middleOfScreen.add(table);

      pane.add(middleOfScreen);
   }

   /**
    * 
    * creates and shows this page
    * 
    * @param pane the container for this panel to be displayed on 
    * 
    */
   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      showSchedule(pane);
      staffSideBar(pane);
   }

}
