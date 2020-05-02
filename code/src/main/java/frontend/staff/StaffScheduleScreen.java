package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
      // creating the drop down menu
      JComboBox<String> patients = new JComboBox<String>();
      patients.addItem("DUMMY");
      patients.addItem("DUMMY");
      patients.addItem("DUMMY");
      patients.addItem("DUMMY");

      patientName.add(patients);

      makingApptPanel.add(patientName);

      // creating a drop down menu for providers names
      JPanel providerName = new JPanel();
      providerName.setBorder(BorderFactory.createTitledBorder("Provider's Name"));

      // creating drop down menu for providers name
      /**
       * TODO NEED TO ADD DATA TO THE THING TO GET THE REAL providers FROM THE
       * DATABASE
       */
      JComboBox<String> providers = new JComboBox<String>();
      providers.addItem("DUMMY");
      providers.addItem("DUMMY");
      providers.addItem("DUMMY");
      providers.addItem("DUMMY");

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
      JComboBox<String> datesAndTimes = new JComboBox<String>();
      datesAndTimes.addItem("DUMMY");
      datesAndTimes.addItem("DUMMY");
      datesAndTimes.addItem("DUMMY");
      datesAndTimes.addItem("DUMMY");

      date.add(datesAndTimes);

      makingApptPanel.add(date);

      JButton name = new JButton("Schedule");

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

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      showSchedule(pane);
      staffSideBar(pane);
   }

}
