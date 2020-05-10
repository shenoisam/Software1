package frontend.provider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.classes.Patient;
import businesslayer.ProviderService;
import frontend.GenericEnum;
import frontend.provider.Components.TopBarPatientInformation;

/**
 * PrivderFrontend class that displays manages the provider's
 * GUI
 *
 */
public class ProviderFrontend implements IProviderGeneric {
   static ProviderRunner p;
   protected static ProviderService serv;

   public ProviderFrontend(ProviderRunner p) {
      this.p = p;
      serv = new ProviderService();
      // TODO Auto-generated constructor stub
   }

   /**
    * 
    * @param pane
    * @param pat
    */
   protected static void providerSideBar(Container pane, Patient pat) {
      // creating the whole side panel
      JPanel sidePanel = new JPanel();
      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
      sidePanel.setBorder(BorderFactory.createTitledBorder(""));

      // creating the button panel to organize the location of the buttons
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
      JButton button = new JButton("Patient Overview");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            p.displayFrameOpt(GenericEnum.POVERVIEW, pat);
         }
      });
      buttonPanel.add(button);
      
      button = new JButton("Patient Visit");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            p.displayFrameOpt(GenericEnum.PVISIT, pat);
         }
      });
      buttonPanel.add(button);
      button = new JButton("Prescribe");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            p.displayFrameOpt(GenericEnum.PPRESCRIBE, pat);
         }
      });
      buttonPanel.add(button);
      button = new JButton("Request a Test");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            p.displayFrameOpt(GenericEnum.PTESTREQUEST, pat);
         }
      });
      buttonPanel.add(button);
      button = new JButton("View Test Results");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            p.displayFrameOpt(GenericEnum.PVIEWTEST, pat);
         }
      });

      buttonPanel.add(button);
      button = new JButton("Referrals");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            p.displayFrameOpt(GenericEnum.PREFERRAL, pat);
         }
      });
      buttonPanel.add(button);
      sidePanel.add(buttonPanel);

      // adding the side panel to the layout
      pane.add(sidePanel, BorderLayout.WEST);
   }

   /**
    * 
    * @param buttonPanel
    */
   protected static void topBarMenuItems(JPanel buttonPanel) {
      JButton button = new JButton("Home");

      // Add ActionListener
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            p.displayFrameOpt(GenericEnum.HOME);
         }
      });

      buttonPanel.setLayout(new BorderLayout());
      buttonPanel.add(button, BorderLayout.WEST);

      button = new JButton("Logout");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            p.logout();
         }
      });
      buttonPanel.add(button, BorderLayout.EAST);

   }

   /**
    * 
    * @param pane
    * @param p
    */
   protected static void topBarPatientInformation(Container pane, Patient pat) {
      
      // adding the top Panel to the contianer that was passed in to the function
      pane.add(TopBarPatientInformation.getTopBar(p, pat), BorderLayout.NORTH);
   }

   public void createAndShowGUI(JFrame frame) {
      // TODO Auto-generated method stub

   }

   @Override
   public void createAndShowGUI(JFrame frame, Patient pat) {
      // TODO Auto-generated method stub

   }
}
