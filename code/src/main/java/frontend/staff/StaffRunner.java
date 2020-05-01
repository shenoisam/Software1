package frontend.staff;

import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;

/**
 * Runs the EHR from the staff view
 *
 */
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
      case VIEWRECORDS:
         g = new StaffViewPatientRecords(this);
         frame.setTitle("Staff View Patient Records");
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
}
