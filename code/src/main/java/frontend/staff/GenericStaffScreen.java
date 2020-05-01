package frontend.staff;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.classes.Staff;
import backend.dao.StaffDAO;
import businesslayer.ProviderService;
import frontend.GenericEnum;

public class GenericStaffScreen implements IGenericStaff {
	/**
	 * Defines a Staff Screen interface
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	static StaffRunner r; 
	static ProviderService serv; 
	GenericStaffScreen(StaffRunner r){
		serv = new ProviderService();
		this.r = r; 
		
	}
	/** 
		 * gets appointments based solely on fields in Appointment table (Date, DoctorID, PatientID) 
		 * does not perform any joining with the user table or any other table. 
		 * 
		 * @param buttonPanel the panel the menu items will be attached to
		 */
   protected static void topBarMenuItems(JPanel buttonPanel) {
      JButton button = new JButton("Home");

      // Add ActionListener
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            r.displayFrameOpt(GenericEnum.HOME);
         }
      });

      buttonPanel.setLayout(new BorderLayout());
      buttonPanel.add(button, BorderLayout.WEST);

      button = new JButton("Logout");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            r.logout();
         }
      });
      buttonPanel.add(button, BorderLayout.EAST);
   }

   /** 
	 * creates the top bar of the staff menu
	 * 
	 * @param pane the Container the top bar of staff will be attached to
	 */
   protected static void topBarStaff(Container pane) {
      // creating the top panel to store all the information
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

      // creating the buttonPanel with the Home and Logout buttons
      JPanel buttonPanel = new JPanel();
      JButton button = new JButton("Home");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            r.displayFrameOpt(GenericEnum.HOME);
         }
      });

      buttonPanel.setLayout(new BorderLayout());
      buttonPanel.add(button, BorderLayout.WEST);
      button = new JButton("Logout");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // Modified so that it calls the calling class to switch the screen.
            // Allows for one method to be used to switch the screens - Sam
            r.logout();
         }

      });
      buttonPanel.add(button, BorderLayout.EAST);
      topPanel.add(buttonPanel);

      // creating the panel with the staff's name
      JPanel namePanel = new JPanel();
      namePanel.setBorder(BorderFactory.createTitledBorder(""));
      namePanel.setPreferredSize(new Dimension(500, 50));
      namePanel.setLayout(new GridLayout(1,3));
      
      // specific panel with Staff name
      JPanel labelPanel = new JPanel();
      JLabel welcome = new JLabel("Welcome, ");
      welcome.setFont(welcome.getFont().deriveFont(25f));
      labelPanel.add(welcome);
      JLabel staffName = new JLabel();
      
      System.out.println(r.getUser().getFirstName());
      
      staffName.setText(r.getUser().getFirstName());
      staffName.setFont(staffName.getFont().deriveFont(23f));
      labelPanel.add(staffName);
      namePanel.add(labelPanel);
      
      // adding panels for formating purposes
      namePanel.add(new JPanel());
      namePanel.add(new JPanel());
      namePanel.add(new JPanel());
      namePanel.add(new JPanel());
      
      // adding the name panel to the main panel
      topPanel.add(namePanel);

      // adding the top Panel to the contianer that was passed in to the function
      pane.add(topPanel, BorderLayout.NORTH);
   }

   /** 
	 * creates side bar of staff view
	 * 
	 * @param pane the Container that the staff bar will be attached to
	 */
   protected static void staffSideBar(Container pane) {
      // creating the whole side panel
      JPanel sidePanel = new JPanel();
      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
      sidePanel.setBorder(BorderFactory.createTitledBorder(""));

      // creating the button panel to organize the location of the buttons
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(3, 1));      
      JButton button = new JButton("Manage Billing");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            r.displayFrameOpt(GenericEnum.BILLING);
         }
      });
      buttonPanel.add(button);

      button = new JButton("Scheduling");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            r.displayFrameOpt(GenericEnum.SCHEDULE);
         }
      });
      buttonPanel.add(button);

      button = new JButton("View Patient Records");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            r.displayFrameOpt(GenericEnum.PARAMS);
         }
      });
      buttonPanel.add(button);
      
      sidePanel.add(buttonPanel);
      
      sidePanel.add(new JPanel());

      // creating the calander
      JPanel cPanel = new JPanel();
      cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
      JPanel calander = new Calendar().makeCalander();
      cPanel.add(calander);

      sidePanel.add(cPanel);

      pane.add(sidePanel, BorderLayout.WEST);

   }
   
   /** 
	 * implemented method, not used
	 */
   public void createAndShowGUI(Container pane) {
      // TODO Auto-generated method stub

   }

}
