package frontend.provider.Components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import frontend.GenericEnum;
import frontend.provider.ProviderRunner;

public class TopBarMenuItems {
  public static JPanel addMenuItems(ProviderRunner p) {
	  JPanel buttonPanel = new JPanel();
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
      return buttonPanel;

   }
}
