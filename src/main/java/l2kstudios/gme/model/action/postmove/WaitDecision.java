package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.unit.Unit;

public class WaitDecision extends PostMoveDecision {
	
	{
		name = "Wait";
	}
	
	public WaitDecision(Unit executingUnit) {
		super(executingUnit);
	}

	@Override
	public void execute() {
		executingUnit.endTurn();
		
	}

	@Override
	public boolean ableToExecute() {
		return true;
	}

}
