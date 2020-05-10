package frontend.provider.Components;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import backend.classes.*;
import frontend.provider.ProviderRunner;

public class TopBarProviderHomescreen {
	public static void addTopBar(Container pane, ProviderRunner p,List<Appointment> li) {
		 // creating the top panel to store all the information
	      JPanel topPanel = new JPanel();
	      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

	      // creating the buttonPanel with the Home and Logout buttons
	      JPanel buttonPanel = TopBarMenuItems.addMenuItems(p);
	      topPanel.add(buttonPanel);

	      // creating the panel with the provider's name
	      JPanel namePanel = new JPanel();
	      namePanel.setBorder(BorderFactory.createTitledBorder(""));
	      namePanel.setPreferredSize(new Dimension(500, 50));
	      namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
	      JLabel welcome = new JLabel("Welcome, ");
	      welcome.setFont(welcome.getFont().deriveFont(25f));
	      namePanel.add(welcome);
	      JLabel staffName = new JLabel();
	      staffName.setText(p.getUser().getFullName());
	      staffName.setFont(staffName.getFont().deriveFont(25f));
	      namePanel.add(staffName);

	      // creating and adding an invisible panel to push out the appointment times
	      JPanel invisible = new JPanel();
	      namePanel.add(invisible);

	      // creating the appointment time and location
	      JLabel nextAppointmentTitle = new JLabel();
	      nextAppointmentTitle.setText("Your Next Appointment is at: ");
	      JLabel appointmentTime = new JLabel();
	      if (li != null &&  li.size() > 0) {
	    	  appointmentTime.setText(li.get(0).getAppointmentDate().toString());
	      }else {
	    	  appointmentTime.setText("");
	      }
	     

	      // adding the time and location to the name panel
	      namePanel.add(nextAppointmentTitle);
	      namePanel.add(appointmentTime);
	      // namePanel.add(appointmentLocation);

	      // adding the name panel to 4the main panel
	      topPanel.add(namePanel);

	      // adding the top Panel to the container that was passed in to the function
	      pane.add(topPanel, BorderLayout.NORTH);
	}

}
