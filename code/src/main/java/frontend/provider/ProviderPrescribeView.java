package frontend.provider;

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

public class ProviderPrescribeView extends ProviderFrontend{
 
   public ProviderPrescribeView(ProviderRunner p) {
		super(p);
		// TODO Auto-generated constructor stub
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

   public void createAndShowGUI(JFrame frame) {
      // creating the panes within the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientPrescribePanel(frame.getContentPane());

     
   }
}
