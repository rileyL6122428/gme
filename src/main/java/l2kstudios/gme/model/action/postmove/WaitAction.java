package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.unit.Unit;

public class WaitAction extends Action {
	
	{
		name = "Wait";
	}
	
	public WaitAction(Unit executingUnit) {
		super(executingUnit);
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
