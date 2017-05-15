package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.grid.TwoDimensionalGrid;

public class InputDispatcher implements InitializingBean {
	
	public enum Input { UP, RIGHT, LEFT, DOWN, SPACE, BACK }
	
	private RectangularGrid playingGrid;
	
	private RectangularGrid actionMenu;

	private RectangularGrid selectedGrid;
	
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
				selectedGrid.moveCursorDown();
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

	public void setActionMenu(TwoDimensionalGrid actionMenu) {
		this.actionMenu = actionMenu;
	}

	public void setPlayingGrid(TwoDimensionalGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public void setSelectedGrid(TwoDimensionalGrid selectedGrid) {
		this.selectedGrid = selectedGrid;
	}
	
	@Override
	public void afterPropertiesSet() {
		selectedGrid = playingGrid;
		selectedGrid.initialize();
	}
}
