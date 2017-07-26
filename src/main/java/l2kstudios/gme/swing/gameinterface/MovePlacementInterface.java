package l2kstudios.gme.swing.gameinterface;

import java.awt.Graphics;
import java.util.Set;

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
	

	@Override
	public void draw(Graphics drawingCtx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseProgressionFlag select() {
		if(unitCanMoveToCursorPosition()) {
			originalUnitSpace = actingUnit.getOccupiedSpace();
			
			turn.takeAction(
				this::moveUnitToCursorPosition, 
				this::moveUnitBackToOriginalPosition
			);
			
			return PhaseProgressionFlag.ADVANCE;
		}
		
		return PhaseProgressionFlag.STAND_BY;
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

	public void afterPropertiesSet() {
		playingGrid = turn.getPlayingGrid();
		actingUnit = turn.getActingUnit();
		cursor.setPosition(actingUnit.getPosition());
		moveableSpaces = new PathUtil().moveableSpaces(actingUnit);
	}
	
	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}
	
}
