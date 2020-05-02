package frontend.provider;

import javax.swing.JFrame;

import backend.classes.Patient;

/**
 * IProviderGeneric interface that outlines what a provider
 * screen will do
 *
 */
public interface IProviderGeneric {
	public void createAndShowGUI(JFrame frame);
	
	public void createAndShowGUI(JFrame frame, Patient pat);


}
