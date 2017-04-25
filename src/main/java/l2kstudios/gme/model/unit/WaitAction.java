package l2kstudios.gme.model.unit;

public class WaitAction extends Action {
	
	{
		name = "Wait";
	}
	
	public WaitAction() {}
	
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
