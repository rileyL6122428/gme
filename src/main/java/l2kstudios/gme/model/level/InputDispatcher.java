package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.AttackOptions;
import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.grid.TwoDimensionalGrid;
import l2kstudios.gme.model.unit.Unit;

public class InputDispatcher implements InitializingBean {
	
	public enum Input { UP, RIGHT, LEFT, DOWN, SPACE, BACK }
	
	private ActingUnitTracker actingUnitTracker;
	
	private RectangularGrid playingGrid;
	
	private RectangularGrid actionMenu;

	private RectangularGrid selectedGrid;
	
	private RectangularGrid attackOptions;
	
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
				if(selectedGrid.select()) selectNextGrid();
				break;
			case BACK:
				System.out.println("BACK INPUT RECEIVED");
		}
	}

	private void selectNextGrid() {
		Unit actingUnit = getActingUnitTracker().getActingUnit();
		
		if(selectedGrid == playingGrid) {
			selectedGrid = actionMenu;
		} else if(actingUnit.isChoosingAttack()) {
			selectedGrid = attackOptions;
		} else if(actingUnit.isMoving()) {
			selectedGrid = playingGrid;
		}
		
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
	
	public void setAttackOptions(AttackOptions attackOptions) {
		this.attackOptions = attackOptions;
	}
	
	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}

	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}

	@Override
	public void afterPropertiesSet() {
		selectedGrid = playingGrid;
		selectedGrid.initialize();
	}

}
