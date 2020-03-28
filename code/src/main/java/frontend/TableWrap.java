package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Date;
import java.util.Vector;
import static java.nio.file.StandardCopyOption.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableWrap extends JPanel {
	/**
	 * 
	 */
	private JTable table;
	private Object[][] data = {};
	String []colNames = {};
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	int rowCount = 0, colCount = 0;
	public TableWrap () {
		super(new BorderLayout());
		readData();
		Path path = FileSystems.getDefault().getPath("data.csv");
		File file = new File("data.csv");
		
	}
	
	public void readData() {
		
		
		String workingDir = System.getProperty("user.dir");
		try (BufferedReader reader = new BufferedReader(new FileReader(workingDir+"/src/main/java/frontend/data.csv"))) {
			String line = reader.readLine();
			colNames = line.split(",");
			//System.out.println(colNames[0] + " " + colNames[1] + " " + colNames[2] + " " + colNames[3] + " " + colNames[4] + " " + colNames[5]);
			int numCols = colNames.length;
			int row = 0;
			Vector<ScheduleData> dataVec = new Vector<ScheduleData>();
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				String firstName = temp[0];
				//System.out.println(firstName);
				/*if(temp.length > 3) {
					for (int i = 3; i < temp.length; i++) {
						title += ", ";
						title += temp[i];
					}
				}*/
				
				//System.out.println("LINE " + line);
				
				System.out.println(temp.length);
		        for(int i = 0; i < 6; i++) {
		        	//System.out.println(temp[i]);
		        	temp[i] = temp[i].replaceAll("\\s", "");
		        	//System.out.println(temp[i]);
		        }
		        String lastName = temp[1];
		        String year = temp[2];
		        //System.out.println(year.length());
		        year = year.substring(0, 4);
				int yearInt = Integer.parseInt(year);
				String month = temp[2];
				month = month.substring(4, 6);
				int monthInt = Integer.parseInt(month);
				String day = temp[2];
				day = day.substring(6);
				int dayInt = Integer.parseInt(day);
				Date dateVisit = new Date(yearInt, monthInt, dayInt);
				
				String sentTheBill = temp[3];
				boolean billSent = false;
				if (sentTheBill.compareTo("false") == 1) {
					billSent = true;
				}
				
				String BillSendDate = temp[4];
				int BillYear = 0;
				int BillMonth = 0;
				int BillDay = 0;
				if (BillSendDate.compareTo("false") == 1) {
				
					BillYear = Integer.parseInt(BillSendDate.substring(0, 4));
					BillSendDate = temp[4];
					BillMonth = Integer.parseInt(BillSendDate.substring(4,6));
					BillSendDate = temp[4];
					BillDay = Integer.parseInt(BillSendDate.substring(6));
				}
				
				Date billSendDay = new Date(BillYear, BillMonth, BillDay);
				
				boolean billPaid = false;
				
				//System.out.println("Uhhh");
				//System.out.println("Uhhh");
				ScheduleData schedule = new ScheduleData(firstName, lastName, dateVisit, 
										billSent, billSendDay, billPaid);
				dataVec.add(schedule);
				//System.out.println();
				row++;
				//System.out.println("At least we're here?");
			}
			data = new Object[row][colNames.length];
			for (int i = 0; i < row; i++) {
				ScheduleData holder = dataVec.get(i);
				data[i][0] = holder.getFirstName();
				data[i][1] = holder.getLastName();
				data[i][2] = holder.getDateOfVisit();
				if(holder.isBillSent()) {
					data[i][3] = "yes";
				}
				else {
					data[i][3] = "no";
				}
				data[i][4] = holder.getDateBillSent();
				if(holder.isBillPaid()) {
					data[i][5] = "yes";
				}
				else {
					data[i][5] = "no";
				}
				//data[i][2] = holder.getTitle();
			}
			rowCount = row;
			colCount = 6;
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

	public void rewriteFile() {
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
					//Path pather = 
					Files.createFile(p);
					//System.out.println("llllll");
					
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
		
	}
}
