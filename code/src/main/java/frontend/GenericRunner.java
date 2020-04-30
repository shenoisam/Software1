package frontend;

import javax.swing.JFrame;

import backend.classes.User;

public class GenericRunner {
   protected EHRRunner r;
   protected JFrame frame;
   private User user;

   public GenericRunner(EHRRunner z) {
      r = z;
      frame = z.getFrame();
   }

   public void logout() {
      r.logout();
   }

   public void displayFrameOpt(GenericEnum g) {
   }

   public User getUser() {
      return user;
   }

   public void setUser(User u) {
      user = u;
   }

}
