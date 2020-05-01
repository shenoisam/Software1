package frontend.provider;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import backend.classes.*;
import businesslayer.CShareObjects;

public class ProviderReferralsView extends ProviderFrontend {

   // Have a list of doctors that we can update based on specility
   List<Doctor> docs;
   private Patient pat;
   private Doctor selectedDoctor;
   private String referralReason;
   private String addedNotes;
   private List<PatientDiagnosis> diags;
   private List<JCheckBox> cb; 

   public ProviderReferralsView(ProviderRunner p) {
      super(p);
      docs = new ArrayList<Doctor>();
      cb = new ArrayList<JCheckBox>(); 
   }

   public ProviderReferralsView(ProviderRunner providerRunner, Patient pat) {
      // TODO Auto-generated constructor stub
      this(providerRunner);
      this.pat = pat;
      cb = new ArrayList<JCheckBox>(); 

   }

   public void patientReferralPanel(Container pane) {
      // creating the main referral panel
      JPanel referralPanel = new JPanel();
      referralPanel.setLayout(new GridLayout(1, 2));

      // creating the left hand side of the page
      JPanel leftPanel = new JPanel();
      leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

      // creating the specality section
      JPanel specialtyPanel = new JPanel();
      specialtyPanel.setBorder(BorderFactory.createTitledBorder("Specialty"));
      JComboBox specalites = new JComboBox(new Object[] { "", "Radiology", "Obstetrics & Gynecology", "Cardiovascular",
            "Anesthesiology", "Orthopaedic Surgery", "Ophthalmology", "Dermatology", "Pediatrics" });

      specialtyPanel.add(specalites);
      leftPanel.add(specialtyPanel);

      // creating the provider section
      JPanel providerPanel = new JPanel();
      providerPanel.setBorder(BorderFactory.createTitledBorder("Provider"));

      /**** Data Retrieve *****/
      String[] fields = {};
      String[] params = {};
      docs = serv.getData(CShareObjects.DOCTOR, fields, params);
      
      /**** THIS IS WHERE I AM HAVING A HARD TIME WITH SETTING THE DOCTOR NAME TO BE DISPLAYED IN THE LETTER*/
      
      JComboBox<String> providers = new JComboBox<String>();
      providers.addItem("");
      
      for (Doctor d : docs) {
         providers.addItem("Dr. " + d.getFullName() + ", " + d.getDoctorTitle());
      }
        
      providerPanel.add(providers);

     
    

      // adding the provider panel to the left panel
      leftPanel.add(providerPanel);

      // creating the additional notes section
      JPanel notes = new JPanel();
      notes.setBorder(BorderFactory.createTitledBorder("Additional Notes"));
      notes.setLayout(new BoxLayout(notes, BoxLayout.Y_AXIS));

      // creating the notes entered text area
      JTextArea notesEntered = new JTextArea(4, 10);
      notesEntered.setText("");
      notesEntered.setEditable(true);
      notesEntered.setLineWrap(true);
      JScrollPane scroll = new JScrollPane(notesEntered);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      notes.add(scroll);
      
    

      // adding the notes to the notes and submit section
      leftPanel.add(notes);

      // adding the left panel to the main panel veiw
      referralPanel.add(leftPanel);

      // creating the right hand side of the page
      JPanel rightPanel = new JPanel();
      rightPanel.setLayout(new GridLayout(2, 1));

      // creating reason for referral panel
      JPanel reason = new JPanel();
      reason.setBorder(BorderFactory.createTitledBorder("Reason For Referral"));
      reason.setLayout(new BoxLayout(reason, BoxLayout.Y_AXIS));

      /***** Data retrieval ******/
      String[] fields2 = { "PatientID" };
      String[] params2 = { pat.getID() };
      diags = serv.getData(CShareObjects.PATIENTDIAGNOSIS, fields2, params2);

      for (PatientDiagnosis pd : diags) {
         reason.add(createDiagnosis(pd));
      }
      JCheckBox other = new JCheckBox("Other (input reason below)");
      other.setSelected(false);
      reason.add(other);
      JTextArea otherReason = new JTextArea(1, 5);
      otherReason.setEditable(true);
      reason.add(otherReason);

      // adding invisible panels for formating
      reason.add(new JPanel());
      reason.add(new JPanel());
      reason.add(new JPanel());
      reason.add(new JPanel());

      // adding the reason for referral to the right panel
      rightPanel.add(reason);

      // creating the refer button
      JPanel refferButtonPanel = new JPanel();
      refferButtonPanel.setLayout(new BoxLayout(refferButtonPanel, BoxLayout.LINE_AXIS));
      refferButtonPanel.add(new JPanel());

      // creating the new referral button
      JButton refer = new JButton("Refer");

      refer.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	addedNotes = notesEntered.getText();
        	
        	for(JCheckBox b: cb) {
        		if(b.isSelected()) {
        			System.out.println(b.getText());
        			referralReason  += b.getText() + ",";
        		}
        	}
        	
        	 // CURRENTLY NOT RETURNING ANYTHING
            int ndx = providers.getSelectedIndex();
          
            if(ndx > 0) {
          	  ndx = ndx -1;
          	  selectedDoctor = docs.get(ndx);    
            }else {
          	  selectedDoctor = docs.get(0);
            }
            
        	
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            JPanel parent = new JPanel();
            int result = fileChooser.showSaveDialog(parent);
            File save = fileChooser.getSelectedFile();
            Writer writer = null;

            try {
               // open the file
               // write to the file
               // close the file
               writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(save), "utf-8"));
               
               writer.write(referalLetter());
               
               writer.close();
               
            } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            } 
         }
      });

      refferButtonPanel.add(refer);
      refferButtonPanel.add(new JPanel());

      // adding the submit panel to the notes and submit panel
      rightPanel.add(refferButtonPanel);

      // adding the right panel to the main referral page
      referralPanel.add(rightPanel);

      // adding the referral panel to the passed in container
      pane.add(referralPanel);
   }

   private JCheckBox createDiagnosis(PatientDiagnosis d) {
      JCheckBox daignosis1 = new JCheckBox(d.getName());
      cb.add(daignosis1);
      daignosis1.setSelected(false);
      return daignosis1;
   }

   public void createAndShowGUI(JFrame frame) {
      // creating the panes within the screen
      providerSideBar(frame.getContentPane(), pat);
      topBarPatientInformation(frame.getContentPane(), pat);
      patientReferralPanel(frame.getContentPane());

   }

   public void createAndShowGUI(JFrame frame, Patient pat) {
      this.pat = pat;
      createAndShowGUI(frame);
   }

   private String referalLetter() {
	   System.out.println(p.getUser().getFirstName());
      String letter = "Dear Dr. " + selectedDoctor.getFullName() + ",\n\n" + pat.getFullName()  + ", was recently evaluated in our office. " + pat.getFirstName()
            + " currently has a diagnosis of ";
      
      // this lists all of the diagnosises
      for (PatientDiagnosis d : diags) {
         letter += d.getName() + " ";
      }
      
      letter += "\n\nWe are referring this patient for "
            + referralReason + ". We have discussed possible treatment options should " + pat.getFirstName()
            + " require treatment. \n\nI look forward to working with you directly in the treatment of " + pat.getFirstName() + ". "
            + "Please do not hesitate to contact me directly with any questions "
            + "or comments you may have concerning their care. " + "\n\nSincerely,\nDr." + p.getUser().getFirstName() + " " + p.getUser().getLastName()
            +"\n\nAdditional Notes: None" + addedNotes + "\n";

      return letter;

   }

}
