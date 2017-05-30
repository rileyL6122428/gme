package l2kstudios.gme.model.action.wait;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.grid.Space;

public class Wait extends PostMoveAction {
	
	{
		executionRange = Range.closed(0, 0);
		setRangeOfEffect(new SingleSpace());
	}

	@Override
	public boolean ableToExecuteAt(Space space) {
		return true;
	}

	@Override
	protected void affectSpace(Space space) {
		// TODO Auto-generated method stub
		
	}

}
