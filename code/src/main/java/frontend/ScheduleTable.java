package frontend;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ScheduleTable extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private String[] columnNames = {};
		private Object[][] data = {};
		//private DefaultTableModel table;
		
		public ScheduleTable(Object[][] d, String[] c) {
			columnNames = c;
			data = d;
			//table = new DefaultTableModel(data, columnNames);
		}
		//@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		//@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		//@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return data[rowIndex][columnIndex];
		}
		
		public String getColumnName(int c) {
			return columnNames[c];
		}
		
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
		
		public boolean isCellEditable(int row, int col) {
			return true;
		}
		
		public void setValueAt(Object value, int r, int c) {
			data[r][c] = value;
			fireTableDataChanged();
			
			//fireTableCellUpdated(data);
		}
		
		public Object[][] getData() {
			return data;
		}
	}


