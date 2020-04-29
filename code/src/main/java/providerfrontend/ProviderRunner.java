package providerfrontend;

public class ProviderRunner {
   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           /*ProviderPatientOverview p = new ProviderPatientOverview();
           p.createAndShowProviderPatientOverview();*/
           
           /*ProviderHomescreen p = new ProviderHomescreen();
           p.createAndShowProviderHomescreen();
           
           /*ProviderPatientVisit p = new ProviderPatientVisit();
           p.createAndShowProviderPatientVisit();*/
           
           /*ProviderPrescribeView p = new ProviderPrescribeView();
           p.createAndShowProviderPrescribeView();*/
           
           /*ProviderRequestTestView p = new ProviderRequestTestView();
           p.createAndShowProviderRequestTestView();*/
           
           ProviderReferralsView p = new ProviderReferralsView();
           p.createAndShowProviderReferralsView();
        }
      });

    }
}
