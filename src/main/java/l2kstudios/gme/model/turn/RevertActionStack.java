package l2kstudios.gme.model.turn;

import java.util.ArrayList;
import java.util.List;

public class RevertActionStack {
	
	private List<Runnable> undoActionCallbacks;
	
	{
		undoActionCallbacks = new ArrayList<Runnable>();
	}
	
	public void undoLastAction() {
		if(!undoActionCallbacks.isEmpty()) {
			int callbackIndex = undoActionCallbacks.size() - 1;
			Runnable callback = undoActionCallbacks.get(callbackIndex);
			
			callback.run();
			undoActionCallbacks.remove(callbackIndex);
		}
	}
	
	public void addUndoCallback(Runnable undoCallback) {
		undoActionCallbacks.add(undoCallback);
	}

	public void removeCallbacks() {
		undoActionCallbacks = new ArrayList<Runnable>();
	}
	
}
