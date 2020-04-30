package frontend.staff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import static java.nio.file.StandardCopyOption.*;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.classes.Appointment;
import backend.classes.Diagnosis;
import backend.classes.PatientDiagnosis;
import businesslayer.CShareObjects;
import businesslayer.ProviderService;

public class BillingTable extends JPanel {
   private JTable table;
   private Object[][] data = {};
   String[] colNames = {};
   private static final long serialVersionUID = 1L;
   private boolean DEBUG = false;
   int rowCount = 0, colCount = 0;
   private Connection c;

   public BillingTable() {
      super(new BorderLayout());
      readData();
      Path path = FileSystems.getDefault().getPath("data.csv");
      File file = new File("data.csv");

   }
   /*
    * String [] fields = {"PatientID"};
      String [] params = {pat.getID()};
      List<PatientDiagnosis> pds =  serv.getData(CShareObjects.PATIENTDIAGNOSIS,fields , params);
      String text = "";
      String [] fields2 = {"Name"};
      String [] params2 = new String [1];
      for (PatientDiagnosis z : pds) {
    	  params2[0] = z.getName();
    	  
    	  List<Diagnosis> diag = serv.getData(CShareObjects.DIAGNOSIS,fields2 , params2);
    	  text = text + diag.stream().map(e -> e.getName()).reduce("\n", String::concat) + "\n";
      }
    */
   public void readData() {
      /*String workingDir = System.getProperty("user.dir");
      try (BufferedReader reader = new BufferedReader(
            new FileReader(workingDir + "/src/main/resources/data.csv"))) {
         String line = reader.readLine();
         colNames = line.split(",");
         // System.out.println(colNames[0] + " " + colNames[1] + " " + colNames[2] + " "
         // + colNames[3] + " " + colNames[4] + " " + colNames[5]);
         int numCols = colNames.length;
         int row = 0;
         Vector<ScheduleData> dataVec = new Vector<ScheduleData>();

         while ((line = reader.readLine()) != null) {
            String[] temp = line.split(",");
            String firstName = temp[0];
            // System.out.println(firstName);
            

            // System.out.println("LINE " + line);

            // System.out.println(temp.length);
            for (int i = 0; i < 6; i++) {
               // System.out.println(temp[i]);
               temp[i] = temp[i].replaceAll("\\s", "");
               // System.out.println(temp[i]);
            }
            // Last name
            String lastName = temp[1];

            // Date of visit
            // Date month starts with 0, January = 0
            String dateOfVisit = temp[2];
            Calendar calendarVisit = Calendar.getInstance();
            int year = Integer.parseInt(dateOfVisit.substring(0, 4));
            dateOfVisit = temp[2];
            int month = Integer.parseInt(dateOfVisit.substring(4, 6));
            dateOfVisit = temp[2];
            int day = Integer.parseInt(dateOfVisit.substring(6));
            calendarVisit.set(Calendar.MONTH, month);
            calendarVisit.set(Calendar.DATE, day);
            calendarVisit.set(Calendar.YEAR, year);
            Date dateVisit = calendarVisit.getTime();

            String sentTheBill = temp[3];
            boolean billSent = false;
            if (sentTheBill.compareTo("false") != 0) {
               billSent = true;
            }

            // Date stuff is still weird...
            String BillSendDate = temp[4];
            int BillYear = 0;
            int BillMonth = 0;
            int BillDay = 0;
            Calendar c1 = Calendar.getInstance();
            Date billSendDay = null;
            if (BillSendDate.compareTo("n/a") != 0) {
               BillYear = Integer.parseInt(BillSendDate.substring(0, 4));
               BillSendDate = temp[4];
               BillMonth = Integer.parseInt(BillSendDate.substring(4, 6));
               BillSendDate = temp[4];
               BillDay = Integer.parseInt(BillSendDate.substring(6));
               c1.set(Calendar.MONTH, BillMonth);
               c1.set(Calendar.DATE, BillDay);
               c1.set(Calendar.YEAR, BillYear);
               billSendDay = c1.getTime();
            }

            boolean billPaid = false;
            String billWasPaidStr = temp[5];
            if (billWasPaidStr.compareTo("false") != 0) {
               billPaid = true;
            }

            ScheduleData schedule = new ScheduleData(firstName, lastName, dateVisit, billSent, billSendDay, billPaid);
            dataVec.add(schedule);
            row++;
         }

         Calendar cal = Calendar.getInstance();
         cal.set(Calendar.MONTH, 0);
         cal.set(Calendar.DATE, 0);
         cal.set(Calendar.YEAR, 0);
         // System.out.println(compareDate);
         data = new Object[row][colNames.length];
         for (int i = 0; i < row; i++) {
            ScheduleData holder = dataVec.get(i);
            data[i][0] = holder.getFirstName();
            data[i][1] = holder.getLastName();
            data[i][2] = holder.getDateOfVisit();
            if (holder.isBillSent()) {
               data[i][3] = "yes";
            } else {
               data[i][3] = "no";
            }
            Date billSendDate = holder.getDateBillSent();
            // String compareDateBill = new
            // SimpleDateFormat("yyyy-MM-dd").format(compareDate);
            if (billSendDate == null) {
               data[i][4] = "n/a";
            } else {
               // String dateBillSent = new
               // SimpleDateFormat("yyyy-MM-dd").format(billSendDate);
               data[i][4] = billSendDate;
            }
            if (holder.isBillPaid()) {
               data[i][5] = "yes";
            } else {
               data[i][5] = "no";
            }
         }
         rowCount = row;
         colCount = 6;
         reader.close();

      } catch (IOException e) {
         System.out.println(e);
         System.err.format("IOException: ", e);
         System.out.println("Working Directory = " + System.getProperty("user.dir"));
         System.exit(1);
      }*/
	  List<Appointment> allBilling= new ArrayList();
	  LocalDateTime date = LocalDateTime.now();
	  String[] params = {date.toString()};
	  String[] fields = {"DateVal"};
	  ProviderService serv = new ProviderService();
	  allBilling = serv.getData(CShareObjects.APPOINTMENT, fields, params);
	  
	  List<String> headers = new ArrayList<String>();
	  headers.add("First");
	  headers.add("Last");
	  headers.add("Date");
	  
	  colNames = headers.toArray(new String[0]);
	  
	  data = new Object[allBilling.size() + 1][];
	  for (int i = 0; i < allBilling.size(); i++) {
		  data[i] = new String[3];
		  data[i][0] = allBilling.get(i).getPatientID();
		  data[i][1] = "LAST";
		  data[i][2] = "DATE";
	  }
	  
      table = new JTable(new ScheduleTable(data, colNames));
      table.setPreferredScrollableViewportSize(new Dimension(500, 70));
      JScrollPane scroller = new JScrollPane(table);
      add(scroller, BorderLayout.CENTER);
   }

