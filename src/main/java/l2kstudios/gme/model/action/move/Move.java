package l2kstudios.gme.model.action.move;

import java.util.Set;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.actioninterface.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.path.PathUtil;
import l2kstudios.gme.model.unit.Unit;

public class Move extends Action {
	
	private Set<PlayingGridSpace> moveableSpaces;
	
	{
		rangeOfEffect = new SingleSpace();
	}

	@Override
	public boolean ableToExecuteAt(Space space) {
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
		executionRange = Range.closed(0, (int)unit.getRemainingEnergy());
	}

	public void undo() {
		executingUnit.moveTo(spaceToExecuteFrom);
		setSpaceToExecuteAt(null);
	}
	
}
