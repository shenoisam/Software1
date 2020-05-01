package frontend.provider;

import backend.classes.Patient;
import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;

public class ProviderRunner extends GenericRunner {

   public ProviderRunner(EHRRunner r) {
      super(r);
   }

   public void displayFrameOpt(GenericEnum opt) {

      // Remove everything from the frame
      frame.getContentPane().removeAll();
      frame.revalidate();
      frame.repaint();

      ProviderFrontend p = null;

      switch (opt) {
      case HOME:
         p = new ProviderHomescreen(this);
         break;
      case POVERVIEW:
         p = new ProviderPatientOverview(this);
         break;
      case PVISIT:
         p = new ProviderPatientVisit(this);
         break;
      case PPRESCRIBE:
         p = new ProviderPrescribeView(this);
         break;
      case PTESTREQUEST:
         p = new ProviderRequestTestView(this);
         break;
      case PVIEWTEST:
         p = new ProviderViewTest(this);
         break;
      case PREFERRAL:
         p = new ProviderReferralsView(this);
         break;
      case LOOKUP:
    	  p = new PatientLookUpScreen(this); break;
      default:
         System.out.println("DEFAULTING");
         p = new ProviderHomescreen(this);
      }
      p.createAndShowGUI(this.frame);
      frame.pack();
      frame.revalidate();
      frame.repaint();
      frame.setVisible(true);

   }

   public void displayFrameOpt(GenericEnum opt, Patient pat) {

      // Remove everything from the frame
      frame.getContentPane().removeAll();
      frame.revalidate();
      frame.repaint();

      ProviderFrontend p = null;

      switch (opt) {
      case HOME:
         p = new ProviderHomescreen(this);
         break;
      case POVERVIEW:
         p = new ProviderPatientOverview(this, pat);
         break;
      case PVISIT:
         p = new ProviderPatientVisit(this, pat);
         break;
      case PPRESCRIBE:
         p = new ProviderPrescribeView(this, pat);
         break;
      case PTESTREQUEST:
         p = new ProviderRequestTestView(this, pat);
         break;
      case PVIEWTEST:
         p = new ProviderViewTest(this);
         break;
      case PREFERRAL:
         p = new ProviderReferralsView(this, pat);
         break;
      default:
         System.out.println("DEFAULTING");
         p = new ProviderHomescreen(this);
      }
      p.createAndShowGUI(this.frame, pat);
      frame.pack();
      frame.revalidate();
      frame.repaint();
      frame.setVisible(true);

   }
}
