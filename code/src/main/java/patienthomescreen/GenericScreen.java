package patienthomescreen;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GenericScreen {
	protected JFrame frame;
	protected JPanel topPanel;
	protected JPanel titlePanel;
	protected JPanel sidePanel;
	protected JPanel mainPanel;
	
	public GenericScreen(JFrame f, String title) {
		frame = f;
		
		topPanel = new JPanel();
	    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
	    JPanel buttonPanel = new JPanel();
	    JButton button = new JButton("Home");
	    buttonPanel.setLayout(new BorderLayout());
	    buttonPanel.add(button, BorderLayout.WEST);
	    button = new JButton("Logout");
	    buttonPanel.add(button, BorderLayout.EAST); 
	    topPanel.add(buttonPanel);
	    
	    titlePanel = new JPanel();
	    titlePanel.setBorder(BorderFactory.createTitledBorder(""));
	    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
	    topPanel.add(titlePanel);
	    frame.getContentPane().add(topPanel, BorderLayout.NORTH);
	    
	    sidePanel = new JPanel();
	    sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
	    frame.getContentPane().add(sidePanel, BorderLayout.WEST);
	    
	    mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	    frame.getContentPane().add(mainPanel);
	    
	    frame.setTitle(title);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(750, 500));
	    
	}
	
	public void update() {
		setTopBar();
		setSideBar();
		setMainPanel();
	}
	
	protected abstract void setTopBar();
	protected abstract void setSideBar();
	protected abstract void setMainPanel();
	
	
	
}
