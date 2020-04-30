package frontend.staff;

import java.awt.Container;

public class StaffViewPatientRecords extends GenericStaffScreen{

   StaffViewPatientRecords(StaffRunner r) {
      super(r);
   }
   
   private void parameters (Container pane) {
      
   }
   
   private void patientRecords (Container pane) {
      
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      patientRecords(pane);
      staffSideBar(pane);
   }
}
