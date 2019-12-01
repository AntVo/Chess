import javax.swing.JPanel;


import java.awt.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;


public class Help extends JPanel {

		
	public void initializeMainMenu() {
		Help frame = new Help();
		frame.setVisible(true);
	}
	
	
	/**
	 * Create the panel.
	 */
	public Help() {
		setLayout(null);
		setBounds(new Rectangle(0, 0, 600, 600));
		
		JLabel MainMenuBackground = new JLabel("");
		MainMenuBackground.setIcon(new ImageIcon("assets/main/HelpBackground.png"));
		MainMenuBackground.setBounds(0, 0, 600, 600);
		add(MainMenuBackground);
		
		
	}
}
