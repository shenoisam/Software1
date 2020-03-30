/*
 * This class is used to implement the Provider Patient Visit veiw
 * Call createAndShowProviderPatientVisit() to generate the GUI
 */
package providerfrontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

public class ProviderPatientVisit {
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

   public void patientVisitPanel(Container pane) {
      // creating the panel to store the whole visit
      JPanel visitPanel = new JPanel();
      visitPanel.setLayout(new GridLayout(2, 2));

      // creating the panel to store the cheif complaint
      JPanel chiefComplaint = new JPanel();
      chiefComplaint.setBorder(BorderFactory.createTitledBorder("Chief Complaint"));

      // creating the complaints text area
      JTextArea complaints = new JTextArea(6, 21);
      complaints.setText("Patient complains of insomina and eye pain");
      complaints.setEditable(true);
      complaints.setLineWrap(true);

      // creating a scroll pane for the complaints
      JScrollPane scroll = new JScrollPane(complaints);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scroll bar to the complaints panel
      chiefComplaint.add(scroll);

      // adding the chief complaint pane to the main visit pane
      visitPanel.add(chiefComplaint);

      // creating the form for vitals
      JPanel vitals = new JPanel(new SpringLayout());
      vitals.setBorder(BorderFactory.createTitledBorder("Vitals"));

      // create the form and place the labels
      String[] labels = { "Body Temp: ", "Pulse Rate: ", "Respiration Rate: ", "Blood Pressure: " };
      int numPairs = labels.length;
      for (int i = 0; i < numPairs; i++) {
         JLabel l = new JLabel(labels[i], JLabel.TRAILING);
         vitals.add(l);
         JTextField textField = new JTextField(10);
         l.setLabelFor(textField);
         vitals.add(textField);
      }

      // Lay out the panel
      SpringUtilities.makeCompactGrid(vitals, numPairs, 2, // rows, cols
            6, 6, // initX, initY
            6, 6); // xPad, yPad

      // adding the vitals to the main visit panel
      visitPanel.add(vitals);

      // creating the panel to store the physical exam notes
      JPanel physicalExam = new JPanel();
      physicalExam.setBorder(BorderFactory.createTitledBorder("Physical Exam"));

      // creating the exam notes text area
      JTextArea examNotes = new JTextArea(6, 21);
      examNotes.setText("Patient is stable. Eyes appear to be normal. Breathing is normal.");
      examNotes.setEditable(true);
      examNotes.setLineWrap(true);

      // creating a scroll pane for the exam notes
      scroll = new JScrollPane(examNotes);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scroll bar to the exam notes panel
      physicalExam.add(scroll);

      // adding the exam notes panel to the main visit pane
      visitPanel.add(physicalExam);

      // creating the panel to store the next step notes
      JPanel nextSteps = new JPanel();
      nextSteps.setBorder(BorderFactory.createTitledBorder("Next Steps"));

      // creating the next steps text area
      JTextArea notes = new JTextArea(6, 21);
      notes.setText("");
      notes.setEditable(true);
      notes.setLineWrap(true);

      // creating a scroll pane for the next steps
      scroll = new JScrollPane(notes);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      // adding the scroll bar to the next steps panel
      nextSteps.add(scroll);

      // adding the next steps panel to the main visit pane
      visitPanel.add(nextSteps);

      // adding the created portion to the componet that was passed in
      pane.add(visitPanel);
   }

   public void createAndShowProviderPatientVisit() {
      // creating the frame for the screen
      JFrame frame = new JFrame("Provider Patient Overview");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(750, 500));

      // creating the panes within the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientVisitPanel(frame.getContentPane());

      // allowing the contents of the screen to be seen
      frame.pack();
      frame.setVisible(true);
   }
}
