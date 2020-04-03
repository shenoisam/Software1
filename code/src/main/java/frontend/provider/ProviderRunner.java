package frontend.provider;

import java.awt.Dimension;

import javax.swing.JFrame;

import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;

public class ProviderRunner extends GenericRunner{

	
   
   public ProviderRunner(EHRRunner r){
	   super(r);
	  

	}
   
   public void displayFrameOpt(GenericEnum opt) {
	   
	   //Remove everything from the frame
	   frame.getContentPane().removeAll();
	   frame.revalidate();
	   frame.repaint();
	   
	   ProviderFrontend p = null; 
	   

	   switch(opt) {
	      case HOME:  p = new ProviderHomescreen(this); break; 
	      case POVERVIEW : p = new ProviderPatientOverview(this); break;
	      case PVISIT: p = new ProviderPatientVisit(this); break; 
	      case PPRESCRIBE: p = new ProviderPrescribeView(this); break; 
	      case PTESTREQUEST: p = new ProviderRequestTestView(this); break; 
	      case PREFERRAL : p = new ProviderReferralsView(this);break; 
	      default: System.out.println("DEFAULTING"); p = new ProviderHomescreen(this); 
	   }
	   p.createAndShowGUI(this.frame);
	   frame.pack();
	   frame.revalidate();
	   frame.repaint();
	   frame.setVisible(true);
	   
	
   }

   
}
