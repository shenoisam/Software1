package frontend.provider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


import backend.classes.*;
import businesslayer.CShareObjects;

/**
 * ProviderReferralsView class that
 * displays the provider's view as they refer a doctor
 *
 */
public class ProviderReferralsView extends ProviderFrontend{
	
   // Have a list of doctors that we can update based on specility 
   List<Doctor> docs; 
   private Patient pat; 
   
   /**
    * 
    * @param p
    */
   public ProviderReferralsView(ProviderRunner p) {
		super(p);
		docs = new ArrayList<Doctor>(); 
	}
   
/**
 * 
 * @param providerRunner
 * @param pat
 */
public ProviderReferralsView(ProviderRunner providerRunner, Patient pat) {
	// TODO Auto-generated constructor stub
	this(providerRunner);
	this.pat = pat; 
	
}

/**
 * 
 * @param pane
 */
public void patientReferralPanel(Container pane) {
      // creating the main referral panel
      JPanel referralPanel = new JPanel();
      referralPanel.setLayout(new GridLayout(1,2));
      
      // creating the left hand side of the page 
      JPanel leftPanel = new JPanel();
      leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
      
      // creating the specality section
      JPanel specialtyPanel = new JPanel();
      specialtyPanel.setBorder(BorderFactory.createTitledBorder("Specialty"));
      JComboBox specalites = new JComboBox(new Object[] { "", "Radiology", "Obstetrics & Gynecology", "Cardiovascular", "Anesthesiology", "Orthopaedic Surgery", "Ophthalmology", "Dermatology", "Pediatrics" });
      
      specialtyPanel.add(specalites);
      leftPanel.add(specialtyPanel);
      
      // creating the provider section
      JPanel providerPanel = new JPanel();
      providerPanel.setBorder(BorderFactory.createTitledBorder("Provider"));
      
      /**** Data Retrieve *****/
      String [] fields = {};
      String [] params = {};
      docs = serv.getData(CShareObjects.DOCTOR, fields, params);
      
      
      JComboBox providers = new JComboBox(docs.toArray());
      providerPanel.add(providers);
      
      // adding the provider panel to the left panel
      leftPanel.add(providerPanel);
      
      // creating the additional notes section
      JPanel notes = new JPanel();
      notes.setBorder(BorderFactory.createTitledBorder("Additional Notes"));
      notes.setLayout(new BoxLayout(notes, BoxLayout.Y_AXIS));
      
      // creating the notes entered text area
      JTextArea notesEntered = new JTextArea(4, 10);
      notesEntered.setText("");
      notesEntered.setEditable(true);
      notesEntered.setLineWrap(true);
      JScrollPane scroll = new JScrollPane(notesEntered);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      notes.add(scroll);
      
      // adding the notes to the notes and submit section
      leftPanel.add(notes);
      
      // adding the left panel to the main panel veiw
      referralPanel.add(leftPanel);
      
      // creating the right hand side of the page 
      JPanel rightPanel = new JPanel();
      rightPanel.setLayout(new GridLayout(2,1));
      
      // creating reason for referral panel
      JPanel reason = new JPanel();
      reason.setBorder(BorderFactory.createTitledBorder("Reason For Referral"));
      reason.setLayout(new BoxLayout(reason, BoxLayout.Y_AXIS));
      
      /***** Data retrieval ******/
      String [] fields2 = {"PatientID"};
      String [] params2 = {pat.getID()};
      List<PatientDiagnosis> diags = serv.getData(CShareObjects.PATIENTDIAGNOSIS, fields2, params2);
      
      for (PatientDiagnosis pd : diags) {
    	  reason.add(createDiagnosis(pd));
      }
      JCheckBox other = new JCheckBox("Other (input reason below)");
      other.setSelected(false);
      reason.add(other);
      JTextArea otherReason = new JTextArea(1, 5);
      otherReason.setEditable(true);
      reason.add(otherReason);
      
      // adding invisible panels for formating
      reason.add(new JPanel());
      reason.add(new JPanel());
      reason.add(new JPanel());
      reason.add(new JPanel());

      // adding the reason for referral to the right panel
      rightPanel.add(reason);
      
      // creating the refer button
      JPanel refferButtonPanel = new JPanel();
      refferButtonPanel.setLayout(new BoxLayout(refferButtonPanel, BoxLayout.LINE_AXIS));
      refferButtonPanel.add(new JPanel());
      refferButtonPanel.add(new JButton("Refer"));
      refferButtonPanel.add(new JPanel());
      
      // adding the submit panel to the notes and submit panel
      rightPanel.add(refferButtonPanel);

      // adding the right panel to the main referral page
      referralPanel.add(rightPanel);
      
      // adding the referral panel to the passed in container
      pane.add(referralPanel);
   }

/**
 * 
 * @param d
 * @return
 */
   private JCheckBox createDiagnosis(PatientDiagnosis d) {
	   JCheckBox daignosis1 = new JCheckBox(d.getName());
	   daignosis1.setSelected(false);
	   return daignosis1;
   }
   
   /**
    * @param frame
    */
   public void createAndShowGUI(JFrame frame) {
      // creating the panes within the screen
      providerSideBar(frame.getContentPane(), pat);
      topBarPatientInformation(frame.getContentPane(), pat);
      patientReferralPanel(frame.getContentPane());

   }
   
   /**
    * @param frame
    * @param pat
    */
   public void createAndShowGUI(JFrame frame, Patient pat) {
	   this.pat = pat; 
	   createAndShowGUI(frame);
   }
}




