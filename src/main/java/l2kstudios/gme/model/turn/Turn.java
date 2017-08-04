package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public class Turn {
	
	private PlayingGrid playingGrid;
	private Unit actingUnit;
	
	private RevertActionStack revertActionStack;
	
	private TurnPhaseSequence phaseSequence;	
	
	private Class bufferedActionType;
	
	{
		revertActionStack = new RevertActionStack();
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
	}
	
	public Unit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}

	public Class getBufferedActionType() {
		return bufferedActionType;
	}

	public void setBufferedActionType(Class bufferedActionType) {
		this.bufferedActionType = bufferedActionType;
	}
	
}
