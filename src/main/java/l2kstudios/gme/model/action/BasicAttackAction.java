package l2kstudios.gme.model.action;

import l2kstudios.gme.model.unit.Unit;

public class BasicAttackAction extends Action {
	
	{
		name = "Basic Attack";
	}
	
	public BasicAttackAction(Unit unit) {
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
