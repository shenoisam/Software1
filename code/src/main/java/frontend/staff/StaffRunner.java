package frontend.staff;

import frontend.EHRRunner;
import frontend.GenericEnum;
import frontend.GenericRunner;

public class StaffRunner extends GenericRunner {
   public StaffRunner(EHRRunner r) {
      super(r);

   }

   private static void checkPasswordValidity(String password) {

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
      default:
         g = new StaffHomescreen(this);
         frame.setTitle("Staff Home Screen");
         break;
      }
      g.createAndShowGUI(frame.getContentPane());

      frame.pack();
      frame.revalidate();
      frame.repaint();
      frame.setVisible(true);

   }
}
