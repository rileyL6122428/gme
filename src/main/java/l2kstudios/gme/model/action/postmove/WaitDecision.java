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
		System.out.println("OUT ACTION EXECUTED");
		
	}
	
	public boolean isTurnEnding() {
		return true;
	}

	@Override
	public Class getNextActionInterfaceType() {
		return null;
	}

	@Override
	public boolean ableToExecute() {
		return true;
	}
}
