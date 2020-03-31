package frontend;

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
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		Path path = FileSystems.getDefault().getPath("data.csv");
		File file = new File("data.csv");
		
	}
	
	public void readData() {
		
		
		String workingDir = System.getProperty("user.dir");
		try (BufferedReader reader = new BufferedReader(new FileReader(workingDir+"/src/main/java/frontend/officeData.csv"))) {
			String line = reader.readLine();
			colNames = line.split(",");
			//System.out.println(colNames[0] + " " + colNames[1] + " " + colNames[2] + " " + colNames[3] + " " + colNames[4] + " " + colNames[5]);
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
