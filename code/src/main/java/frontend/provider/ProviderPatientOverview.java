/*
 * This class is used to implement the Provider Patient Overview
 * Call createAndShowProviderPatientOverview() to generate the GUI
 */

package frontend.provider;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import backend.classes.*;

import businesslayer.CShareObjects;

/**
 * ProviderPatientOverview class that displays
 * patient information to a provider
 *
 */
public class ProviderPatientOverview extends ProviderFrontend{


   static Patient pat;


   public ProviderPatientOverview(ProviderRunner p) {
      super(p);
      pat = new Patient();
      // TODO Auto-generated constructor stub
   }


   /**
    * 
    * @param providerRunner
    * @param pat
    */

   public ProviderPatientOverview(ProviderRunner providerRunner, Patient pat) {
      super(providerRunner);
      this.pat = pat;

      // TODO Auto-generated constructor stub
   }

   private static void patientInformationPanel(Container pane) {
      // Patient p = new Patient(null);

      // creating the patient information panel to store all the information
      JPanel patientInformation = new JPanel();
      patientInformation.setLayout(new GridLayout(3, 2));

      // creating the image panel
      /*JPanel imagePanel = new JPanel();
      imagePanel.setBackground(Color.white);

      // getting the image from a file
      BufferedImage image = null;
      String workingDir = System.getProperty("user.dir");
      try {
    	 
         image = ImageIO.read( new File(ProviderPatientOverview.class.getClassLoader().getResource("person-icon.jpg").getFile()));
        		 
        		 
      } catch (Exception e) {
         e.printStackTrace();
         System.exit(1);
      }

      // resizing the image
      ImageIcon imageIcon = new ImageIcon(image);
      Image image2 = imageIcon.getImage();
      Image newimg = image2.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
      imageIcon = new ImageIcon(newimg);
      JLabel jLabel = new JLabel();
      jLabel.setIcon(imageIcon);

      // adding the image to the panel
      imagePanel.add(jLabel);

      // adding the panel to the patient information panel
      patientInformation.add(imagePanel);
   */
      // creating the diagnosis section
      JPanel diagnosis = new JPanel();
      diagnosis.setBorder(BorderFactory.createTitledBorder("Diagnosis"));

      // creating the text area to display the diagnosises
      JTextArea display = new JTextArea(6, 21);

      /********** Data Retrieval **********/
      String[] fields = { "PatientID" };
      String[] params = { pat.getID() };
      List<PatientDiagnosis> pds = serv.getData(CShareObjects.PATIENTDIAGNOSIS, fields, params);
      String text = "";
      String[] fields2 = { "Name" };
      String[] params2 = new String[1];
      for (PatientDiagnosis z : pds) {
         params2[0] = z.getName();

         List<Diagnosis> diag = serv.getData(CShareObjects.DIAGNOSIS, fields2, params2);
         text = text + diag.stream().map(e -> e.getName()).reduce("\n", String::concat) + "\n";
      }
      /******* End data retrieval ********/

      display.setText(text);
      display.setEditable(false); // set textArea non-editable
      display.setLineWrap(true);

      // creating the scroll pane for the text area
      JScrollPane scroll = new JScrollPane(display);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scrollable text area to the diagnosis panel
      diagnosis.add(scroll);

      // adding the diagnosis panel to the main panel
      patientInformation.add(diagnosis);

      // creating the Next Appointment area
      JPanel NextAppointment = new JPanel();
      NextAppointment.setBorder(BorderFactory.createTitledBorder("Next Appointment"));

      // creating the text area for the appointment
      JTextArea appointmentTime = new JTextArea(6, 23);

      /***** Data Retrieval ****/
      List<Appointment> apts = serv.getData(CShareObjects.APPOINTMENT, fields, params);
      String apt;
      if (apts.size() > 0) {
         apt = apts.get(0).getAppointmentDate().toString();
      } else {
         apt = "No appointment scheduled";
      }
      /*** End data retrieval *******/

      appointmentTime.setText(apt);
      appointmentTime.setEditable(false);
      appointmentTime.setLineWrap(true);

      // adding the appointment time to the panel
      NextAppointment.add(appointmentTime);

      // adding the panel to the main panel
      patientInformation.add(NextAppointment);

      // creating the medication panel
      JPanel currentMedication = new JPanel();
      currentMedication.setBorder(BorderFactory.createTitledBorder("Current Medication"));

      // creating the medication list text area
      JTextArea medicationList = new JTextArea(6, 21);

      /****** Data Retreival ***/
      List<Perscription> pres = serv.getData(CShareObjects.PRESCRIPTION, fields, params);
      String stuff = "No Prescriptions on file";
      if (pres.size() > 0) {

         stuff = pres.stream().map(e -> e.getPerscriptionName() + "\n").reduce("\n", String::concat) + "\n";
      }
      /**** End Data retrieval *****/

      medicationList.setText(stuff);
      medicationList.setEditable(false);
      medicationList.setLineWrap(true);

      // creating the scroll pane for the medication list
      scroll = new JScrollPane(medicationList);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scroll area to the medication panel
      currentMedication.add(scroll);

      // adding the medication to the patient information pane
      patientInformation.add(currentMedication);

      // creating the patient history panel
      JPanel patientHistory = new JPanel();
      patientHistory.setBorder(BorderFactory.createTitledBorder("Patient History"));

      // creating the text area for the patient history
      JTextArea history = new JTextArea(6, 21);

      /***** Data retrival ****/

      // For this section we are just going to display doctor notes.

      List<Notes> notes = serv.getData(CShareObjects.NOTES, fields, params);
      String noteHistory = "No patient history";
      if (notes.size() > 0) {
         for (Notes n : notes) {
            if (n.getChiefComplaint() != null) {
               noteHistory += n.getChiefComplaint() + " : " + n.getNote() + "\n";
            } else {
               noteHistory += n.getNote();
            }
         }
         // noteHistory = notes.stream().map(e -> e.getChiefComplaint() +
         // e.getNote()).reduce("\n", String::concat) + "\n";
      }

      /*** end data retrieval ****/

      history.setText(noteHistory);
      history.setEditable(false);
      history.setLineWrap(true);

      // creating the scroll bar for the history text area
      scroll = new JScrollPane(history);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scroll bar to the patient history panel
      patientHistory.add(scroll);

      // adding the patient history panel to the patient information panel
      patientInformation.add(patientHistory);

      // creating the tests and results panel
      JPanel testsAndResult = new JPanel();
      testsAndResult.setBorder(BorderFactory.createTitledBorder("Tests and Result"));

      // creating the list of results text area
      JTextArea listOfResults = new JTextArea(6, 21);

      /**** Data retrieval ****/
      List<TestResult> tr = serv.getData(CShareObjects.TESTRESULT, fields, params);
      String testres = "";
      if (tr.size() > 0) {
         testres = testres + tr.stream().map(e -> e.getTestName() + ": " + e.getResult() + "\n").reduce("\n", String::concat) + "\n";
      }
      List<TestOrder> to = serv.getData(CShareObjects.TESTORDER, fields, params);
      if (to.size() > 0) {
         testres = testres + to.stream().map(e -> e.getTestName()).reduce("\n", String::concat) + "\n";
      }
      if (to.size() == 0 && tr.size() == 0) {
         testres = "No tests ordered";
      }
      /**** End data retrieval ***/

      listOfResults.setText(testres);
      listOfResults.setEditable(false);
      listOfResults.setLineWrap(true);

      // creating a scroll pane for the list of results
      scroll = new JScrollPane(listOfResults);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scroll bar to the test and result panel
      testsAndResult.add(scroll);

      // adding the test results to the patient information panel
      patientInformation.add(testsAndResult);

      // adding the main panel to the continer given
      pane.add(patientInformation);
   }

   public void createAndShowGUI(JFrame frame) {
      providerSideBar(frame.getContentPane(), pat);
      topBarPatientInformation(frame.getContentPane(), pat);
      patientInformationPanel(frame.getContentPane());

   }

   public void createAndShowGUI(JFrame frame, Patient pat) {

      this.pat = pat;
      createAndShowGUI(frame);

   }
}
