package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import backend.classes.Patient;
import businesslayer.CShareObjects;
import businesslayer.ProviderService;
import frontend.patient.TestTableModel;

public class StaffPatientRecordsView extends GenericStaffScreen{
   protected static ProviderService serv;
   StaffPatientRecordsView(StaffRunner r) {
      super(r);
      serv = new ProviderService();

   }
   
   private void patientRecords (Container mainPane, List<Patient> data) {
      JPanel records = new JPanel();
      records.setLayout(new BoxLayout(records, BoxLayout.PAGE_AXIS));
      
      /*** Data Retrieval *****/
      String [] fields = {"PatientID"};
      String[] params = {};
      
      PatientTableModel ptModel = new PatientTableModel(data);
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

   public void createAndShowGUI(Container pane, List<Patient> data) {
      topBarStaff(pane);
      patientRecords(pane,data);
      staffSideBar(pane);
   }
}
