package l2kstudios.gme;

import l2kstudios.gme.swing.Console;
import l2kstudios.gme.swing.GameGUI;

public class SwingApp {
	
	public static int SCREEN_STARTING_WIDTH = 1290;
	public static int SCREEN_STARTING_HEIGHT = 700;
	
	public static void main(String[] args) {
		Console.run(
				new GameGUI(), 
				SCREEN_STARTING_WIDTH, 
				SCREEN_STARTING_HEIGHT
		);
	}
	
}
