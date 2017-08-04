package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.unit.Unit;

public class PostMoveDecision extends Placeable {
	
	protected Class postMoveActionType;
	private int decisionNumber;

	public Class getPostMoveActionType() {
		return postMoveActionType;
	}
	
	
	public String getName() {
		return getClass().getSimpleName();
	}

}
