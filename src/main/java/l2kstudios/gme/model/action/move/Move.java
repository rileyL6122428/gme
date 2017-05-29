package l2kstudios.gme.model.action.move;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class Move extends Action {
	
	{
		rangeOfEffect = new SingleSpace();
	}

	@Override
	public boolean ableToExecuteAt(Space space) {
		return getExecutingUnit().canMoveTo(space);
	}

	@Override
	protected void affectSpace(Space space) {
		executingUnit.moveTo(space);
	}
}
