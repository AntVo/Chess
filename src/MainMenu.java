
import java.awt.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;


public class MainMenu extends JPanel {

		
	public void initializeMainMenu() {
		MainMenu frame = new MainMenu();
		frame.setVisible(true);
	}
	
	
	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setLayout(null);
		setBounds(new Rectangle(0, 0, 600, 600));
		
		JButton playButton = new JButton("");
		playButton.setBorder(null);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setBorder(new MatteBorder(7, 7, 7, 7, (Color) Color.WHITE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setBorder(null);
			}
		});
		playButton.setIcon(new ImageIcon("assets/main/PlayButton.png"));
		playButton.setBounds(188, 354, 223, 74);
		add(playButton);
		
		JButton helpButton = new JButton("");
		helpButton.setBorder(null);
		helpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				helpButton.setBorder(new MatteBorder(7, 7, 7, 7, (Color) Color.WHITE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpButton.setBorder(null);
			}
		});
		helpButton.setIcon(new ImageIcon("assets/main/HelpButton.png"));
		helpButton.setBounds(188, 434, 223, 74);
		add(helpButton);
		
		JButton exitButton = new JButton("");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setBorder(new MatteBorder(7, 7, 7, 7, (Color) Color.WHITE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBorder(null);
			}
		});
		exitButton.setIcon(new ImageIcon("assets/main/ExitButton.png"));
		exitButton.setBounds(188, 514, 223, 74);
		add(exitButton);
		
		JLabel MainMenuBackground = new JLabel("");
		MainMenuBackground.setIcon(new ImageIcon("assets/main/MainMenuBackground.png"));
		MainMenuBackground.setBounds(0, 0, 600, 600);
		add(MainMenuBackground);
		
		
	}
}
