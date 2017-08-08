package l2kstudios.gme.model.turn;

import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.ActionFactory;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public class Turn {
	
	private PlayingGrid playingGrid;
	private Unit actingUnit;
	
	private RevertActionStack revertActionStack;
	
	private List<Action> bufferedActionInstances;
	
	private TurnPhaseSequence phaseSequence;
	
	private Action bufferedAction;
	
	private ActionFactory actionFactory;
	
	
	{
		revertActionStack = new RevertActionStack();
		actionFactory = new ActionFactory();
	}
	
	
	public boolean isFinished() {
		return phaseSequence.isFinished();
	}
	
	public void commitActions() {
		revertActionStack.removeCallbacks();
	}
	
	public void takeAction(Runnable action, Runnable undoCallback) {
		action.run();
		revertActionStack.addUndoCallback(undoCallback);
	}
	
	public void revertAction() {
		revertActionStack.undoLastAction();
	}

	public TurnPhaseSequence getPhases() {
		return phaseSequence;
	}
	
	public void setPhaseSequence(TurnPhaseSequence phaseSequence) {
		this.phaseSequence = phaseSequence;
	}
	
	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}
	
	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
		actionFactory.setPlayingGrid(playingGrid);
	}
	
	public Unit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}

	public void bufferActionType(Class actionType) {
		bufferedActionInstances = actionFactory.getPostMoveActions(actingUnit, actionType);
	}
	
	public List<Action> getBufferedActionInstances() {
		return bufferedActionInstances;
	}

	public void clearBufferedActionType() {
		bufferedActionInstances = null;
	}

	public void bufferAction(Action action) {
		this.bufferedAction = action; 
	}
	
	public void clearBufferedAction() {
		bufferedAction = null;
	}

	public Action getBufferedAction() {
		return bufferedAction;
	}
}
