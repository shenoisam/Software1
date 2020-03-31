package providerfrontend;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ProviderRunner {
   private JFrame frame;  
	
   
   public ProviderRunner() {
	   frame = new JFrame("Patient Visit");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setPreferredSize(new Dimension(750, 500));
	   
   }
   
   public void displayFrameOpt(ProviderScreen opt) {
	   System.out.println("Displaying Opt" + opt);
	   //Remove everything from the frame
	   frame.getContentPane().removeAll();
	   
	   ProviderFrontend p = null; 
	   
	   frame.setVisible(false);
	   
	   //Hacky way of changing the frame
	   switch(opt) {
	      case HOME:  p = new ProviderHomescreen(this); break; 
	      case POVERVIEW : p = new ProviderPatientOverview(this); break;
	      case PVISIT: p = new ProviderPatientVisit(this);
	      case PPRESCRIBE: p = new ProviderPrescribeView(this);
	      case PTESTREQUEST: p = new ProviderRequestTestView(this);
	      case PREFERRAL : p = new ProviderReferralsView(this);
	      default: p = new ProviderHomescreen(this); 
	   }
	   p.createAndShowGUI(this.frame);
	   frame.pack();
	   frame.setVisible(true);
	
   }

   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	ProviderRunner run = new ProviderRunner(); 
        	 run.displayFrameOpt(ProviderScreen.PVISIT);
       
        	  
        	
        }
      });

    }
}
