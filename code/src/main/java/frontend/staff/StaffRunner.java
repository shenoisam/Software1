package frontend.staff;

import java.util.List;

import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;
import backend.classes.*;
public class StaffRunner extends GenericRunner {
   public StaffRunner(EHRRunner r) {
      super(r);
   }

   public void displayFrameOpt(GenericEnum opt) {

      frame.getContentPane().removeAll();
      frame.revalidate();
      frame.repaint();

      GenericStaffScreen g = null;

      switch (opt) {
      case HOME:
         g = new StaffHomescreen(this);
         frame.setTitle("Staff Home Screen");
         break;
      case BILLING:
         g = new StaffBillingScreen(this);
         frame.setTitle("Staff Billing Screen");
         break;
      case SCHEDULE:
         g = new StaffScheduleScreen(this);
         frame.setTitle("Staff Scheduling Screen");
         break;
      case PARAMS:
         g = new StaffPatientRecordParameters(this);
         frame.setTitle("Staff Patient Records Parameters");
         break;
      case VIEWRECORDS:
        
         break;
      default:
         g = new StaffHomescreen(this);
         frame.setTitle("Staff Home Screen");
         break;
      }
      g.createAndShowGUI(this.frame);
      
      frame.pack();
      frame.revalidate();
      frame.repaint();
      frame.setVisible(true);

   }

  public void specialDisplay(List<Patient> data) {
	  frame.getContentPane().removeAll();
      frame.revalidate();
      frame.repaint();
	 GenericStaffScreen g = new StaffPatientRecordsView(this, data);
	 g.createAndShowGUI(this.frame);
     frame.setTitle("Staff View Patient Records");
     frame.pack();
     frame.revalidate();
     frame.repaint();
     frame.setVisible(true);
	
  }
}
