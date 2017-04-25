package l2kstudios.gme.model.unit;

public abstract class Action {
	
	protected Unit executingUnit;
	protected String name;
	
	public abstract void execute();
	public abstract boolean ableToExecute();
}
