package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StaffViewPatientRecords extends GenericStaffScreen{

   StaffViewPatientRecords(StaffRunner r) {
      super(r);
   }
   
   private void patientRecords (Container pane) {
      
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      patientRecords(pane);
      staffSideBar(pane);
   }
}
