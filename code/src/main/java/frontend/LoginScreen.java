package frontend;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import frontend.staff.GenericStaffScreen;
import frontend.staff.Runner;

public class LoginScreen {
	private EHRRunner r;
	JPasswordField username; 
	JPasswordField password; 
	public LoginScreen(EHRRunner r) {
		this.r = r; 
		
	}
	public void createAndShowGUI(Container pane) {
        JPanel login = new JPanel();
    	
    	username = new JPasswordField();
    	username = new JPasswordField(10);
    	username.setActionCommand("ok");
    	//password.addActionListener(this);
 
        JLabel labelUser = new JLabel("Enter the Username: ");
        labelUser.setLabelFor(username);
        JPanel textPaneUser = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPaneUser.add(labelUser);
        textPaneUser.add(username);
        login.add(textPaneUser);
    	login.add(username);
		//login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
    	password = new JPasswordField();
    	password = new JPasswordField(10);
    	password.setActionCommand("ok");
    	//password.addActionListener(this);
 
        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(password);
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(password);
        login.add(textPane);
    	login.add(password);
		JButton submitButton = new JButton("Submit");
		login.add(submitButton);
		pane.add(login);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String pass = new String(password.getPassword());
				 String user = new String(username.getPassword());
				 System.out.println(pass + " " + user);
				 r.validateUser(user, pass);
				//pane.invalidate();
				//pane.validate();
				//pane.repaint();
			}
		});
		
	
	}
}
