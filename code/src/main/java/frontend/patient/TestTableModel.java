package frontend.patient;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import backend.classes.TestOrder;
import backend.classes.TestResult;

/**
 * Displays the table containing test data
 *
 */
public class TestTableModel extends AbstractTableModel {
	private List<TestResult> testOrders;
	private String[] columnNames = {"Test Name", "Date of Test",
									"Result"};

	/**
	 * 
	 * @param list
	 */
	public TestTableModel(List<TestResult> list){
		testOrders = list;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
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
	 * @return Object
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TestResult tOrder = testOrders.get(rowIndex);
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
	
	/**
	 * @param col
	 * @return String
	 */
	public String getColumnName(int col) {
		return columnNames[col];
	}

}
