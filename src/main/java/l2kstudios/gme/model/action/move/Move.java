package l2kstudios.gme.model.action.move;

import java.util.Set;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.path.PathUtil;
import l2kstudios.gme.model.unit.Unit;

public class Move extends Action {
	
	private Set<Space> moveableSpaces;
	private Space spaceOccupiedBeforeMove;
	
	{
		rangeOfEffect = new SingleSpace();
	}

	@Override
	public boolean ableToExecuteAt(Space space) {
//		return getExecutingUnit().canMoveTo(space);
		return moveableSpaces.contains(space);
	}

	@Override
	protected void affectSpace(Space space) {
		executingUnit.moveTo(space);
	}
	
	@Override
	public void setExecutingUnit(Unit unit) {
		super.setExecutingUnit(unit);
		moveableSpaces = new PathUtil().moveableSpaces(unit);
		spaceOccupiedBeforeMove = unit.getOccupiedSpace();
	}

	public void undo() {
		executingUnit.moveTo(spaceOccupiedBeforeMove);
		setSpaceToExecuteAt(null);
	}
}
