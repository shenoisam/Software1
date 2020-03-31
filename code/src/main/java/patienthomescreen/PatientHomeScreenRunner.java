package patienthomescreen;

import javax.swing.JFrame;

public class PatientHomeScreenRunner {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		GenericScreen phsFrame = new PatientHome(frame);
		
		frame.pack();
		frame.setVisible(true);

	}

}
