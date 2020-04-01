package frontend.patient;

import java.awt.Dimension;

import javax.swing.JFrame;

import frontend.provider.ProviderFrontend;
import frontend.provider.ProviderHomescreen;
import frontend.provider.ProviderPatientOverview;
import frontend.provider.ProviderPatientVisit;
import frontend.provider.ProviderPrescribeView;
import frontend.provider.ProviderReferralsView;
import frontend.provider.ProviderRequestTestView;
import frontend.provider.ProviderRunner;
import frontend.provider.ProviderScreen;

public class PatientRunner {
	JFrame frame; 
	
	public PatientRunner(JFrame frame){
		this.frame = frame;
		
		
	}
	public void displayFrameOpt(PatientScreenEnum opt) {
		   //Remove everything from the frame
		   frame.getContentPane().removeAll();
		   frame.revalidate();
		   frame.repaint();
		   
		   GenericScreen g = null; 
		   

		   switch(opt) {
		      case HOME: g = new PatientHome(frame, this); break; 
		      case INTAKE: g = new PatientIntake(frame,this); break; 
		      case VIEWTABLE: g = new PatientViewTest(frame,this); break; 
		      case PROVIDERVIEW: g = new ProviderView(frame, this); break; 
		      
		      default: break; 
		   }
	
		   frame.pack();
		   frame.revalidate();
		   frame.repaint();
		   frame.setVisible(true);
		   
		   
		
	}
	
	
	
}
