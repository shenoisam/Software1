package frontend.provider;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import backend.classes.Patient;
import backend.classes.TestOrder;
<<<<<<< Updated upstream
import businesslayer.CShareObjects;
import frontend.patient.PatientTestTableModel;
import backend.classes.*;

=======
>>>>>>> Stashed changes
import frontend.patient.TestTableModel;

public class ProviderViewTest extends ProviderFrontend {
   private Patient pat;

   public ProviderViewTest(ProviderRunner p) {
      super(p);
   }

   public ProviderViewTest(ProviderRunner providerRunner, Patient pat) {
      super(providerRunner);
      this.pat = pat;
   }

   protected void viewTestPanel(Container mainPane) {
      JPanel viewTest = new JPanel();
      viewTest.setLayout(new BoxLayout(viewTest, BoxLayout.PAGE_AXIS));

<<<<<<< Updated upstream
      /*****  Data Retrieval **********/
      String [] fields = {"PatientID"};
      String [] params = {pat.getID()};
      List<TestResult> tr = serv.getData(CShareObjects.TESTRESULT, fields, params);
      /*****************************/
      
      PatientTestTableModel ptModel = new PatientTestTableModel(tr);
      TestTableModel model = new TestTableModel(new ArrayList<TestOrder>());

=======
      TestTableModel ptModel = new TestTableModel(new ArrayList<TestOrder>());
>>>>>>> Stashed changes
      JTable testTable = new JTable();
      testTable.setModel(ptModel);
      JScrollPane scrollPane = new JScrollPane(testTable);
      viewTest.add(scrollPane);

      JLabel label = new JLabel("Information");
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

   public void createAndShowGUI(JFrame frame) {
      // Add the relavent panels to the screen
      providerSideBar(frame.getContentPane(), pat);
      topBarPatientInformation(frame.getContentPane(), pat);
      viewTestPanel(frame.getContentPane());

   }

   public void createAndShowGUI(JFrame frame, Patient pat) {
      this.pat = pat;
      // Add the relavent panels to the screen
      providerSideBar(frame.getContentPane(), pat);
      topBarPatientInformation(frame.getContentPane(), pat);
      viewTestPanel(frame.getContentPane());

   }
}
