package frontend;

import java.awt.Dimension;
import javax.swing.JFrame;
import frontend.patient.PatientRunner;
import frontend.provider.ProviderRunner;
import frontend.staff.Runner;


import backend.*;
import backend.classes.User;
import backend.dao.UserDAO;

public class EHRRunner {
	private GenericRunner r; 
	protected JFrame frame; 
	
	EHRRunner(){
		
	    
	    frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,650));
		frame.setBounds(240,100,1000,650);
		
		r = null; 
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	

	public void setR(GenericRunner w) {
		r = w; 
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

		 UserDAO d = new UserDAO();
		 
		 u = d.LogInUser(user, pass);
		 if (u !=null) {
			 this.r = u.accept(this);
			 
			 r.displayFrameOpt(GenericEnum.HOME);
			 
		 }else {
			 System.out.println("User not found");
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
	public void logout() {
		  //Wherever we are, remove it all 
		  frame.getContentPane().removeAll();
		  frame.revalidate();
		  frame.repaint();
		  
		  //Create a log in screen
		  this.displayLogin(); 
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
