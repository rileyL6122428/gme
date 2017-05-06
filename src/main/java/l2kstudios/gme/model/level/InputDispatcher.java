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
				selectedGrid.moveCursorUp(); 
				break;
			case RIGHT: 
				selectedGrid.moveCursorRight(); 
				break;
			case LEFT:
				selectedGrid.moveCursorLeft();
				break;
			case DOWN:
				selectedGrid.moveCursorRight();
				break;
			case SPACE:
				if(selectedGrid.select()) toggleSelectedGrid();
				break;
			case BACK:
				System.out.println("BACK INPUT RECEIVED");
		}
	}

	private void toggleSelectedGrid() {
		if(selectedGrid == playingGrid)
			selectedGrid = actionMenu;
		else
			selectedGrid = playingGrid;
		
		selectedGrid.initialize();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		selectedGrid = playingGrid;
	}
}
