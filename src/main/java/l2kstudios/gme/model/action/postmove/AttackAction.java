package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.unit.Unit;

public class AttackAction extends Action {
	
	{
		name = "Attack";
	}
	
	public AttackAction(Unit executingUnit) {
		super(executingUnit);
	}
	
	public boolean ableToExecute() {
		return true;
	}
	
	public void execute() {
		executingUnit.registerChoosingAttack();
	}
}
