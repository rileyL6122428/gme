package l2kstudios.gme.model.unit;

import l2kstudios.gme.model.grid.Placeable;

public class Action extends Placeable {
	
	protected Unit executingUnit;
	protected String name;
	
	public void execute() {
		throw new RuntimeException("Method Not Implemented");
	}
	
	public boolean ableToExecute() {
		throw new RuntimeException("Method Not Implemented");
	}

}
