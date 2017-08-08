package l2kstudios.gme.swing.gameinterface;

import java.awt.Graphics;
import java.util.Set;

import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.path.PathUtil;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class MovePlacementInterface extends TurnInterfaceBase implements ActionPlacementInterface {
	
	private Unit actingUnit;
	private Space originalUnitSpace;
	private Set<PlayingGridSpace> moveableSpaces;
	private PlayingGrid playingGrid;
	private View view;

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
	
	public void initialize() {
		playingGrid = turn.getPlayingGrid();
		actingUnit = turn.getActingUnit();
		cursor = new BoundedCursor(playingGrid, actingUnit);		
		moveableSpaces = new PathUtil().moveableSpaces(actingUnit);
		view = new ActionPlacementView(this);
	}

	@Override
	public Set<PlayingGridSpace> getChooseableSpaces() {
		return moveableSpaces;
	}

	@Override
	public Position getCursorPosition() {
		return cursor.getPosition();
	}
	
}
