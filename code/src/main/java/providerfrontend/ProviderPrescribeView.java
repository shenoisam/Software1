package providerfrontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ProviderPrescribeView {
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

   public void patientPrescribePanel(Container pane) {
      // setting up the prescribe panel
      JPanel prescribePanel = new JPanel();
      prescribePanel.setLayout(new GridLayout(3, 2));

      // creating the medication name search bar panel
      JPanel medicationNameSearch = new JPanel();
      medicationNameSearch.setLayout(new GridLayout(3,3));
      medicationNameSearch.setBorder(BorderFactory.createTitledBorder("Medication Name"));
      
      // creating the list of medications
      ArrayList<String> medications = new ArrayList<String>();
      medications.add("Vicodin");
      medications.add("Simvastatin");
      medications.add("Lisinopril");
      medications.add("Levothyroxine");
      medications.add("Azithromycin");
      medications.add("Metformin");
      medications.add("Lipitor");
      medications.add("Amlodipine");

      // creating the searchable drop down menu
      StringSearchable searchable = new StringSearchable(medications);
      AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);

      JPanel searchBarOnly = new JPanel();
      searchBarOnly.setLayout(new BorderLayout());
      searchBarOnly.add(combo, BorderLayout.PAGE_START);
      // adding the dropdown menu to the medication panel
      
      medicationNameSearch.add(searchBarOnly);
      
      medicationNameSearch.add(new JPanel());
      medicationNameSearch.add(new JPanel());
      medicationNameSearch.add(new JPanel());
      medicationNameSearch.add(new JPanel());

      // adding the medication panel to the prescribe panel
      prescribePanel.add(medicationNameSearch);

      // creating the panel for the dosage
      JPanel dosagePanel = new JPanel();
      dosagePanel.setLayout(new BoxLayout(dosagePanel, BoxLayout.X_AXIS));
      dosagePanel.setBorder(BorderFactory.createTitledBorder("Dosage"));

      // creating the dosage dropdown bar and adding it to the dosage panel
      JComboBox dosageCount = new JComboBox(new Object[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
      dosagePanel.add(dosageCount);
      
      // creating the transition label and adding it to the dosage panel
      JLabel timesA = new JLabel();
      timesA.setText(" times a ");
      dosagePanel.add(timesA);
      
      // creating the radio buttons for frequency
      JPanel frequencyGroup = new JPanel();
      frequencyGroup.setLayout(new BoxLayout(frequencyGroup, BoxLayout.Y_AXIS));
      JRadioButton day = new JRadioButton();
      day.setText("day");
      JRadioButton week = new JRadioButton();
      week.setText("week");
      JRadioButton biWeekly = new JRadioButton();
      biWeekly.setText("bi-weekly");
      JRadioButton month = new JRadioButton();
      month.setText("month");
      frequencyGroup.add(day);
      frequencyGroup.add(week);
      frequencyGroup.add(biWeekly);
      frequencyGroup.add(month);

      // adding the frequency to the dosage panel
      dosagePanel.add(frequencyGroup);
      
      // creating the transition lable and adding it to the dosage panel
      JLabel forLabel = new JLabel();
      forLabel.setText(" for ");
      dosagePanel.add(forLabel);
      
      // creating the length drop down bar and adding it to the dosage panel
      JComboBox lengthCount = new JComboBox(new Object[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
      dosagePanel.add(lengthCount);
      
      // creating the radio buttons for the length
      JPanel lengthGroup = new JPanel();
      lengthGroup.setLayout(new BoxLayout(lengthGroup, BoxLayout.Y_AXIS));
      JRadioButton days = new JRadioButton();
      days.setText("days");
      JRadioButton weeks = new JRadioButton();
      weeks.setText("weeks");
      JRadioButton months = new JRadioButton();
      months.setText("months");
      lengthGroup.add(days);
      lengthGroup.add(weeks);
      lengthGroup.add(months);
      
      // adding the length of the dosage to the dosage panel
      dosagePanel.add(lengthGroup);

      // adding the dosage to the precribe panel
      prescribePanel.add(dosagePanel);
      
      // creating the panel for the notes to pharmacist and submit button
      JPanel notesAndSubmit = new JPanel();
      notesAndSubmit.setBorder(BorderFactory.createTitledBorder("Notes to Pharmacist"));
      notesAndSubmit.setLayout(new GridLayout(1, 2));
      
      // creating the notes section
      JPanel notes = new JPanel();
      notes.setLayout(new GridLayout(1, 1));
      
      // creating the notes entered text area
      JTextArea notesEntered = new JTextArea(4, 10);
      notesEntered.setText("");
      notesEntered.setEditable(true);
      notesEntered.setLineWrap(true);
      JScrollPane scroll = new JScrollPane(notesEntered);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      notes.add(scroll);
      
      // adding the notes to the notes and submit section
      notesAndSubmit.add(notes);
      
      // creating a panel for the submit button
      JPanel submitPanel = new JPanel();
      submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.LINE_AXIS));
      submitPanel.add(new JPanel());
      submitPanel.add(new JButton("Print Prescription"));
      submitPanel.add(new JPanel());
      
      // adding the submit panel to the notes and submit panel
      notesAndSubmit.add(submitPanel);
      
      // adding notes and submit to the main prescribe panel
      prescribePanel.add(notesAndSubmit);

      // adding the created panel to the conatiner that was passed to the method
      pane.add(prescribePanel);
   }

   public void createAndShowProviderPrescribeView() {
      // creating the frame for the screen
      JFrame frame = new JFrame("Provider Prescribe");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(750, 500));

      // creating the panes within the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientPrescribePanel(frame.getContentPane());

      // allowing the contents of the screen to be seen
      frame.pack();
      frame.setVisible(true);
   }
}
