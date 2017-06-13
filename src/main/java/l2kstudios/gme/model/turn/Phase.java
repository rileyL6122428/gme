package l2kstudios.gme.model.turn;

public class Phase {
	
	private Phase next;
	private Phase previous;
	
	private Runnable advanceCallback;
	private Runnable regressionCallback;
	
	public void invokeAdvanceCallback() {
		advanceCallback.run();
	}
	
	public void setAdvanceCallback(Runnable advanceCallback) {
		this.advanceCallback = advanceCallback;
	}

	public void invokeRegressionCallback() {
		regressionCallback.run();
	}

	public void setRegressionCallback(Runnable regressionCallback) {
		this.regressionCallback = regressionCallback;
	}

	public Phase getNext() {
		return next;
	}

	public void setNext(Phase next) {
		this.next = next;
	}

	public Phase getPrevious() {
		return previous;
	}

	public void setPrevious(Phase previous) {
		this.previous = previous;
	}
	
	
}
