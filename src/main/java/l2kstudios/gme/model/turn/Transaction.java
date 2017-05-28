package l2kstudios.gme.model.turn;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.move.Move;
import l2kstudios.gme.model.grid.Space;

public class Transaction {
	
	private List<Action> actionQueue;
	
	{
		actionQueue = new ArrayList<Action>();
	}
	
	public void commit() {
		for(Action action : actionQueue) {
			action.execute();
		}
	}
	
	public void addAction(Action action) {
		actionQueue.add(action);
	}
	
	public boolean readyToCommit() {
		return (lastActionInQueue() == null) ? false : lastActionInQueue().isTurnEnding();
	}
	
	public Action lastActionInQueue() {
		return (actionQueue.isEmpty()) ? null : actionQueue.get(actionQueue.size() - 1);
	}
	
	public Space getTargetSpace() {
		if(actionQueue.isEmpty()) return null;
		
		Move move = (Move)actionQueue.get(0);
		return move.getTargetSpace();
	}
}
