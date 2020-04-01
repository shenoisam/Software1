package frontend.staff;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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

import frontend.LoginScreen;
import frontend.patient.GenericScreen;
import frontend.patient.PatientHome;
import frontend.patient.PatientIntake;
import frontend.patient.PatientViewTest;
import frontend.patient.ProviderView;

public class Runner {
	private JFrame frame; 
	public Runner(JFrame frame){
		this.frame = frame;
		
		
	}
	
 

	private static void checkPasswordValidity(String password) {
    	
    }
	public void displayFrameOpt(StaffEnum opt) {

	   frame.getContentPane().removeAll();
	   frame.revalidate();
	   frame.repaint();
	   
	   GenericStaffScreen g = null; 
	   

	   switch(opt) {
	      case HOME: g = new HomeScreen(this); frame.setTitle("EHR Staff Home Screen"); break; 
	      case BILLING: g = new BillingScreen(this); frame.setTitle("EHR Staff Billing Screen"); break; 
	      case SCHEDULE: g = new ScheduleScreen(this);frame.setTitle("EHR Staff Scheduling Screen"); break;
	      default: g = new HomeScreen(this); frame.setTitle("EHR Staff Home Screen"); break; 
	   }
	   g.createAndShowGUI(frame.getContentPane());

	   frame.pack();
	   frame.revalidate();
	   frame.repaint();
	   frame.setVisible(true);

	
	}
	

}
