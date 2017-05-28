package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.actioninterface.MovementGrid;
import l2kstudios.gme.model.unit.Unit;

public abstract class PostMoveDecision extends Action {

	public PostMoveDecision(Unit executinUnit) {
		super(executinUnit);
	}

	public void execute() {
		throw new RuntimeException("Method Not Implemented");
	}

	@Override
	public boolean isTurnEnding() {
		return false;
	}

	@Override
	public Class getPrecedingActionInterfaceType() {
		return MovementGrid.class;
	}
	
	public abstract boolean ableToExecute();
}
