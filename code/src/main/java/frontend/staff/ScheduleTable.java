package frontend.staff;

import javax.swing.table.AbstractTableModel;

public class ScheduleTable extends AbstractTableModel {

   private static final long serialVersionUID = 1L;
   private String[] columnNames = {"Date", "Doctor", "Patient"};
   private Object[][] data = {};
   // private DefaultTableModel table;

   /**
	 * initializes a new instance of a ScheduleTable
	 * 
	 * @param d a 2d array containing data about the schedule
	 * @param c the names of the columns
	 */
   public ScheduleTable(Object[][] d, String[] c) {
      columnNames = c;
      data = d;
      // table = new DefaultTableModel(data, columnNames);
   }

   /**
	 * gets the number of rows
	 * 
	 * @return the number of rows
	 */
   // @Override
   public int getRowCount() {
      // TODO Auto-generated method stub
      return data.length;
   }

   /**
	 * gets the number of columns
	 * 
	 * @return the number of columns
	 */
   // @Override
   public int getColumnCount() {
      // TODO Auto-generated method stub
      return columnNames.length;
   }

   /**
	 * gets the value at a row and column index
	 * 
	 * @param rowIndex the index of the row of the item
	 * @param columnIndex the index of the column of the item
	 * 
	 * @return returns the item at the row index and column index
	 */
   // @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      // TODO Auto-generated method stub
      return data[rowIndex][columnIndex];
   }

   /**
	 * gets the name of a requested index
	 * 
	 * @param c the index of requested column
	 */
   public String getColumnName(int c) {
      return columnNames[c];
   }

   /**
	 * gets if the cell is editable
	 * 
	 * @param row the row of the requested info
	 * @param col the column of the requested info
	 */
   public boolean isCellEditable(int row, int col) {
      return true;
   }

   /**
	 * sets the value at a set of indexes 
	 * 
	 * @param value the item we are adding
	 * @param r the row index of the item
	 * @param c the column index of the item
	 */
   public void setValueAt(Object value, int r, int c) {
      data[r][c] = value;
      fireTableDataChanged();

      // fireTableCellUpdated(data);
   }

   /**
	 * gets all the data in the table
	 * 
	 * @return returns all the data in the table
	 */
   public Object[][] getData() {
      return data;
   }
}
