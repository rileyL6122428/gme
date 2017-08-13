package l2kstudios.gme.swing.gameinterface.turn;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.ActionFactory;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Conciousness;
import l2kstudios.gme.model.unit.Unit;

public class ComputerPlayer {
	
	private Unit actingUnit;
	private PlayingGrid playingGrid;
	
	public void completeTurn() {
		moveUnit();
		placePostMoveAction();
	}

	private void moveUnit() {
		Conciousness conciousness = actingUnit.getConciousness();
		Space targetMoveSpace = conciousness.getMoveSpace();
		actingUnit.moveTo(targetMoveSpace);
	}

	private void placePostMoveAction() {
		ActionFactory actionFactory = new ActionFactory();
		actionFactory.setPlayingGrid(playingGrid);
		
		Conciousness conciousness = actingUnit.getConciousness();
		Class actionInstance = conciousness.getPostMoveActionInstanceClass();
		Action action = actionFactory.instantiateAction(actingUnit, actionInstance);
		
		action.setSpaceToExecuteAt(conciousness.getPostMoveActionSpace());
	}

	public Unit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
	
}
