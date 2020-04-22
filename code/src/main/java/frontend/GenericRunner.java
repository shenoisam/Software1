package frontend;

import javax.swing.JFrame;

public class GenericRunner {
	protected EHRRunner r; 
	protected JFrame frame; 
	public GenericRunner(EHRRunner z) {
		r = z;
		frame = z.getFrame(); 
	}
	public void logout() {
		r.logout(); 
		
	}
	public void displayFrameOpt(GenericEnum g) {
	}

}
