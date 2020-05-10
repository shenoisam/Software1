/*
 * This class is used to implement the Provider Homescreen
 * Call createAndShowProviderHomescreen() to generate the GUI
 */

package frontend.provider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.classes.Appointment;
import backend.classes.Diagnosis;
import backend.classes.Patient;
import backend.classes.PatientDiagnosis;
import businesslayer.CShareObjects;
import frontend.GenericEnum;
import frontend.provider.Components.SideBarWithCalendar;
import frontend.provider.Components.TopBarProviderHomescreen;

/**
 * ProviderHomeScreen class that displays the 
 * health care provider's home screen view
 *
 */
public class ProviderHomescreen extends ProviderFrontend {
   private static List<Appointment> li;

   /**
    * 
    * @param p
    */
   public ProviderHomescreen(ProviderRunner p) {
      super(p);
      LocalDateTime date = LocalDateTime.now();
      String[] params = { date.toString() };
      String[] fields = { "DateVal" };
      li = serv.getData(CShareObjects.APPOINTMENT, fields, params);

   }

  
   /**
    * 
    * @param pane
    */
   private static void listOfAppointments(Container pane) {
      // creating the panel for the appointment list
      JPanel appointmentList = new JPanel();
      appointmentList.setLayout(new BoxLayout(appointmentList, BoxLayout.Y_AXIS));

      /*
       * THIS IS A PSUDEO IMPLEMENTATION OF HOW IT SHOULD BE, CURRENTLY HAS NO
       * INTERACTION WITH THE DATABASE
       */

      // creating a panel to show the current date
      JPanel datePanel = new JPanel();
      datePanel.setBorder(BorderFactory.createTitledBorder(""));
      datePanel.setBackground(Color.lightGray);
      Date d = new Date();
      datePanel.add(new JLabel(d.toString()), BorderLayout.CENTER);

      // adding the date panel to the appointment list
      appointmentList.add(datePanel);

      // creating the appointments

      for (int i = 0; i < li.size(); i += 1) {
         String[] fields2 = { "ID" };
         String[] params2 = { li.get(i).getPatientID() };

         List<Patient> pat = serv.getData(CShareObjects.PATIENT, fields2, params2);
         Patient pp = null;
         if (pat.size() > 0) {
            pp = pat.get(0);
         } else {
            pp = new Patient(null);
         }

         // .get(0);
         String[] fields3 = { "PatientID" };
         List<Object> pd = (List<Object>) serv.getData(CShareObjects.PATIENTDIAGNOSIS, fields3, params2);

         List<Diagnosis> pds = new ArrayList<Diagnosis>();
         for (Object p : pd) {
            PatientDiagnosis z = (PatientDiagnosis) p;
            String[] params4 = { z.getName() };
            String[] fields4 = { "Name" };
            pds.add((Diagnosis) serv.getData(CShareObjects.DIAGNOSIS, fields4, params4).get(0));
         }
         // adding the appointment to the appointment list
         appointmentList.add(appointment(li.get(i), pp, pds));

      }

      pane.add(appointmentList);
   }

   /**
    * 
    * @param a
    * @param pat
    * @param d
    * @return
    */
   private static JPanel appointment(Appointment a, Patient pat, List<Diagnosis> d) {
      // creating the individual appointment panel
      JPanel appointment = new JPanel();
      appointment.setBorder(BorderFactory.createTitledBorder(""));
      appointment.setLayout(new GridLayout(2, 3));

      // creating the time and patient name panel
      JPanel timeAndName = new JPanel();
      timeAndName.setBackground(Color.white);
      timeAndName.setLayout(new BoxLayout(timeAndName, BoxLayout.Y_AXIS));
      timeAndName.add(new JLabel("Appointment Time: " + a.getAppointmentDate().toString()));
      timeAndName.add(new JLabel("Patient Name: " + pat.getFullName()));

      // adding the panel to the appointment panel
      appointment.add(timeAndName);

      // creating the diagnosis panel
      JPanel diagnosis = new JPanel();
      diagnosis.setBackground(Color.white);
      diagnosis.setLayout(new BoxLayout(diagnosis, BoxLayout.Y_AXIS));
      diagnosis.add(new JLabel("Diagnosis:"));

      if (d.size() > 0) {
    	 String w = ""; 
    	 for(Diagnosis z : d) {
    		 w += z.getName() + " , ";
    	
    	 }
 
         diagnosis.add(new JLabel(w));
      } else {
         diagnosis.add(new JLabel("None"));
      }

      // adding the panel to the appointment panel
      appointment.add(diagnosis);

      // creating and adding an invisible panel for formating
      JPanel invisible = new JPanel();
      invisible.setBackground(Color.white);
      appointment.add(invisible);

      // creating the reason for visit panel
      JPanel reasonForVisit = new JPanel();
      reasonForVisit.setBackground(Color.white);
      reasonForVisit.setLayout(new BoxLayout(reasonForVisit, BoxLayout.Y_AXIS));
      reasonForVisit.add(new JLabel("Reason for Visit:"));
      reasonForVisit.add(new JLabel("Checkup"));

      JButton button = new JButton("View Patient");

      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            p.displayFrameOpt(GenericEnum.POVERVIEW, pat);
         }
      });

      // adding the panel to the appointment panel
      appointment.add(reasonForVisit);
      timeAndName.add(button);

      return appointment;
   }

   /**
    * @param frame
    */
   public void createAndShowGUI(JFrame frame) {
      // creating the frame for the screen
      /*
       * JFrame frame = new JFrame("Home");
       * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       * frame.setPreferredSize(new Dimension(750, 500));
       */

      // creating the panes within the screen
      TopBarProviderHomescreen.addTopBar(frame.getContentPane(), p,li);
      SideBarWithCalendar.addSideBar(frame.getContentPane(), p);
      listOfAppointments(frame.getContentPane());

      // allowing the contents of the screen to be seen
      // frame.pack();
      // frame.setVisible(true);
   }

   public void createAndShowGUI(JFrame frame, Patient pat) {

      createAndShowGUI(frame);
   }
}
