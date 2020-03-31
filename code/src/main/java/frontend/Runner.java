package frontend;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Runner {
	private static void topBarProviderHomescreen(Container pane) {
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
    public static void buttonAdder(Container pane) {
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
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.add(new JButton("Hello"));
				frame.getContentPane().doLayout();
				frame.update(frame.getGraphics());
			}
        	
        });
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
    	

    static JFrame frame;
	private static void createAndShowGUI1() {
		/*JFrame*/ frame = new JFrame("EHR Staff Homescreen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(500, 500);
		frame.setPreferredSize(new Dimension(800, 500));
	}
		// Can't figure this out yet...

    private static void staffHomeScreen(Container pane) {
    	JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		OfficeSchedule table = new OfficeSchedule();
		table.setOpaque(true);
		
		middleOfScreen.add(table);
		
		//middleOfScreen.add(aboutPatient);
		
		pane.add(middleOfScreen);
		
		buttonAdder(pane);
    }
    private static void staffBillingScreen(Container pane) {
    	
    	// Can't figure this out yet...

		/*JTextArea StaffName = new JTextArea();
		StaffName.setText("Staff Name Here");
		frame.getContentPane().add(StaffName, BorderLayout.CENTER);*/

    	JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		TableWrap table = new TableWrap();
		table.setOpaque(true);
		
		JTextArea aboutPatient = new JTextArea();
		aboutPatient.setText("About the patient");
		
		middleOfScreen.add(table);
		
		middleOfScreen.add(aboutPatient);
		
		pane.add(middleOfScreen);
		
		buttonAdder(pane);
    }
    private static void staffSchedulingScreen(Container pane) {
    	JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		ProvidersSchedule table = new ProvidersSchedule();
		table.setOpaque(true);
		
		JPanel aboutPatient = new JPanel();
		
		aboutPatient.setLayout(new BoxLayout(aboutPatient, BoxLayout.X_AXIS));
		
		JButton name = new JButton("Patient Name");
		
		aboutPatient.add(name);
		
		name = new JButton("Provider's Name");
		
		aboutPatient.add(name);
		
		JPanel aboutPatient2 = new JPanel();
		
		middleOfScreen.add(aboutPatient);
		
		
		aboutPatient2.setLayout(new BoxLayout(aboutPatient2, BoxLayout.X_AXIS));
	      
		//aboutPatient2.setLayout(new BoxLayout(aboutPatient2, BoxLayout.X_AXIS));
		
		name = new JButton("Select Date");
		
		aboutPatient2.add(name);
		
		name = new JButton("Schedule Appointment");
		
		aboutPatient2.add(name);
		
		middleOfScreen.add(aboutPatient2);
		
		middleOfScreen.add(table);
		
		
		
		pane.add(middleOfScreen);
		
		buttonAdder(pane);
    }
    private static void loginScreen(Container pane) {
    	JPanel login = new JPanel();
    	
    	JPasswordField username = new JPasswordField();
    	username = new JPasswordField(10);
    	username.setActionCommand("ok");
    	//password.addActionListener(this);
 
        JLabel labelUser = new JLabel("Enter the Username: ");
        labelUser.setLabelFor(username);
        JPanel textPaneUser = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPaneUser.add(labelUser);
        textPaneUser.add(username);
        login.add(textPaneUser);
    	login.add(username);
		//login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
    	JPasswordField password = new JPasswordField();
    	password = new JPasswordField(10);
    	password.setActionCommand("ok");
    	//password.addActionListener(this);
 
        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(password);
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(password);
        login.add(textPane);
    	login.add(password);
		JButton submitButton = new JButton("Submit");
		login.add(submitButton);
		pane.add(login);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//char[] inputPassword = password.getPassword();
				//pane.invalidate();
				//pane.validate();
				//pane.repaint();
			}
		});
    }
    private static void checkPasswordValidity(String password) {
    	
    }
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,650));
		frame.setBounds(240,100,1000,650);
		
		//loginScreen(frame.getContentPane());
		//String tempPass = "cerny";
		
		//staffHomeScreen(frame.getContentPane());
		//frame.setTitle("EHR Staff Home Screen");
		
		//staffBillingScreen(frame.getContentPane());
		//frame.setTitle("EHR Staff Billing Screen");
		
		staffSchedulingScreen(frame.getContentPane());
		frame.setTitle("EHR Staff Scheduling Screen");
		
		
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI1();
			}
		});

	}

}
