package frontend.staff;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import backend.classes.Patient;
import backend.classes.TestResult;

public class PatientTableModel extends AbstractTableModel {
	
	/**
	 * Defines a patient table model
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	private List<Patient> pats;
	private String[] columnNames = {"FirstName", "Last Name", "Email"};

	/**
	 * initializes a PatientTableModel instance
	 * 
	 * @param list the list of all patients in the table
	 */
	public PatientTableModel(List<Patient> list){
		pats = list;
		
	
	}
	
	/**
	 * gets the number of rows in the table
	 * 
	 * @return returns the number of rows
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pats.size();
	}

	/**
	 * gets the number of columns in the table
	 * 
	 * @return returns the number of columns
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	/**
	 * gets the value at a specific row and column
	 * 
	 * @param rowIndex the index of the row of the item
	 * @param columnIndex the index of the column of the item
	 * 
	 * @return rthe object at the row and column
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Patient tOrder = pats.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return tOrder.getFirstName(); 
		case 1:
			return tOrder.getLastName(); 
		case 2:
			return tOrder.getEmail();  
		}
		return null;
	}
	
	/**
	 * gets the column name of the table
	 * 
	 * @return returns the name of the column
	 */
	public String getColumnName(int col) {
		return columnNames[col];
	}

}

