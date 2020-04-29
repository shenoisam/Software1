package frontend;

import javax.swing.JFrame;

import backend.classes.User;

public class GenericRunner {
	protected EHRRunner r; 
	protected JFrame frame; 
	protected User user; 
	
	public GenericRunner(EHRRunner z) {
		r = z;
		frame = z.getFrame(); 
	}
	public void logout() {
		r.logout(); 
		
	}
	public void displayFrameOpt(GenericEnum g) {
	}
	protected User getUser() {
		return this.user; 
	}
	
	public void setUser(User u) {
		user = u; 
	}

}
