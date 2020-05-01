package frontend.staff;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import backend.classes.Patient;
import backend.classes.TestResult;

public class PatientTableModel extends AbstractTableModel {
	private List<Patient> pats;
	private String[] columnNames = {"FirstName", "Last Name", "Email"};

	public PatientTableModel(List<Patient> list){
		pats = list;
		
	
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pats.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

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
	
	public String getColumnName(int col) {
		return columnNames[col];
	}

}

