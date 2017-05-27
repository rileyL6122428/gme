package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.unit.Unit;

public class Turn implements Interactable {
	
	private ActingUnitTracker actingUnitTracker;
	
	private RectangularGrid playingGrid;
	
	private RectangularGrid actionMenu;

	private RectangularGrid selectedGrid;
	
	private RectangularGrid attackOptions;
	
	private RectangularGrid attackPlacement;

	@Override
	public void receiveInput(Input input) {
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
		Unit actingUnit = actingUnitTracker.getActingUnit();
		
		if(selectedGrid == playingGrid) {
			selectedGrid = actionMenu;
		} else if(actingUnit.isChoosingAttack()) {
			selectedGrid = attackOptions;
		} else if(actingUnit.isPlacingAttack()) {
			selectedGrid = attackPlacement; 
		} else if(actingUnit.isMoving()) {  
			selectedGrid = playingGrid;
		}
		
		selectedGrid.initialize();
	}
	
}
