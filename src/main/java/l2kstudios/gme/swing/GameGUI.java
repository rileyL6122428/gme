package l2kstudios.gme.swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;

public class GameGUI extends JApplet {

	public void init() {
		GamePanel gamePanel = new GamePanel();
		Container contentPane = getContentPane();
		contentPane.add(BorderLayout.CENTER, gamePanel);

		GameUpdateThread gameUpdateThread = new GameUpdateThread();
		gameUpdateThread.setGamePanel(gamePanel);
		gameUpdateThread.start();

	}

}
