package frontend.patient;

import java.util.ArrayList;
import java.util.List;

import backend.classes.TestResult;

import javax.swing.table.AbstractTableModel;

import backend.classes.TestOrder;
//import frontend.provider.TestResult;

/**
 * Displays the Patient Test Table
 *
 */
public class PatientTestTableModel extends AbstractTableModel {
	private List<TestResult> testOrders;
	private String[] columnNames = {"Test Name", "Date of Test",
									"Result"};

	/**
	 * 
	 * @param tr
	 */
	public PatientTestTableModel(List<Object> tr){
		testOrders = new ArrayList<TestResult>();
		for(Object o : tr) {
			testOrders.add((TestResult)o);
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(testOrders == null) {return 0;}
		
		return testOrders.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	/**
	 * @param rowIndex
	 * @param columnIndex
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		backend.classes.TestResult tOrder = testOrders.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return tOrder.getTestName();
		case 1:
			return tOrder.getTestDate();
		case 2:
			return tOrder.getResult();
		}
		return null;
	}
	
	public void updateTable() {
		fireTableRowsInserted(0, this.testOrders.size()-1);
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}

}
