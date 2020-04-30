package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import businesslayer.CShareObjects;
import businesslayer.ProviderService;
import frontend.patient.TestTableModel;

public class StaffPatientRecordsView extends GenericStaffScreen{
   protected static ProviderService serv;

   StaffPatientRecordsView(StaffRunner r) {
      super(r);
      serv = new ProviderService();
   }
   
   private void patientRecords (Container mainPane) {
      JPanel records = new JPanel();
      records.setLayout(new BoxLayout(records, BoxLayout.PAGE_AXIS));
      
      /*** Data Retrieval *****/
      String [] fields = {"PatientID"};
      String[] params = {};
      
      TestTableModel ptModel = new TestTableModel(serv.getData(CShareObjects.TESTRESULT, fields, params));
      JTable testTable = new JTable();
      testTable.setModel(ptModel);
      JScrollPane scrollPane = new JScrollPane(testTable);
      records.add(scrollPane);

      JLabel label = new JLabel("Information");
      label.setBorder(BorderFactory.createLineBorder(Color.GRAY));

      JPanel pane = new JPanel();
      SpringLayout sl = new SpringLayout();
      sl.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, pane);
      sl.putConstraint(SpringLayout.EAST, label, -5, SpringLayout.EAST, pane);
      sl.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, pane);
      pane.setLayout(sl);
      pane.setPreferredSize(new Dimension(10, 100));
      pane.add(label);

      records.add(pane);

      mainPane.add(records);
   }

   public void createAndShowGUI(Container pane) {
      topBarStaff(pane);
      patientRecords(pane);
      staffSideBar(pane);
   }
}
