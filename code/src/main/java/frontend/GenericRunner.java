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
    * provides a method
    * 
    */
   public abstract void displayFrameOpt(GenericEnum g) {
   }

   public User getUser() {
      return user;
   }

   public void setUser(User u) {
      user = u;
   }

}
