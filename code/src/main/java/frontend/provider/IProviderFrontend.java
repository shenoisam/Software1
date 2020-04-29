package frontend.provider;

import javax.swing.JFrame;

import backend.classes.Patient;

public interface IProviderFrontend {
	public void createAndShowGUI(JFrame frame);
	
	public void createAndShowGUI(JFrame frame, Patient pat);


}
