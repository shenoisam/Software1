package providerfrontend;

public class ProviderRunner {
   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           /*ProviderPatientOverview p = new ProviderPatientOverview();
           ProviderPatientOverview.createAndShowProviderPatientOverview();*/
           
           /*ProviderHomescreen p = new ProviderHomescreen();
           p.createAndShowProviderHomescreen();*/
           
           /*ProviderPatientVisit p = new ProviderPatientVisit();
           p.createAndShowProviderPatientVisit();*/
           
           ProviderPrescribeView p = new ProviderPrescribeView();
           p.createAndShowProviderPrescribeView();
        }
      });

    }
}
