package frontend;

import javax.swing.JFrame;

import backend.classes.User;
/**
 * Generic Runner that runs the view for a particular user type (Doctor, Staff, Patient)
 * 
 * 
 * @author samshenoi
 * 
 */
public class GenericRunner {
   protected EHRRunner r;
   protected JFrame frame;
   private User user;

   /**
    * Generic constructor. Inits the object
    * 
    * @param z an EHRRunner 
    */
   public GenericRunner(EHRRunner z) {
      r = z;
      frame = z.getFrame();
   }

   /**
    * Logs the user out of this screen
    * 
    */
   public void logout() {
      r.logout();
   }

   /**
    * provides a method to change screen. Overriden by the concrete runners 
    * 
    * 
    * @param g A GenericEnum to show which screen to go to 
    * 
    */
   public void displayFrameOpt(GenericEnum g) {
   }

   /**
    * returns the user that is logged in
    * 
    * @return the user that is logged in 
    */
   public User getUser() {
      return user;
   }

   
   /**
    * sets a user to be the logged in user
    * 
    * @param u the user that is logged in
    */
   public void setUser(User u) {
      user = u;
   }

}
