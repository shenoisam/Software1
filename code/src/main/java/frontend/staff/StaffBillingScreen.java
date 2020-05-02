package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

/**
 * Displays the Staff billing screen GUI
 *
 */
public class StaffBillingScreen extends GenericStaffScreen {
	
	/**
	 * Defines a Staff billing screen
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */

	/**
	 * initializes a new instance of a billing screen
	 */
   StaffBillingScreen(StaffRunner r) {
      super(r);
      // TODO Auto-generated constructor stub
   }
   
   /**
	 * creates a staff billing screen
	 * 
	 * @param mainPane the container in which the new staff screen items will be added
	 */
   private void billingPanel(Container mainPane) {
      JPanel viewTest = new JPanel();
      viewTest.setLayout(new BoxLayout(viewTest, BoxLayout.PAGE_AXIS));

      //TestTableModel model = new TestTableModel(new ArrayList<TestOrder>());
      BillingTable bTable = new BillingTable();
      //bTable.setModel(model);
      JScrollPane scrollPane = new JScrollPane(bTable);
      viewTest.add(scrollPane);

      JLabel label = new JLabel("Billing Information");
      label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
      label.setOpaque(true);

      JPanel pane = new JPanel();
      pane.setOpaque(true);
      SpringLayout sl = new SpringLayout();
      sl.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, pane);
      sl.putConstraint(SpringLayout.EAST, label, -5, SpringLayout.EAST, pane);
      sl.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, pane);
      pane.setLayout(sl);
      pane.setPreferredSize(new Dimension(10, 100));
      pane.add(label);

      viewTest.add(pane);

      mainPane.add(viewTest);
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      staffSideBar(pane);
      billingPanel(pane);
   }
}
