package frontend.staff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.classes.Appointment;
import backend.classes.Doctor;
import backend.classes.Patient;
import backend.dao.AppointmentDAO;
import backend.dao.DoctorDAO;
import backend.dao.PatientDAO;

public class ProvidersSchedule extends JPanel {
	
	/**
	 * Defines a schedule for the provider
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
   private JTable table;
   private Object[][] data = {};
   String[] colNames = {"Date", "Doctor", "Patient"};
   private static final long serialVersionUID = 1L;
   private boolean DEBUG = false;
   int rowCount = 0, colCount = 0;

   /**
	 * initializes a new ProviderSchedule instance
	 */
   public ProvidersSchedule() {
      super(new BorderLayout());
      readData();

   }

   /**
	 * reads data into a new table and displays it
	 * 
	 * @see StaffScheduleScreen#showSchedule
	 */
   public void readData() {
     /* String workingDir = System.getProperty("user.dir");
      try {
         BufferedReader reader = new BufferedReader(
               new FileReader(getClass().getClassLoader().getResource("providerData.csv").getFile()));
         String line = reader.readLine();
         colNames = line.split(",");
         // System.out.println(colNames[0] + " " + colNames[1] + " " + colNames[2] + " "
         // + colNames[3] + " " + colNames[4] + " " + colNames[5]);
         int numCols = colNames.length;
         int row = 0;
         Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
         Vector<String> times = new Vector<String>();

         while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] temp = line.split(",");
            // String timeAppointment = temp[0];
            // int timeAppt = Integer.parseInt(timeAppointment);
            times.add(temp[0]);
            for (int i = 1; i < numCols; i++) {
               // System.out.println(temp[i]);
               String tempStr = temp[i];
               temp[i] = tempStr.substring(1);
               System.out.println(temp[i]);
            }
            Vector<String> tempStr = new Vector<String>();
            for (int j = 1; j < numCols; j++) {
               tempStr.add(temp[j]);
            }
            dataVec.add(tempStr);
            row++;
         }*/
	   
	   	
	   	List<Appointment> list;
	   	List<Patient> pat;
	   	List<Doctor> doc;
	   	PatientDAO pd = new PatientDAO();
	   	DoctorDAO dd = new DoctorDAO();
	   	list = new AppointmentDAO().getData(new String[0],new String[0]);
	   	
	   	String[] fields = {"ID"}, param = new String[1];
	   	
	   	
	   	data = new Object[list.size()][3];
	   	
	   	for(int i = 0; i < list.size(); i++) {
	   		data[i][0] = list.get(i).getAppointmentDate().toString();
	   		
	   		fields[0] = "ID";
	   		param[0] = list.get(i).getPatientID();
	   		pat = pd.getData(fields, param);
	   		
	   		if(pat.get(0) != null) {
	   			data[i][2] = pat.get(0).getFullName();
	   		}else {
	   			data[i][2] = "N/A";
	   		}
	   		
	   		
	   		fields[0] = "ID";
	   		param[0] = list.get(i).getDoctorID();
	   		doc = dd.getData(fields, param);
	   		
	   		if(doc.get(0) != null) {
	   			data[i][1] = doc.get(0).getFullName();
	   		}else {
	   			data[i][1] = "N/A";
	   		}
	   		
	   		
	   	}
	    
	   
         /*data = new Object[row][numCols];
         for (int i = 0; i < row; i++) {
            data[i][0] = times.elementAt(i);
            for (int j = 0; j < numCols - 1; j++) {
               data[i][j + 1] = dataVec.elementAt(i).elementAt(j);
            }
         }
         rowCount = row;
         colCount = numCols;
         reader.close();

      } catch (IOException e) {
         System.err.format("IOException: ", e);
         System.out.println("Working Directory = " + System.getProperty("user.dir"));
         System.exit(1);
      }*/
      table = new JTable(new ScheduleTable(data, colNames));
      table.setPreferredScrollableViewportSize(new Dimension(500, 70));
      JScrollPane scroller = new JScrollPane(table);
      add(scroller, BorderLayout.CENTER);
   }

   /*
    * public void rewriteFile() { String workingDir =
    * System.getProperty("user.dir"); BufferedWriter writer = null; Path path =
    * Paths.get(workingDir+"/src/main/java/frontend/data.csv"); try { JFileChooser
    * chooser = new JFileChooser();
    * chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); int returnValue
    * = chooser.showSaveDialog(this); if (returnValue ==
    * JFileChooser.APPROVE_OPTION) { try { //Files.deleteIfExists(path);
    * //Files.createFile(path); String f =
    * chooser.getCurrentDirectory().getAbsolutePath(); //File file = new
    * File("data.csv"); f += "/" + "data.csv"; Path p = Paths.get(f);
    * //System.out.println(f); Files.deleteIfExists(p);
    * //System.out.println(f.getName()); //String fileName = f.getCanonicalPath();
    * //System.out.println("PATH: " + fileName); //Path p = Paths.get(fileName);
    * Files.createFile(p);
    * 
    * writer = new BufferedWriter(new FileWriter(f));
    * //System.out.println(table.getRowCount() + " " + table.getColumnCount());
    * String hold = "" + colNames[0] + " " + colNames[1] + " " + colNames[2] + " "
    * + colNames[3] + " " + colNames[4] + " " + colNames[5] + "\n";
    * writer.write(hold); for (int i = 0; i < table.getRowCount(); i++) { String
    * output = ""; for (int j = 0; j < table.getColumnCount() - 1; j++) { output +=
    * table.getValueAt(i, j); output += ", "; } output += table.getValueAt(i,
    * table.getColumnCount() - 1); output += "\n"; //System.out.println(output);
    * writer.write(output);
    * 
    * } writer.close();
    * 
    * Files.copy(p, path, REPLACE_EXISTING); } catch(NoSuchFileException n) {
    * System.err.format("%s does not exist\n", n.getFile()); } catch (IOException
    * e) { System.err.format("IOException: here", e);
    * System.out.println("Working Directory = " + System.getProperty("user.dir"));
    * System.exit(1); } finally { if(writer != null) { try { writer.close(); }
    * catch (IOException e) { // TODO Auto-generated catch block
    * e.printStackTrace(); } } } } } catch(Exception e) {
    * 
    * }
    * 
    * }
    */

}
