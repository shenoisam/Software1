package providerfrontend;

public class ProviderRunner {
   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           ProviderHomescreen p = new ProviderHomescreen();
           p.createAndShowProviderHomescreen();
        }
      });

    }
}
