package frontend.provider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import backend.classes.Appointment;
import backend.classes.Diagnosis;
import backend.classes.Patient;
import backend.classes.PatientDiagnosis;
import backend.dao.PatientDAO;
import businesslayer.CShareObjects;
import frontend.GenericEnum;

public class PatientLookUpScreen extends ProviderFrontend {
	
	public PatientLookUpScreen(ProviderRunner p){
		super(p);
	}
	
	public void setMainPanel(Container pane) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		
		JPanel searchPanel = new JPanel();
		SpringLayout sl = new SpringLayout();
		searchPanel.setLayout(sl);
		
		final List<Patient> pList = new PatientDAO().getData(new String[] {}, new String[] {});
		List<String> names = new ArrayList<String>();
		
		pList.stream().forEach(p -> names.add(p.getFullName()));
		
		StringSearchable searchable = new StringSearchable(names);
	    AutocompleteJComboBox comboBox = new AutocompleteJComboBox(searchable);
	    
	    JButton searchButton = new JButton("Select");
	    
	    searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = (String) comboBox.getSelectedItem();
				Patient patient;
				
				for(Patient p : pList) {
					if(p.getFullName().equals(name)) {
						patient = p;
						
						break;
					}
				}
				
			}
	    	
	    });
	    
	    sl.putConstraint(SpringLayout.NORTH, searchButton, 5, SpringLayout.NORTH, searchPanel);
	    sl.putConstraint(SpringLayout.WEST, searchButton, 5, SpringLayout.WEST, searchPanel);
	    
	    sl.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.NORTH, searchPanel);
	    sl.putConstraint(SpringLayout.WEST, comboBox, 5, SpringLayout.EAST, searchButton);
	    sl.putConstraint(SpringLayout.EAST, searchPanel, 5, SpringLayout.EAST, comboBox);
	    
	    searchPanel.add(searchButton);
		searchPanel.add(comboBox);
		
		panel.add(searchPanel);
		
		
		pane.add(panel);		
		
	}


	   private static void sideBarWithCalander(Container pane) {
	      // creating the whole side panel
	      JPanel sidePanel = new JPanel();
	      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
	      sidePanel.setBorder(BorderFactory.createTitledBorder(""));
	      
	      // creating the button panel to organize the location of the buttons
	      JPanel buttonPanel = new JPanel();
	      buttonPanel.setLayout(new GridLayout(3, 1));
	      buttonPanel.setMaximumSize(new Dimension(600, 400));

	      JButton button = new JButton("Today's Schedule");
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            p.displayFrameOpt(GenericEnum.HOME);
	         }
	      });
	      buttonPanel.add(button);

	      button = new JButton("This one is used just blank");
	      button.setVisible(false);
	      buttonPanel.add(button);
	      sidePanel.add(buttonPanel);

	      // creating and adding an invisible pane to push down the calander
	      sidePanel.add(new JPanel());

	      // creating the calendar
	      JPanel cPanel = new JPanel();
	      cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
	      JPanel calander = new Calendar().makeCalander();
	      cPanel.add(calander);

	      // adding the calendar panel to the side panel
	      sidePanel.add(cPanel);

	      // adding the side panel to the layout
	      pane.add(sidePanel, BorderLayout.WEST);
	   }

	   private static void topBarProviderHomescreen(Container pane) {
	      // creating the top panel to store all the information
	      JPanel topPanel = new JPanel();
	      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

	      // creating the buttonPanel with the Home and Logout buttons
	      JPanel buttonPanel = new JPanel();
	      topBarMenuItems(buttonPanel);
	      topPanel.add(buttonPanel);

	      // creating the panel with the provider's name
	      JPanel namePanel = new JPanel();
	      namePanel.setBorder(BorderFactory.createTitledBorder(""));
	      namePanel.setPreferredSize(new Dimension(500, 50));
	      namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
	      JLabel welcome = new JLabel("Welcome, ");
	      welcome.setFont(welcome.getFont().deriveFont(25f));
	      namePanel.add(welcome);
	      JLabel staffName = new JLabel();
	      staffName.setText(p.getUser().getFullName());
	      staffName.setFont(staffName.getFont().deriveFont(25f));
	      namePanel.add(staffName);

	      // creating and adding an invisible panel to push out the appointment times
	      JPanel invisible = new JPanel();
	      namePanel.add(invisible);

	      // creating the appointment time and location
	      JLabel nextAppointmentTitle = new JLabel();
	      nextAppointmentTitle.setText("Your Next Appointment is at: ");
	      JLabel appointmentTime = new JLabel();
	      LocalDateTime date = LocalDateTime.now();
	      String[] params = { date.toString() };
	      String[] fields = { "DateVal" };
	     
	      List<Appointment> li = serv.getData(CShareObjects.APPOINTMENT, fields, params);
	      if (li.size() > 0) {
	    	  appointmentTime.setText(li.get(0).getAppointmentDate().toString());
	      }else {
	    	  appointmentTime.setText("");
	      }
	     

	      // adding the time and location to the name panel
	      namePanel.add(nextAppointmentTitle);
	      namePanel.add(appointmentTime);
	      // namePanel.add(appointmentLocation);

	      // adding the name panel to 4the main panel
	      topPanel.add(namePanel);

	      // adding the top Panel to the container that was passed in to the function
	      pane.add(topPanel, BorderLayout.NORTH);
	   }

	public void createAndShowGUI(JFrame frame) {
	      // creating the frame for the screen
	      /*
	       * JFrame frame = new JFrame("Home");
	       * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       * frame.setPreferredSize(new Dimension(750, 500));
	       */

	      // creating the panes within the screen
	      topBarProviderHomescreen(frame.getContentPane());
	      sideBarWithCalander(frame.getContentPane());
	      setMainPanel(frame.getContentPane());
	      
	      // allowing the contents of the screen to be seen
	      // frame.pack();
	      // frame.setVisible(true);
	   }

	   public void createAndShowGUI(JFrame frame, Patient pat) {

	      createAndShowGUI(frame);
	   }
	
	
}
