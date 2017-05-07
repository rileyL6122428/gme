package l2kstudios.gme.model.unit;

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
