package frontend.provider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

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

import backend.classes.Patient;

public class ProviderReferralsView extends ProviderFrontend{
  
   private Patient pat; 
   public ProviderReferralsView(ProviderRunner p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

public ProviderReferralsView(ProviderRunner providerRunner, Patient pat) {
	// TODO Auto-generated constructor stub
	super(providerRunner);
	this.pat = pat; 
}

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
      JComboBox providers = new JComboBox(new Object[] { "", "Dr. Mickey Mouse", "Dr. Minnie Mouse", "Dr. Goofy", "Dr. Donald Duck", "Dr. Daffy Duck", "Dr. Pluto"});
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
      
      // creating check boxes for each diagnosis option
      JCheckBox daignosis1 = new JCheckBox("Daignosis 1");
      daignosis1.setSelected(false);
      reason.add(daignosis1);

      JCheckBox daignosis2 = new JCheckBox("Daignosis 2");
      daignosis2.setSelected(false);
      reason.add(daignosis2);

      JCheckBox daignosis3 = new JCheckBox("Daignosis 3");
      daignosis3.setSelected(false);
      reason.add(daignosis3);

      JCheckBox daignosis4 = new JCheckBox("Daignosis 4");
      daignosis4.setSelected(false);
      reason.add(daignosis4);
      
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
   
   public void createAndShowGUI(JFrame frame) {
  


      // creating the panes within the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientReferralPanel(frame.getContentPane());

   }
}




