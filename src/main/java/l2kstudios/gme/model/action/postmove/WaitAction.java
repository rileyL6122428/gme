package l2kstudios.gme.model.action.postmove;

import l2kstudios.gme.model.grid.Space;

public class WaitAction extends PostMoveAction {

	@Override
	public void execute() {
		System.out.println("WAITING");
	}

	@Override
	public boolean ableToExecuteAt(Space space) {
		return true;
	}

	@Override
	protected void affectSpace(Space unit) { }

}
