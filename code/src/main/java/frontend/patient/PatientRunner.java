package frontend.patient;

import java.awt.Dimension;


import javax.swing.JFrame;

import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;
import frontend.provider.ProviderFrontend;
import frontend.provider.ProviderHomescreen;
import frontend.provider.ProviderPatientOverview;
import frontend.provider.ProviderPatientVisit;
import frontend.provider.ProviderPrescribeView;
import frontend.provider.ProviderReferralsView;
import frontend.provider.ProviderRequestTestView;
import frontend.provider.ProviderRunner;

public class PatientRunner extends GenericRunner{
	
	public PatientRunner(EHRRunner r){
		super(r);
	}
	public void displayFrameOpt(GenericEnum opt) {
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
	public void logout() {
		  frame.getContentPane().removeAll();
		  frame.revalidate();
		  frame.repaint();
	}
	
	
	
}
