package l2kstudios.gme.level;

import org.springframework.beans.factory.annotation.Autowired;

public class InputDispatcher {
	
	public enum Input { UP, RIGHT, LEFT, DOWN }
	
	@Autowired
	private Grid playingGrid;
	
	public void dispatchInput(Input input) {
		switch(input) {
			case UP:    
				playingGrid.moveCursorBy( 0, -1); 
				break;
			case RIGHT: 
				playingGrid.moveCursorBy( 1,  0); 
				break;
			case LEFT:
				playingGrid.moveCursorBy(-1, 0);
				break;
			case DOWN:
				playingGrid.moveCursorBy(0, 1);
				break;
		}
	}
}
