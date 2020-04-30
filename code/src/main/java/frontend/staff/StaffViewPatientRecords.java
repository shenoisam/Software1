package frontend.staff;

import java.awt.Container;

public class StaffViewPatientRecords extends GenericStaffScreen{

   StaffViewPatientRecords(StaffRunner r) {
      super(r);
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      staffSideBar(pane);
   }
}
