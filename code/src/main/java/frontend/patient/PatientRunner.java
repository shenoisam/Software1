package frontend.patient;

import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;

public class PatientRunner extends GenericRunner{
	
	public PatientRunner(EHRRunner r){
		super(r);
	}
	public void displayFrameOpt(GenericEnum opt) {
		   //Remove everything from the frame
		   frame.getContentPane().removeAll();
		   frame.revalidate();
		   frame.repaint();
		   
		   PatientGenericScreen g = null; 
		   

		   switch(opt) {
		      case HOME: g = new PatientHome(frame, this); break; 
		      case INTAKE: g = new PatientIntake(frame,this); break; 
		      case VIEWTABLE: g = new PatientViewTest(frame,this); break; 
		      
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
		  
		  this.r.logout();
	}
	
	
	
}
