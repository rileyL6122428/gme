package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import l2kstudios.gme.model.grid.Grid;

public class InputDispatcher implements InitializingBean {
	
	public enum Input { UP, RIGHT, LEFT, DOWN, SPACE, BACK }
	
	@Autowired
	@Qualifier("demoPlayingGrid")
	private Grid playingGrid;
	
	@Autowired
	@Qualifier("demoActionMenu")
	private Grid actionMenu;
	
	private Grid selectedGrid;
	
	public void dispatchInput(Input input) {
		switch(input) {
			case UP:    
				selectedGrid.moveCursorBy( 0, -1); 
				break;
			case RIGHT: 
				selectedGrid.moveCursorBy( 1,  0); 
				break;
			case LEFT:
				selectedGrid.moveCursorBy(-1, 0);
				break;
			case DOWN:
				selectedGrid.moveCursorBy(0, 1);
				break;
			case SPACE:
				selectedGrid.select();
				break;
			case BACK:
				System.out.println("BACK INPUT RECEIVED");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		selectedGrid = playingGrid;
	}
}
