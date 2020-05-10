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
import frontend.provider.Components.SideBarWithCalendar;
import frontend.provider.Components.TopBarProviderHomescreen;

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
		
		for(Patient z : pList) {
			names.add(z.getFullName());
		}
		
		
		StringSearchable searchable = new StringSearchable(names);
	    final AutocompleteJComboBox comboBox = new AutocompleteJComboBox(searchable);
	    
	    JButton searchButton = new JButton("Select");
	    
	    searchButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ndx =  comboBox.getSelectedIndex();
				Patient patient = pList.get(ndx);
				p.displayFrameOpt(GenericEnum.POVERVIEW,patient);
				
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


	   
	public void createAndShowGUI(JFrame frame) {
	      // creating the frame for the screen
	      /*
	       * JFrame frame = new JFrame("Home");
	       * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       * frame.setPreferredSize(new Dimension(750, 500));
	       */

	      // creating the panes within the screen
		  
		  TopBarProviderHomescreen.addTopBar(frame.getContentPane(), p,null);
	      SideBarWithCalendar.addSideBar(frame.getContentPane(), p);
	      setMainPanel(frame.getContentPane());
	      
	      // allowing the contents of the screen to be seen
	      // frame.pack();
	      // frame.setVisible(true);
	   }

	   public void createAndShowGUI(JFrame frame, Patient pat) {

	      createAndShowGUI(frame);
	   }
	
	
}
