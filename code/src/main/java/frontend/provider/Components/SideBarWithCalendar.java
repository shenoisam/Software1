package frontend.provider.Components;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import frontend.GenericEnum;
import frontend.provider.Calendar;
import frontend.provider.ProviderRunner;

public class SideBarWithCalendar {
	public static void addSideBar(Container pane, ProviderRunner p) {
		// creating the whole side panel
	      JPanel sidePanel = new JPanel();
	      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
	      sidePanel.setBorder(BorderFactory.createTitledBorder(""));
	      
	      // creating the button panel to organize the location of the buttons
	      JPanel buttonPanel = new JPanel();
	      buttonPanel.setLayout(new GridLayout(3, 1));
	      buttonPanel.setMaximumSize(new Dimension(600, 400));

	      JButton button = new JButton("Today's Schedule");
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            p.displayFrameOpt(GenericEnum.HOME);
	         }
	      });
	      buttonPanel.add(button);

	      button = new JButton("Patient Lookup");
	      button.setVisible(true);
	      
	      button.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	              p.displayFrameOpt(GenericEnum.LOOKUP);
	           }
	        });
	      
	      buttonPanel.add(button);
	      sidePanel.add(buttonPanel);

	      // creating and adding an invisible pane to push down the calander
	      sidePanel.add(new JPanel());

	      // creating the calendar
	      JPanel cPanel = new JPanel();
	      cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
	      JPanel calander = new Calendar().makeCalander();
	      cPanel.add(calander);

	      // adding the calendar panel to the side panel
	      sidePanel.add(cPanel);

	      // adding the side panel to the layout
	      pane.add(sidePanel, BorderLayout.WEST);
	}

}
