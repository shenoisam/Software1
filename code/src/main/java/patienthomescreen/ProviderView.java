package patienthomescreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import cshare.TestOrder;

public class ProviderView extends GenericScreen {
	public ProviderView(JFrame frame) {
		super(frame, "Provider View");
		setTopBar();
		setSideBar();
		setMainPanel();
	}

	protected void setTopBar() {
		JPanel namePanel = new JPanel();
	    namePanel.setBorder(BorderFactory.createTitledBorder(""));
	    namePanel.setPreferredSize(new Dimension(500, 50));
	    namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
	    
	    JLabel staffName = new JLabel();
	    staffName.setText("<Patient Name>");
	    namePanel.add(staffName);
	    
	    Dimension minSize = new Dimension(5, 50);
	    Dimension prefSize = new Dimension(5, 50);
	    Dimension maxSize = new Dimension(Short.MAX_VALUE, 50);
	    namePanel.add(new Box.Filler(minSize, prefSize, maxSize));

	    
	    JPanel infoLabel = new JPanel();
	    infoLabel.setLayout(new GridLayout(2,3));
	    
	    JLabel sex = new JLabel();
	    JLabel dob = new JLabel();
	    JLabel pcp = new JLabel();
	    
	    infoLabel.add(new JLabel("Sex"));
	    infoLabel.add(new JLabel("DOB"));
	    infoLabel.add(new JLabel("PCP"));
	    
	    infoLabel.add(sex);
	    infoLabel.add(dob);
	    infoLabel.add(pcp);
	    
	    namePanel.add(infoLabel);
	    
	    this.titlePanel.add(namePanel);
	}
	
	
	protected void setSideBar() {
		sidePanel.setLayout(new GridLayout(6, 0));
		sidePanel.setPreferredSize(new Dimension(150, sidePanel.getHeight()));
		
		JButton patientOverviewButton = new JButton("Patient Overview");
		sidePanel.add(patientOverviewButton);
		
		JButton patientVisitButton = new JButton("Patient Visit");
		sidePanel.add(patientVisitButton);
		
		JButton prescribeButton = new JButton("Prescribe");
		sidePanel.add(prescribeButton);
		
		JButton reqTestButton = new JButton("Request Test");
		sidePanel.add(reqTestButton);
		
		JButton viewTestButton = new JButton("View Test Result");
		sidePanel.add(viewTestButton);
		
		JButton referralButton = new JButton("Referral");
		sidePanel.add(referralButton);
		
		
	}

	protected void setMainPanel() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));		
		
		PatientTestTableModel ptModel = new PatientTestTableModel(new ArrayList<TestOrder>());
		JTable testTable = new JTable();
		testTable.setModel(ptModel);
		JScrollPane scrollPane = new JScrollPane(testTable);
		mainPanel.add(scrollPane);
		
		JLabel label = new JLabel("Information");
		label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		label.setOpaque(true);
		
		JPanel pane = new JPanel();
		pane.setOpaque(true);
		SpringLayout sl = new SpringLayout();
		sl.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, pane);
		sl.putConstraint(SpringLayout.EAST, label, -5, SpringLayout.EAST, pane);
		sl.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, pane);
		pane.setLayout(sl);
		pane.setPreferredSize(new Dimension(10, 100));
		pane.add(label);
		
		mainPanel.add(pane);
	}
}
