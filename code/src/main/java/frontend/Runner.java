package frontend;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Runner {
    
    public static void buttonAdder(Container pane) {
    	JPanel panel = new JPanel(); 
    	
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        
        JPanel topPanel = new JPanel();
  
        JButton button = new JButton("Home");
        
        topPanel.add(button);
        
        button = new JButton("Logout");
        
        topPanel.add(button);
        
        pane.add(topPanel, BorderLayout.PAGE_START);
         
        button = new JButton("Manage Billing");
        panel.add(button);
        
        button = new JButton("Scheduling");
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.add(new JButton("Hello"));
				frame.getContentPane().doLayout();
				frame.update(frame.getGraphics());
			}
        	
        });
        panel.add(button);
        
        button = new JButton("View Patient Records");
        panel.add(button);
        
        button = new JButton("Calendar will eventually go here...");
        panel.add(button);
        
        pane.add(panel, BorderLayout.WEST);
 
    }
    static JFrame frame;
	private static void createAndShowGUI() {
		/*JFrame*/ frame = new JFrame("EHR Staff Homescreen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(500, 500);
		frame.setPreferredSize(new Dimension(800, 500));
		
		// Can't figure this out yet...
		/*JTextArea StaffName = new JTextArea();
		StaffName.setText("Staff Name Here");
		frame.getContentPane().add(StaffName, BorderLayout.CENTER);*/
		
		JPanel middleOfScreen = new JPanel();
		middleOfScreen.setLayout(new BoxLayout(middleOfScreen, BoxLayout.Y_AXIS)); 
		
		TableWrap table = new TableWrap();
		table.setOpaque(true);
		
		JTextArea aboutPatient = new JTextArea();
		aboutPatient.setText("About the patient goes here, get from database?");
		
		middleOfScreen.add(table, BorderLayout.CENTER);
		
		middleOfScreen.add(aboutPatient, BorderLayout.CENTER);
		
		frame.getContentPane().add(middleOfScreen);
		
		buttonAdder(frame.getContentPane());
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

}
