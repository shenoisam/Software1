package frontend.provider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.classes.Patient;
import businesslayer.ProviderService;
import frontend.GenericEnum;

public class ProviderFrontend implements IProviderFrontend{
	static ProviderRunner p; 
	protected static ProviderService serv;
	public ProviderFrontend(ProviderRunner p) {
		this.p = p; 
		serv = new ProviderService(); 
		// TODO Auto-generated constructor stub
	}
	protected static void providerSideBar(Container pane) {
	      // creating the whole side panel
	      JPanel sidePanel = new JPanel();
	      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
	      sidePanel.setBorder(BorderFactory.createTitledBorder(""));
	      
	      // creating the button panel to organize the location of the buttons
	      JPanel buttonPanel = new JPanel();
	      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	      JButton button = new JButton("Patient Overview");
	      button.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	 
	    	    p.displayFrameOpt(GenericEnum.POVERVIEW);
	    	  } 
	      } );
	      buttonPanel.add(button);
	      button = new JButton("Patient Visit");
	      button.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	 
	    	    p.displayFrameOpt(GenericEnum.PVISIT);
	    	  } 
	      } );
	      buttonPanel.add(button);
	      button = new JButton("Prescribe");
	      button.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	 
	    	    p.displayFrameOpt(GenericEnum.PPRESCRIBE);
	    	  } 
	      } );
	      buttonPanel.add(button);
	      button = new JButton("Request a Test");
	      button.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	 
	    	    p.displayFrameOpt(GenericEnum.PTESTREQUEST);
	    	  } 
	      } );
	      buttonPanel.add(button);
	      button = new JButton("View Test Results");
	      button.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    	    p.displayFrameOpt(GenericEnum.PTESTREQUEST);
	    	  } 
	      } );
	      
	      buttonPanel.add(button);
	      button = new JButton("Referrals");
	      button.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    	    p.displayFrameOpt(GenericEnum.PREFERRAL);
	    	  } 
	      } );
	      buttonPanel.add(button);
	      sidePanel.add(buttonPanel);
	      
	      // adding the side panel to the layout
	      pane.add(sidePanel, BorderLayout.WEST);
	   }
	
	protected static void topBarMenuItems(JPanel buttonPanel) {
		JButton button = new JButton("Home");
   
        //Add ActionListener 
        button.addActionListener(new ActionListener() { 
    	  public void actionPerformed(ActionEvent e) { 
    		System.out.println("Display Home");
    	    p.displayFrameOpt(GenericEnum.HOME);
    	  } 
    	 } );
      
      
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(button, BorderLayout.WEST);
      
      
        button = new JButton("Logout");
        button.addActionListener(new ActionListener() { 
      	  public void actionPerformed(ActionEvent e) { 
      		System.out.println("Display Home");
      	    p.logout();
      	  } 
      	 } );
        buttonPanel.add(button, BorderLayout.EAST);
		
	}
	protected static void topBarPatientInformation(Container pane) {
	      // creating the top panel to store all the information
	      JPanel topPanel = new JPanel();
	      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

	      // creating the buttonPanel with the Home and Logout buttons
	      JPanel buttonPanel = new JPanel();
	      topBarMenuItems(buttonPanel);
	      
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

	public void createAndShowGUI(JFrame frame) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createAndShowGUI(JFrame frame, Patient pat) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
