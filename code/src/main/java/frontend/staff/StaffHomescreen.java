package frontend.staff;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StaffHomescreen extends GenericStaffScreen {

   StaffHomescreen(StaffRunner r) {
      super(r);
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      staffSideBar(pane);

      JPanel middleOfScreen = new JPanel();
      middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS));

      OfficeSchedule table = new OfficeSchedule();
      table.setOpaque(true);

      middleOfScreen.add(table);
      pane.add(middleOfScreen);
   }

}
