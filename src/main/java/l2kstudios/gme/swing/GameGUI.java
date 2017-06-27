package l2kstudios.gme.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameGUI extends JApplet {
	

	public void init() {
		GamePanel gamePanel = new GamePanel(); 
		Container contentPane = getContentPane();
		contentPane.add(BorderLayout.CENTER, gamePanel);
		gamePanel.grabFocus();
	}
	
}
