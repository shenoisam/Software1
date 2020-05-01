package frontend.staff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.classes.Appointment;
import backend.classes.Doctor;
import backend.dao.AppointmentDAO;
import businesslayer.CShareObjects;
import businesslayer.ProviderService;

public class OfficeSchedule extends JPanel{
	private JTable table;
	private Object[][] data = {};
	String []colNames = {};
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	int rowCount = 0, colCount = 0;
	public OfficeSchedule () {
		super(new BorderLayout());
		readData();
		
	}
	
	public void readData() {
		/*BufferedReader reader;
		
		try {
			
			reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("officeData.csv").getFile()));
			String line = reader.readLine();
			colNames = line.split(",");
			System.out.println(colNames[0] + " " + colNames[1] + " " + colNames[2] + " " + colNames[3]);// + " " + colNames[4]);// + " " //+ colNames[5]);
			int numCols = colNames.length;
			int row = 0;
			Vector<Vector<OfficeScheduleData>> dataVec = new Vector<Vector<OfficeScheduleData>>();
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				String[] temp = line.split(",");
				//String timeAppointment = temp[0];
				//int timeAppt = Integer.parseInt(timeAppointment);

		        for(int i = 1; i < numCols; i++) {
		        	//System.out.println(temp[i]);
		        	String tempStr = temp[i];
		        	temp[i] = tempStr.substring(1);
		            System.out.println(temp[i]);
		        }
		        Vector<OfficeScheduleData> tempVector = new Vector<OfficeScheduleData>();
		        for(int j = 1; j < numCols; j++) {
		        	String nameAppt = temp[j];
		        	OfficeScheduleData tempData = new OfficeScheduleData(temp[0], nameAppt);
		        	tempVector.add(tempData);
		        }
		        dataVec.add(tempVector);
		        row++;
			}    
			data = new Object[row][numCols];
			for (int i = 0; i < row; i++) {
				OfficeScheduleData tempOfficeData = dataVec.elementAt(i).elementAt(0);
				data[i][0] = tempOfficeData.getTime();
				for (int j = 0; j < numCols - 1; j++) {
					OfficeScheduleData tempOffice = dataVec.elementAt(i).elementAt(j);
					data[i][j+1] = tempOffice.getAppointmentName();
					System.out.println("D: " + data[i][j+1]);
				}
			}
			rowCount = row;
			colCount = numCols;
			reader.close();
			
		} catch(IOException e) {
			System.err.format("IOException: ", e);
			System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));
			System.exit(1);
		}*/
		

		// Retrieves a list of all appointments
		List<Appointment> li = new ArrayList();
		LocalDateTime date = LocalDateTime.now();
	    String [] params = {};
	    String [] fields = {};
	    ProviderService serv = new ProviderService();
	    li = serv.getData(CShareObjects.APPOINTMENT, fields, params);
	    
	    // Retrieves a list of all doctors
	    String[] doctorFields = {};
	    String[] parameters = {};
	    List<Doctor> docs = serv.getData(CShareObjects.DOCTOR, doctorFields, parameters);
	    
	    // Generates list of headers for table using doctor names
	    // Uses doctor names to generate headers for table
	    List<String> headers = new ArrayList<String>(); 
	    headers.add(" ");
	    for(Doctor doc: docs) {
	    	headers.add("Dr. " + doc.getLastName());
	    }
	    
	    // Finds total number of appointment time slots
	    int numApptTimes = 0;
    	Vector<LocalDateTime> times = new Vector<LocalDateTime>();
    	
    	// Finds every appointment time slot across all doctors
    	for(Appointment a : li) {
    		if(!times.contains(a.getAppointmentDate())) {
    			numApptTimes++;
    			times.add(a.getAppointmentDate());
    		} 
    	}
    	
    	// fills data array with correct patient ID 
    	// corresponding with appointment time and doctor
    	data = new String[numApptTimes][headers.size()];
    	
    	// Iterates through every time slot
    	for(int i = 0; i < numApptTimes; i++) {
    		// Fills first column of table with appt times
    		data[i][0] = times.get(i).toLocalTime().toString();
    		if(headers.size() > 1) {
    			// Iterates through every doctor name
    			for(int j = 1; j < headers.size(); j++) {
    				// If the doctor has no appointment at scheduled time, put <nopatient>
    				data[i][j] = "<no patient>";
    				// Iterates through every appointment
    				for(int k = 0; k < li.size(); k++) {
    					// Iterates through every doctor
    					for(int l = 0; l < docs.size(); l++) {
    						// Checks if doctor has appt with specific patientID at specific time
    						if(li.get(k).getDoctorID().equals(docs.get(l).getDoctorID())) {
    							data[i][j] = "Patient " + li.get(k).getPatientID();
    						}
    					}
    				}
    			}
    		}
    	}
    	
		
		table = new JTable(new ScheduleTable(data, colNames));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scroller = new JScrollPane(table);
		add(scroller, BorderLayout.CENTER);
	}

	/*public void rewriteFile() {
		String workingDir = System.getProperty("user.dir");
		BufferedWriter writer = null;
		Path path = Paths.get(workingDir+"/src/main/java/frontend/data.csv");
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnValue = chooser.showSaveDialog(this);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					//Files.deleteIfExists(path);
					//Files.createFile(path);
					String f = chooser.getCurrentDirectory().getAbsolutePath();
					//File file = new File("data.csv");
					f += "/" + "data.csv";
					Path p = Paths.get(f);
					//System.out.println(f);
					Files.deleteIfExists(p);
					//System.out.println(f.getName());
					//String fileName = f.getCanonicalPath();
					//System.out.println("PATH: " + fileName);
					//Path p = Paths.get(fileName);
					Files.createFile(p);
					
					writer = new BufferedWriter(new FileWriter(f));
					//System.out.println(table.getRowCount() + " " + table.getColumnCount());
					String hold = "" + colNames[0] + " " + colNames[1] + " " + colNames[2] + " " + 
									colNames[3] + " " + colNames[4] + " " + colNames[5] + "\n";
					writer.write(hold);
					for (int i = 0; i < table.getRowCount(); i++) {
						String output = "";
						for (int j = 0; j < table.getColumnCount() - 1; j++) {
							output += table.getValueAt(i, j);
							output += ", ";
						}
						output += table.getValueAt(i, table.getColumnCount() - 1);
						output += "\n";
						//System.out.println(output);
						writer.write(output);
						
					}
					writer.close();
					
					Files.copy(p, path, REPLACE_EXISTING);
				} catch(NoSuchFileException n) {
					System.err.format("%s does not exist\n", n.getFile());
				} catch (IOException e) {
					System.err.format("IOException: here", e);
					System.out.println("Working Directory = " +
				              System.getProperty("user.dir"));
					System.exit(1);
				} finally {
					if(writer != null) {
						try {
							writer.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} catch(Exception e) {
			
		}
		
	}*/
}
