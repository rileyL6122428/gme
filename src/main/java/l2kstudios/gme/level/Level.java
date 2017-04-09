package l2kstudios.gme.level;

import org.springframework.beans.factory.annotation.Autowired;

public class Level {
	
	@Autowired
	private Grid playingGrid;
	
	public Position getCursorPosition() {
		return playingGrid.getCursorPosition();
	}
	
	public int getGridWidth() {
		return playingGrid.getWidth();
	}
	
	public int getGridHeight() {
		return playingGrid.getHeight();
	}
	
}
