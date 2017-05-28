package l2kstudios.gme.model.action;

import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.unit.Unit;

public abstract class Action extends Placeable {
	
	protected Unit executingUnit;
	protected String name;
	
	public Action(Unit executinUnit) {
		this.executingUnit = executinUnit;
	}
	
	public abstract void execute();
	
	public abstract boolean isTurnEnding();
	
	public abstract Class getNextActionInterfaceType(); 
	
	public abstract Class getPrecedingActionInterfaceType();
	
	public String getName() {
		return name;
	}
}
