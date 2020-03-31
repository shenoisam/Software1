package providerfrontend;

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

public class ProviderReferralsView {
   private static void providerSideBar(Container pane) {
      // creating the whole side panel
      JPanel sidePanel = new JPanel();
      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
      sidePanel.setBorder(BorderFactory.createTitledBorder(""));
      
      // creating the button panel to organize the location of the buttons
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
      JButton button = new JButton("Patient Overview");
      buttonPanel.add(button);
      button = new JButton("Patient Visit");
      buttonPanel.add(button);
      button = new JButton("Prescribe");
      buttonPanel.add(button);
      button = new JButton("Request a Test");
      buttonPanel.add(button);
      button = new JButton("View Test Results");
      buttonPanel.add(button);
      button = new JButton("Referrals");
      buttonPanel.add(button);
      sidePanel.add(buttonPanel);
      
      // adding the side panel to the layout
      pane.add(sidePanel, BorderLayout.WEST);
   }
   
   private static void topBarPatientInformation(Container pane) {
      // creating the top panel to store all the information
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

      // creating the buttonPanel with the Home and Logout buttons
      JPanel buttonPanel = new JPanel();
      JButton button = new JButton("Home");
      buttonPanel.setLayout(new BorderLayout());
      buttonPanel.add(button, BorderLayout.WEST);
      button = new JButton("Logout");
      buttonPanel.add(button, BorderLayout.EAST);
      topPanel.add(buttonPanel);

      // creating the panel with the patient's Name
      JPanel patientPanel = new JPanel();
      patientPanel.setBorder(BorderFactory.createTitledBorder(""));
      patientPanel.setPreferredSize(new Dimension(500, 50));
      patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.X_AXIS));

      // displaying the patient's name
      JLabel patientName = new JLabel("Patient's name");
      patientName.setFont(patientName.getFont().deriveFont(35f));
      patientPanel.add(patientName);

      JPanel patientInformation = new JPanel();
      patientInformation.setLayout(new GridLayout(1, 4));

      // displaying the patient's gender
      JPanel gender = new JPanel();
      gender.setLayout(new BoxLayout(gender, BoxLayout.Y_AXIS));
      JLabel sexTitle = new JLabel("SEX");
      sexTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      gender.add(sexTitle);
      JLabel patientGender = new JLabel("-");
      patientGender.setAlignmentX(Component.CENTER_ALIGNMENT);
      gender.add(patientGender);
      patientInformation.add(gender);

      // displaying the patient's date of birth
      JPanel dateOfBirth = new JPanel();
      dateOfBirth.setLayout(new BoxLayout(dateOfBirth, BoxLayout.Y_AXIS));
      JLabel dateOfBirthTitle = new JLabel("DOB");
      dateOfBirthTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      dateOfBirth.add(dateOfBirthTitle);
      JLabel patientDateOfBirth = new JLabel("MM-DD-YY");
      patientDateOfBirth.setAlignmentX(Component.CENTER_ALIGNMENT);
      dateOfBirth.add(patientDateOfBirth);
      patientInformation.add(dateOfBirth);

      // displaying the patient's Primary Care Physician
      JPanel primaryCarePhysician = new JPanel();
      primaryCarePhysician.setLayout(new BoxLayout(primaryCarePhysician, BoxLayout.Y_AXIS));
      JLabel pcpTitle = new JLabel("PCP");
      pcpTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      primaryCarePhysician.add(pcpTitle);
      JLabel pcpName = new JLabel("Dr. Ima NotReal");
      pcpName.setAlignmentX(Component.CENTER_ALIGNMENT);
      primaryCarePhysician.add(pcpName);
      patientInformation.add(primaryCarePhysician);

      // displaying the patient's allergies
      JPanel allergies = new JPanel();
      allergies.setLayout(new BoxLayout(allergies, BoxLayout.Y_AXIS));
      JLabel allergiesTitle = new JLabel("Allergies");
      allergiesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      allergies.add(allergiesTitle);
      JLabel allergiesList = new JLabel("None");
      allergiesList.setAlignmentX(Component.CENTER_ALIGNMENT);
      allergies.add(allergiesList);
      patientInformation.add(allergies);

      patientPanel.add(patientInformation);
      // adding the name panel to the main panel
      topPanel.add(patientPanel);

      // adding the top Panel to the contianer that was passed in to the function
      pane.add(topPanel, BorderLayout.NORTH);
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
   
   public void createAndShowProviderReferralsView() {
      // creating the frame for the screen
      JFrame frame = new JFrame("Referral");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(750, 500));

      // creating the panes within the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientReferralPanel(frame.getContentPane());

      // allowing the contents of the screen to be seen
      frame.pack();
      frame.setVisible(true);
   }
}




