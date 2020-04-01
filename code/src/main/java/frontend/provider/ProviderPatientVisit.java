/*
 * This class is used to implement the Provider Patient Visit veiw
 * Call createAndShowProviderPatientVisit() to generate the GUI
 */
package frontend.provider;

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

public class ProviderPatientVisit extends ProviderFrontend {


   
   public ProviderPatientVisit(ProviderRunner p) {
		super(p);
		// TODO Auto-generated constructor stub
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

   public void createAndShowGUI(JFrame frame) {
      // Add the relavent panels to the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientVisitPanel(frame.getContentPane());

 
   }
}
