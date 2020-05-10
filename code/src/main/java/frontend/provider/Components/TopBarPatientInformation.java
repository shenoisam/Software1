package frontend.provider.Components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.classes.Patient;
import frontend.provider.ProviderRunner;

public class TopBarPatientInformation {
	public static JPanel getTopBar(ProviderRunner run,Patient p) {
		// creating the top panel to store all the information
	      JPanel topPanel = new JPanel();
	      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

	      // creating the buttonPanel with the Home and Logout buttons
	      JPanel buttonPanel = TopBarMenuItems.addMenuItems(run);

	      topPanel.add(buttonPanel);

	      // creating the panel with the patient's Name
	      JPanel patientPanel = new JPanel();
	      patientPanel.setBorder(BorderFactory.createTitledBorder(""));
	      patientPanel.setPreferredSize(new Dimension(500, 50));
	      patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.X_AXIS));

	      // displaying the patient's name
	      JLabel patientName = new JLabel(p.getFullName());
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
	      JLabel patientGender = new JLabel("" + p.getGender());
	      patientGender.setAlignmentX(Component.CENTER_ALIGNMENT);
	      gender.add(patientGender);
	      patientInformation.add(gender);

	      // displaying the patient's date of birth
	      JPanel dateOfBirth = new JPanel();
	      dateOfBirth.setLayout(new BoxLayout(dateOfBirth, BoxLayout.Y_AXIS));
	      JLabel dateOfBirthTitle = new JLabel("DOB");
	      dateOfBirthTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
	      dateOfBirth.add(dateOfBirthTitle);
	      JLabel patientDateOfBirth;
	      try {
	         patientDateOfBirth = new JLabel(p.getDOB().toLocaleString());
	      } catch (NullPointerException e) {
	         // If we don't know what the patients DOB is we need to ask
	         patientDateOfBirth = new JLabel("-");
	      }
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
	      
	      return topPanel;

	}

}
