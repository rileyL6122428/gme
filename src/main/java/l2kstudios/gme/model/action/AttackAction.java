package l2kstudios.gme.model.action;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Delta;

public class AttackAction extends Action {
	
	protected List<Delta> rangeDeltas;
	protected PlayingGrid playingGrid;
	
	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
//	public List<Space> getAttackSpaces() {
//		final List<Space> attackSpaces = new ArrayList<Space>();
//		final Space occupiedSpace = executingUnit.getOccupiedSpace();
//		
//		rangeDeltas.forEach((delta) -> {
//			Space attackSpace = delta.getDeltaSpace(occupiedSpace);
//			if(attackSpace != null && attackSpace.isOccupied()) attackSpaces.add(attackSpace);
//		});
//		
//		return attackSpaces;
//	}
}