   public void rewriteFile() {
      String workingDir = System.getProperty("user.dir");
      BufferedWriter writer = null;
      Path path = Paths.get(workingDir + "/src/main/java/frontend/data.csv");
      try {
         JFileChooser chooser = new JFileChooser();
         chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         int returnValue = chooser.showSaveDialog(this);
         if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
               // Files.deleteIfExists(path);
               // Files.createFile(path);
               String f = chooser.getCurrentDirectory().getAbsolutePath();
               // File file = new File("data.csv");
               f += "/" + "data.csv";
               Path p = Paths.get(f);
               // System.out.println(f);
               Files.deleteIfExists(p);
               // System.out.println(f.getName());
               // String fileName = f.getCanonicalPath();
               // System.out.println("PATH: " + fileName);
               // Path p = Paths.get(fileName);
               Files.createFile(p);

               writer = new BufferedWriter(new FileWriter(f));
               // System.out.println(table.getRowCount() + " " + table.getColumnCount());
               String hold = "" + colNames[0] + " " + colNames[1] + " " + colNames[2] + " " + colNames[3] + " "
                     + colNames[4] + " " + colNames[5] + "\n";
               writer.write(hold);
               for (int i = 0; i < table.getRowCount(); i++) {
                  String output = "";
                  for (int j = 0; j < table.getColumnCount() - 1; j++) {
                     output += table.getValueAt(i, j);
                     output += ", ";
                  }
                  output += table.getValueAt(i, table.getColumnCount() - 1);
                  output += "\n";
                  // System.out.println(output);
                  writer.write(output);

               }
               writer.close();

               Files.copy(p, path, REPLACE_EXISTING);
            } catch (NoSuchFileException n) {
               System.err.format("%s does not exist\n", n.getFile());
            } catch (IOException e) {
               System.err.format("IOException: here", e);
               System.out.println("Working Directory = " + System.getProperty("user.dir"));
               System.exit(1);
            } finally {
               if (writer != null) {
                  try {
                     writer.close();
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
               }
            }
         }
      } catch (Exception e) {

      }

   }
}
