package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Displays the homescreen from the staff view
 *
 */
public class StaffHomescreen extends GenericStaffScreen {

   StaffHomescreen(StaffRunner r) {
      super(r);
   }
   
   private void showOfficeSchedule (Container pane) {
      JPanel middleOfScreen = new JPanel();
      middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS));
      
      JPanel titlePanel = new JPanel();
      titlePanel.setLayout(new GridLayout(1,3));
      titlePanel.setBorder(BorderFactory.createTitledBorder(""));
      titlePanel.setBackground(Color.GRAY);
      JPanel fillerPanel1 = new JPanel();
      fillerPanel1.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel1);
      JLabel title = new JLabel ("Today's Office Schedule");
      title.setFont(title.getFont().deriveFont(15f));
      titlePanel.add(title);
      JPanel fillerPanel2 = new JPanel();
      fillerPanel2.setBackground(Color.GRAY);
      titlePanel.add(fillerPanel2);
      
      middleOfScreen.add(titlePanel);

      OfficeSchedule table = new OfficeSchedule();
      table.setOpaque(true);

      middleOfScreen.add(table);
      pane.add(middleOfScreen);
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      staffSideBar(pane);
      showOfficeSchedule(pane);
   }

}
