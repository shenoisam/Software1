package frontend.provider;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import backend.classes.Patient;
import backend.dao.PatientDAO;

public class PatientLookUpScreen {
	
	public PatientLookUpScreen(){
		
	}
	
	public void setMainPanel(Container pane) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		List<Patient> pList = null;
		pList = new PatientDAO().getData(new String[] {}, new String[] {});
		List<String> names = new ArrayList<String>();
		
		pList.stream().forEach(p -> names.add(p.getFullName() + ": " + p.getID()));
		
		StringSearchable searchable = new StringSearchable(names);
	    AutocompleteJComboBox comboBox = new AutocompleteJComboBox(searchable);
	    
	    comboBox.setPreferredSize(new Dimension(50, 100));
		
		panel.add(comboBox);
		
		
		pane.add(panel);		
		
	}
	
	
}
