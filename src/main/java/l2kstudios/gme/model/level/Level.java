package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnFactory;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.model.grid.AttackOptions;
import l2kstudios.gme.model.grid.AttackPlacement;
import l2kstudios.gme.model.grid.PlayingGrid;

public class Level implements Interactable, InitializingBean {
	
	private PlayingGrid playingGrid;
	
	private PostMoveDecisionMenu actionMenu;
	
	private AttackOptions attackOptions;
	
	private AttackPlacement attackPlacement;
	
	protected ActingUnitTracker actingUnitTracker;
	
	private RectangularGrid selectedGrid;
	
	private Turn currentTurn;

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public PostMoveDecisionMenu getActionMenu() {
		return actionMenu;
	}

	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public AttackOptions getAttackOptions() {
		return attackOptions;
	}
	
	public AttackPlacement getAttackPlacement() {
		return attackPlacement;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setupActingUnitTracker();
		playingGrid.setActingUnitTracker(actingUnitTracker);
		setupActionMenu();
		setupAttackOptionsMenu();
		setupAttackPlacementGrid();
		selectedGrid = playingGrid;
		selectedGrid.initialize();
		
		currentTurn = TurnFactory.newTurn(this);
	}

	private void setupActingUnitTracker() {
		actingUnitTracker = new ActingUnitTracker();
		actingUnitTracker.configureMovementCycle(playingGrid.getUnits());
	}
	
	private void setupActionMenu() {
		actionMenu = new PostMoveDecisionMenu();
		actionMenu.setActingUnitTracker(actingUnitTracker);
	}
	
	private void setupAttackOptionsMenu() {
		attackOptions = new AttackOptions();
		attackOptions.setActingUnitTracker(actingUnitTracker);
	}
	
	private void setupAttackPlacementGrid() {
		attackPlacement = new AttackPlacement();
		attackPlacement.setSpaces(playingGrid.getSpaces());
		attackPlacement.setActingUnitTracker(actingUnitTracker);
	}

	@Override
	public void receiveInput(Input input) {
		
		if(currentTurn.isFinished()) {
			currentTurn = TurnFactory.newTurn(this);
		} else {
			currentTurn.receiveInput(input);
		}
		
//		switch(input) {
//		case UP:    
//			selectedGrid.moveCursorUp(); 
//			break;
//		case RIGHT: 
//			selectedGrid.moveCursorRight(); 
//			break;
//		case LEFT:
//			selectedGrid.moveCursorLeft();
//			break;
//		case DOWN:
//			selectedGrid.moveCursorDown();
//			break;
//		case SPACE:
//			if(selectedGrid.select()) selectNextGrid();
//			break;
//		case BACK:
//			
//			System.out.println("BACK INPUT RECEIVED");
//		}
		
	}
	
//	private void selectNextGrid() {
//		Unit actingUnit = getActingUnitTracker().getActingUnit();
//		
//		if(selectedGrid == playingGrid) {
//			selectedGrid = actionMenu;
//		} else if(actingUnit.isChoosingAttack()) {
//			selectedGrid = attackOptions;
//		} else if(actingUnit.isPlacingAttack()) {
//			selectedGrid = attackPlacement; 
//		} else if(actingUnit.isMoving()) {  
//			selectedGrid = playingGrid;
//		}
//		
//		selectedGrid.initialize();
//	}

}
