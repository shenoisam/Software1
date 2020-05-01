package frontend.staff;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import backend.classes.Patient;
import businesslayer.ProviderService;

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

      JPanel exportPanel = new JPanel();
      exportPanel.add(new JLabel("Would you like to export this information?"));
      JButton export = new JButton("Export");
      
      export.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            JPanel parent = new JPanel();
            int result = fileChooser.showSaveDialog(parent);
            File save = fileChooser.getSelectedFile();

            try {
               writeCSVfile(testTable, save);
            } catch (IOException | ClassNotFoundException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
         }
      });
      
      exportPanel.add(export);
      records.add(exportPanel);
      mainPane.add(records);
   }

   public void createAndShowGUI(Container pane, List<Patient> data) {
      topBarStaff(pane);
      patientRecords(pane,data);
      staffSideBar(pane);
   }
   
   private void writeCSVfile(JTable table, File save) throws IOException, ClassNotFoundException {
      Writer writer = null;
      AbstractTableModel dtm = (AbstractTableModel) table.getModel();
      int nRow = dtm.getRowCount();
      int nCol = dtm.getColumnCount();
      try {
         writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(save), "utf-8"));

         // write the header information
         StringBuffer bufferHeader = new StringBuffer();
         for (int j = 0; j < nCol; j++) {
            bufferHeader.append(dtm.getColumnName(j));
            if (j != nCol)
               bufferHeader.append(", ");
         }
         writer.write(bufferHeader.toString() + "\r\n");

         // write row information
         for (int i = 0; i < nRow; i++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < nCol; j++) {
               buffer.append(dtm.getValueAt(i, j));
               if (j != nCol)
                  buffer.append(", ");
            }
            writer.write(buffer.toString() + "\r\n");
         }
      } finally {
         writer.close();
      }
   }
}
