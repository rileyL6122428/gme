package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.actioninterface.AttackOptions;
import l2kstudios.gme.model.unit.Unit;

public class AttackDecision extends PostMoveDecision {
	
	{
		name = "Attack";
	}
	
	public AttackDecision(Unit executingUnit) {
		super(executingUnit);
	}
	
	public boolean ableToExecute() {
		return true;
	}
	
	public void execute() {
		System.out.println("Attack Decision Chosen");
	}
	
	public Class getNextActionInterfaceType() {
		return AttackOptions.class;
	}
}
