package l2kstudios.gme.swing.gameinterface;

import java.awt.Graphics;
import java.util.Set;

import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.path.PathUtil;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;

public class MovePlacementInterface extends TurnInterfaceBase {
	
	private Turn turn;
	private Unit actingUnit;
	private Space originalUnitSpace;
	private Set<PlayingGridSpace> moveableSpaces;
	private PlayingGrid playingGrid;
	private MovePlacementView view;

	@Override
	public void draw(Graphics drawingCtx) {
		view.draw(drawingCtx);
	}

	@Override
	public PhaseProgressionFlag select() {
		if(unitCanMoveToCursorPosition()) {
			moveUnit();
			return PhaseProgressionFlag.ADVANCE;
			
		} else {			
			return PhaseProgressionFlag.STAND_BY;
		}
	}
	
	private void moveUnit() {
		originalUnitSpace = actingUnit.getOccupiedSpace();
		
		turn.takeAction(
			this::moveUnitToCursorPosition, 
			this::moveUnitBackToOriginalPosition
		);
	}
	
	private void moveUnitToCursorPosition() {
		actingUnit.moveTo(playingGrid.getSpaceAt(getCursorX(), getCursorY()));
	}
	
	private void moveUnitBackToOriginalPosition() {
		actingUnit.moveTo(originalUnitSpace);
	}
	
	private boolean unitCanMoveToCursorPosition() {
		return moveableSpaces.contains(playingGrid.getSpaceAt(getCursorX(), getCursorY()));
	}
	
	private int getCursorX() {
		return cursor.getPosition().getX();
	}
	
	private int getCursorY() {
		return cursor.getPosition().getY();
	}

	public Turn getTurn() {
		return turn;
	}
	
	public void setTurn(Turn turn) {
		this.turn = turn;
	}
	
	public void afterPropertiesSet() {
		playingGrid = turn.getPlayingGrid();
		actingUnit = turn.getActingUnit();
		cursor = new BoundedCursor(playingGrid, actingUnit);		
		moveableSpaces = new PathUtil().moveableSpaces(actingUnit);
		view = new MovePlacementView(cursor, moveableSpaces);
	}
	
}
