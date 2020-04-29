package frontend.staff;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frontend.GenericEnum;

public class GenericStaffScreen implements IGenericStaff {
	static Runner r; 
	GenericStaffScreen(Runner r){
		this.r = r; 
	}
	protected static void topBarProviderHomescreen(Container pane) {
	      // creating the top panel to store all the information
	      JPanel topPanel = new JPanel();
	      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
	      
	      // creating the buttonPanel with the Home and Logout buttons
	      JPanel buttonPanel = new JPanel();
	      JButton button = new JButton("Home");
	      
	      buttonPanel.setLayout(new BorderLayout());
	      buttonPanel.add(button, BorderLayout.WEST);
	      button = new JButton("Logout");
	      button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					//Modified so that it calls the calling class to switch the screen. 
					//Allows for one method to be used to switch the screens - Sam 
					r.logout();
					
				}
				
			});
	      buttonPanel.add(button, BorderLayout.EAST);
	      topPanel.add(buttonPanel);
	      
	      // creating the panel with the staff's name
	      JPanel namePanel = new JPanel();
	      namePanel.setBorder(BorderFactory.createTitledBorder(""));
	      namePanel.setPreferredSize(new Dimension(500, 50));
	      namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
	      JLabel welcome = new JLabel("Welcome, ");
	      namePanel.add(welcome);
	      JLabel staffName = new JLabel();
	      staffName.setText("Staff");
	      namePanel.add(staffName);
	      
	      // creating and adding an invisible panel to push out the appointment times
	      JPanel invisible = new JPanel();
	      namePanel.add(invisible);
	      
	      // creating the apointment time and location
	      JLabel nextAppointmentTitle  = new JLabel();
	      nextAppointmentTitle.setText("Your Next Appointment is at: ");
	      JLabel appointmentTime = new JLabel();
	      appointmentTime.setText("MM-DD-YY HH:mm ");
	      JLabel appointmentLocation = new JLabel();
	      appointmentLocation.setText("Room 123");
	      
	      // adding the time and location to the name panel
	      namePanel.add(nextAppointmentTitle);
	      namePanel.add(appointmentTime);
	      namePanel.add(appointmentLocation);
	      
	      // adding the name panel to the main panel
	      topPanel.add(namePanel);
	      
	      // adding the top Panel to the contianer that was passed in to the function
	      pane.add(topPanel, BorderLayout.NORTH);
	 }
	protected static void buttonAdder(Container pane) {
    	JPanel panel = new JPanel(); 
    	 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        
        JPanel topPanel = new JPanel();
  
        JButton button = new JButton("Home");
        
        /*topPanel.add(button);
        
        button = new JButton("Logout");
        
        topPanel.add(button);*/
        topBarProviderHomescreen(pane);
        
       // pane.add(topPanel, BorderLayout.PAGE_START);
         
        button = new JButton("Manage Billing");
        panel.add(button);
        
        button = new JButton("Scheduling");
        panel.add(button);
        
        button = new JButton("View Patient Records");
        panel.add(button);
        
     // creating the calander
        JPanel cPanel = new JPanel();
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
        JPanel calander = new Calendar().makeCalander(); 
        cPanel.add(calander);
        
        panel.add(cPanel);
        
        pane.add(panel, BorderLayout.WEST);
 
    }

	public void createAndShowGUI(Container pane) {
		// TODO Auto-generated method stub
		
	}


}
