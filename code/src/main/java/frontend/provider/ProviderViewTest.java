package frontend.provider;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

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
import businesslayer.CShareObjects;
import frontend.patient.TestTableModel;

/**
 * ProviderViewTest class that displays information about
 * a Test
 *
 */
public class ProviderViewTest extends ProviderFrontend {
   private Patient pat;

   /**
    * 
    * @param p
    */
   public ProviderViewTest(ProviderRunner p) {
      super(p);
   }

   /**
    * 
    * @param providerRunner
    * @param pat
    */
   public ProviderViewTest(ProviderRunner providerRunner, Patient pat) {
      super(providerRunner);
      this.pat = pat;
   }

   /**
    * 
    * @param mainPane
    */
   protected void viewTestPanel(Container mainPane) {
      JPanel viewTest = new JPanel();
      viewTest.setLayout(new BoxLayout(viewTest, BoxLayout.PAGE_AXIS));
      
      /*** Data Retrieval *****/
      String [] fields = {"PatientID"};
      String[] params = {pat.getID()};
      

      TestTableModel ptModel = new TestTableModel(serv.getData(CShareObjects.TESTRESULT, fields, params));
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
