package l2kstudios.gme.model.action.move;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class Move extends Action {
	
	private Space targetSpace;

	public Move(Unit executinUnit) {
		super(executinUnit);
	}
	
	public void execute() {
		executingUnit.moveTo(targetSpace);
	}

	@Override
	public boolean isTurnEnding() {
		return false;
	}

	@Override
	public Class getNextActionInterfaceType() {
		return PostMoveDecisionMenu.class;
	}

	@Override
	public Class getPrecedingActionInterfaceType() {
		return null;
	}
	
	public void setTargetSpace(Space space) {
		this.targetSpace = space;
	}
	
	public Space getTargetSpace() {
		return targetSpace;
	}
}
