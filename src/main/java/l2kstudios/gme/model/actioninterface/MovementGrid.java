package l2kstudios.gme.model.actioninterface;

import java.util.ArrayList;

import l2kstudios.gme.model.action.move.Move;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.unit.Unit;

public class MovementGrid extends PlayingGridOverlayInterface {
	
	public void initialize(Turn turn) {
		super.initialize(turn);
		moveCursorTo(actingUnit.getPosition());
		setChooseableSpaces();
	}
	
	private void setChooseableSpaces() {
		chooseableSpaces = new ArrayList<Space>();
		
		playingGrid.forEachSpace((space) -> {
			if(actingUnit.canMoveTo(space)) chooseableSpaces.add(space);
		});
	}

	public boolean select() {
		if(actingUnit.canMoveTo(hoveredSpace())) {
			transaction.addAction(new Move(actingUnit){{
				setTargetSpace(hoveredSpace());
			}});
			
			return true;
		}
		
		return false;
	}
	
	public boolean unitIsHovered(Unit unit) {
		return unit == hoveredSpace().getOccupier();
	}
	
	public Space getSpaceAt(int x, int y) {
		return getSpaces().get(y).get(x);
	}
	
}
