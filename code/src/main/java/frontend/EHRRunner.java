package frontend;

import java.awt.Dimension;

import javax.swing.JFrame;

import frontend.patient.PatientRunner;
import frontend.patient.PatientScreenEnum;
import frontend.provider.ProviderRunner;
import frontend.provider.ProviderScreen;
import frontend.staff.Runner;
import frontend.staff.StaffEnum;

import backend.*;
import cshare.User;

public class EHRRunner {
	private Runner r; 
	private PatientRunner p; 
	private ProviderRunner v; 
	
	private JFrame frame; 
	
	EHRRunner(){
		
	    
	    frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,650));
		frame.setBounds(240,100,1000,650);
		
		r = new Runner(frame); 
	    p = new PatientRunner(frame);
	    v = new ProviderRunner(frame); 
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void validateUser(String user,String pass) {
	
		 
		 // Display the home screen depending on the user
		 User u = null; 
		 
		
		 System.out.println(user + "|");
		  
		 // For now we will just use test data
		 /*
		  * Display the correct screen. 
		  * 
		  * TODO: some fancy polymorphism stuff. probs will have to create some new classes and stuff
		  * idk hacky way for now. 
		  */
		 TestData d = new TestData(); 
		 
		 int z = d.randomGetter(); 
		 
		 switch (z) {
		 case 0: v.displayFrameOpt(ProviderScreen.HOME);break; 
		 case 1: r.displayFrameOpt(StaffEnum.HOME); break; 
		 case 2: p.displayFrameOpt(PatientScreenEnum.HOME);break; 
		 default:  p.displayFrameOpt(PatientScreenEnum.HOME);
		 }
		 
		 //For some reason getting address instead of value, fix later
		 /*if (user.equals("doctor")) {
			 System.out.println("HERE");
			 u = d.getDoctor(); 
			 v.displayFrameOpt(ProviderScreen.HOME);
		 }else if (user.equals("staff")) {
			 u = d.getStaff(); 
			 r.displayFrameOpt(StaffEnum.HOME);
		 }else {
			 u = d.getPatient(); 
			 p.displayFrameOpt(PatientScreenEnum.HOME);
		 }*/
		 
		 
		
	}
	
	public void displayLogin() {
		LoginScreen s = new LoginScreen(this); 
		
		s.createAndShowGUI(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EHRRunner r = new EHRRunner(); 
				r.displayLogin();
			    
			    
			}
		});

	}
	
	

}
