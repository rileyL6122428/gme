package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.unit.Unit;

public class PostMoveDecision extends Action {

	public PostMoveDecision(Unit executinUnit) {
		super(executinUnit);
	}

	public void execute() {
		throw new RuntimeException("Method Not Implemented");
	}
	
}
