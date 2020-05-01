/*
 * Class derived from Java Hungry: Calendar Implementation: Swing GUI Based Java Program
 * link: https://javahungry.blogspot.com/2013/06/calendar-implementation-gui-based.html
 */

package frontend.provider;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * 
 * Calendar class that stores date information
 * and displays it in a Swing GUI
 *
 */
public class Calendar {
   static JLabel lblMonth;
   static JButton btnPrev, btnNext;
   static JTable tblCalendar;
   static JComboBox<String> cmbYear;
   static Container pane;
   static DefaultTableModel mtblCalendar; // Table model
   static JScrollPane stblCalendar; // The scrollpane
   static JPanel pnlCalendar;
   static int realYear, realMonth, realDay, currentYear, currentMonth;

   public JPanel makeCalander() {
      // Create controls
      lblMonth = new JLabel("January");
      cmbYear = new JComboBox<String>();
      btnPrev = new JButton("Prev");
      btnNext = new JButton("Next");
      mtblCalendar = new DefaultTableModel() {
         private static final long serialVersionUID = -673206566701975821L;

         public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
         }
      };
      tblCalendar = new JTable(mtblCalendar);
      stblCalendar = new JScrollPane(tblCalendar);
      pnlCalendar = new JPanel();

      // Set border
      pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

      // Register action listeners
      btnPrev.addActionListener(new btnPrev_Action());
      btnNext.addActionListener(new btnNext_Action());
      cmbYear.addActionListener(new cmbYear_Action());

      // Add controls to pane
      pnlCalendar.add(lblMonth);
      pnlCalendar.add(cmbYear);
      
      // creating a panel to make sure that the buttons are aligned
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
      buttonPanel.add(btnPrev);
      buttonPanel.add(btnNext);
      
      // adding the button panel to the main panel
      pnlCalendar.add(buttonPanel);
      pnlCalendar.add(stblCalendar);

      // Set bounds
      pnlCalendar.setPreferredSize(new Dimension(100, 75));
      lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 100, 25);
      cmbYear.setBounds(23, 35, 80, 20);
      btnPrev.setBounds(10, 25, 50, 25);
      btnNext.setBounds(260, 25, 50, 25);
      stblCalendar.setPreferredSize(new Dimension(200, 110));
      
      // Get real month/year
      GregorianCalendar cal = new GregorianCalendar(); // Create calendar
      realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); // Get day
      realMonth = cal.get(GregorianCalendar.MONTH); // Get month
      realYear = cal.get(GregorianCalendar.YEAR); // Get year
      currentMonth = realMonth; // Match month and year
      currentYear = realYear;

      // Add headers
      String[] headers = { "S", "M", "T", "W", "Th", "F", "S" }; // All headers
      for (int i = 0; i < 7; i++) {
         mtblCalendar.addColumn(headers[i]);
      }

      // creating the 
      tblCalendar.getParent().setBackground(tblCalendar.getBackground()); // Set background

      // No resize/reorder
      tblCalendar.getTableHeader().setResizingAllowed(false);
      tblCalendar.getTableHeader().setReorderingAllowed(false);

      // Single cell selection
      tblCalendar.setColumnSelectionAllowed(true);
      tblCalendar.setRowSelectionAllowed(true);
      tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Set row/column count
      tblCalendar.setRowHeight(15);
      mtblCalendar.setColumnCount(7);
      mtblCalendar.setRowCount(6);

      // Populate table
      for (int i = realYear - 100; i <= realYear + 100; i++) {
         cmbYear.addItem(String.valueOf(i));
      }

      // Refresh calendar
      refreshCalendar(realMonth, realYear); // Refresh calendar
      
      // returning the calander pane
      return pnlCalendar;
   }

   /**
    * 
    * @param month
    * @param year
    */
   public static void refreshCalendar(int month, int year) {
      // Variables
      String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
      int nod, som; // Number Of Days, Start Of Month

      // Allow/disallow buttons
      btnPrev.setEnabled(true);
      btnNext.setEnabled(true);
      if (month == 0 && year <= realYear - 10) {
         btnPrev.setEnabled(false);
      } // Too early
      if (month == 11 && year >= realYear + 100) {
         btnNext.setEnabled(false);
      } // Too late
      lblMonth.setText(months[month]); // Refresh the month label (at the top)
      lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 180, 25); // Re-align label with calendar
      cmbYear.setSelectedItem(String.valueOf(year)); // Select the correct year in the combo box

      // Clear table
      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 7; j++) {
            mtblCalendar.setValueAt(null, i, j);
         }
      }

      // Get first day of month and number of days
      GregorianCalendar cal = new GregorianCalendar(year, month, 1);
      nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
      som = cal.get(GregorianCalendar.DAY_OF_WEEK);

      // Draw calendar
      for (int i = 1; i <= nod; i++) {
         int row = new Integer((i + som - 2) / 7);
         int column = (i + som - 2) % 7;
         mtblCalendar.setValueAt(i, row, column);
      }

      // Apply renderers
      tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
   }

   static class tblCalendarRenderer extends DefaultTableCellRenderer {
      public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
            int row, int column) {
         super.getTableCellRendererComponent(table, value, selected, focused, row, column);
         if (column == 0 || column == 6) { // Week-end
            setBackground(new Color(255, 220, 220));
         } else { // Week
            setBackground(new Color(255, 255, 255));
         }
         if (value != null) {
            if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear) { // Today
               setBackground(new Color(220, 220, 255));
            }
         }
         setBorder(null);
         setForeground(Color.black);
         return this;
      }
   }

   static class btnPrev_Action implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (currentMonth == 0) { // Back one year
            currentMonth = 11;
            currentYear -= 1;
         } else { // Back one month
            currentMonth -= 1;
         }
         refreshCalendar(currentMonth, currentYear);
      }
   }

   static class btnNext_Action implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (currentMonth == 11) { // Foward one year
            currentMonth = 0;
            currentYear += 1;
         } else { // Foward one month
            currentMonth += 1;
         }
         refreshCalendar(currentMonth, currentYear);
      }
   }

   static class cmbYear_Action implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (cmbYear.getSelectedItem() != null) {
            String b = cmbYear.getSelectedItem().toString();
            currentYear = Integer.parseInt(b);
            refreshCalendar(currentMonth, currentYear);
         }
      }
   }
}
