package frontend.patient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backend.classes.Appointment;
import businesslayer.CShareObjects;
import businesslayer.ProviderService;
import frontend.GenericEnum;

public abstract class GenericScreen {
	protected JFrame frame;
	protected JPanel topPanel;
	protected JPanel titlePanel;
	protected JPanel sidePanel;
	protected JPanel mainPanel;
	protected PatientRunner p;  
	protected ProviderService serv;
	protected Appointment a;
	
	public GenericScreen(JFrame f, String title, PatientRunner po) {
		this.p = po; 
		frame = f;
		
		this.serv = new ProviderService();
		
		topPanel = new JPanel();
	    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
	    JPanel buttonPanel = new JPanel();
	    JButton button = new JButton("Home");
	    button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Modified so that it calls the calling class to switch the screen. 
				//Allows for one method to be used to switch the screens - Sam 
				p.displayFrameOpt(GenericEnum.HOME);
				
			}
			
		});
	    buttonPanel.setLayout(new BorderLayout());
	    buttonPanel.add(button, BorderLayout.WEST);
	    button = new JButton("Logout");
	    button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Modified so that it calls the calling class to switch the screen. 
				//Allows for one method to be used to switch the screens - Sam 
				p.logout();
				
			}
			
		});
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
	    
	    String [] fields = {"PatientID"};
	    String [] params = {p.getUser().getID()};
	    List<Appointment> li = serv.getData(CShareObjects.APPOINTMENT, fields, params);
	    a = li.get(0);
	    
	    frame.setTitle(title);
	    
	}
	
	protected void setSideBar() {
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
		sidePanel.setPreferredSize(new Dimension(150, sidePanel.getHeight()));
		
		JButton intakeFormButton = new JButton("Patient Intake Form");
		
		intakeFormButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Modified so that it calls the calling class to switch the screen. 
				//Allows for one method to be used to switch the screens - Sam 
				p.displayFrameOpt(GenericEnum.INTAKE);
				
			}
			
		});
		
		sidePanel.add(intakeFormButton);
		
		JButton viewTestResButton = new JButton("View Test Result");
		viewTestResButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Modified so that it calls the calling class to switch the screen. 
				//Allows for one method to be used to switch the screens - Sam 
				p.displayFrameOpt(GenericEnum.VIEWTABLE);
				
			}
			
		});
		sidePanel.add(viewTestResButton);
		
	}
	
	
	public void update() {
		setTopBar();
		setSideBar();
		setMainPanel();
	}
	
	protected abstract void setTopBar();
	//protected abstract void setSideBar();
	protected abstract void setMainPanel();
	
	
	
}
