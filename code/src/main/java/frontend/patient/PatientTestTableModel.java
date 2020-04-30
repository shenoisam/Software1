package frontend.patient;

import java.util.ArrayList;
import java.util.List;

import backend.classes.TestResult;

import javax.swing.table.AbstractTableModel;

import backend.classes.TestOrder;
import frontend.provider.TestResult;

public class PatientTestTableModel extends AbstractTableModel {
	private List<TestResult> testOrders;
	private String[] columnNames = {"Test Name", "Date of Test",
									"Result"};

	public PatientTestTableModel(List<backend.classes.TestResult> tr){
		testOrders = tr;
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
	
	public String getColumnName(int col) {
		return columnNames[col];
	}

}
