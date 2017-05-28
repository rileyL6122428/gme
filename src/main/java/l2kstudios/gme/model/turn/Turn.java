package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.actioninterface.MovementGrid;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.TwoDimensionalGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.unit.Unit;

public class Turn implements Interactable {

	private Transaction transaction = new Transaction();
	
	private boolean finished = false;
	
	private Unit actingUnit;
	
	private PlayingGrid playingGrid;

	private ActionInterface actionInterface;	

	@Override
	public void receiveInput(Input input) {
		switch(input) {
		case UP:    
			actionInterface.moveCursorUp(); 
			break;
		case RIGHT: 
			actionInterface.moveCursorRight(); 
			break;
		case LEFT:
			actionInterface.moveCursorLeft();
			break;
		case DOWN:
			actionInterface.moveCursorDown();
			break;
		case SPACE:
			if(actionInterface.select()) setNextActionInterface();
			break;
		case BACK:
			
			System.out.println("BACK INPUT RECEIVED");
		}
		
	}
	
	private void setNextActionInterface() {
		Action lastSelectedAction = transaction.lastActionInQueue();
		
		if(lastSelectedAction != null && lastSelectedAction.isTurnEnding()) {
			transaction.commit();
			finished = true;
		} else {
			actionInterface = nextActionInterface(lastSelectedAction);
		}
		
	}

	private ActionInterface nextActionInterface(Action action) {
		try {
			ActionInterface actionInterface = (ActionInterface) action.getNextActionInterfaceType().newInstance();
			actionInterface.initialize(this);
			return actionInterface;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isFinished() {
		return transaction.readyToCommit();
	}
	
	public void setActingUnit(Unit unit) {
		this.actingUnit = unit;
	}

	public ActionInterface getCurrentActionInterface() {
		return actionInterface;
	}

	public Unit getActingUnit() {
		return actingUnit;
	}	
	
	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}
	
	public void afterPropertiesSet() {
		actionInterface = new MovementGrid();
		actionInterface.initialize(this);
	}

	public Transaction getTransaction() {
		return transaction;
	}
	
	public Space getTargetSpace() {
		if(transaction.getTargetSpace() != null) {
			return transaction.getTargetSpace();			
		} else {
			return actingUnit.getOccupiedSpace();
		}
	}

	public void commit() {
		transaction.commit();
	}
	
	public void addAction(Action action) {
		transaction.addAction(action);
	}
}
