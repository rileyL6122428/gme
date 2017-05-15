package l2kstudios.gme.model.action;

import l2kstudios.gme.model.unit.Unit;

public class WaitAction extends Action {
	
	{
		name = "Wait";
	}
	
	public WaitAction(Unit unit) {
		this.executingUnit = unit;
	}

	@Override
	public void execute() {
		executingUnit.registerTurnEnd();
		
	}

	@Override
	public boolean ableToExecute() {
		return true;
	}

}
