package patienthomescreen;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import cshare.TestOrder;

public class PatientTestTableModel extends AbstractTableModel {
	private ArrayList<TestOrder> testOrders;
	private String[] columnNames = {"Test Name", "Date of Test",
									"Last View", "Specimen"};

	public PatientTestTableModel(ArrayList<TestOrder> t){
		testOrders = t;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return testOrders.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TestOrder tOrder = testOrders.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return tOrder.getTestName();
		case 1:
			return tOrder.getDateOrdered();
		case 2:
			return "fix later";
		case 3:
			return tOrder.getTest().getType();
		}
		return null;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}

}
