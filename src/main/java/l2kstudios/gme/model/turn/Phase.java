package l2kstudios.gme.model.turn;

public class Phase {
	
	private Phase next;
	private Phase previous;
	
	private TurnDirector turnInterface;

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

	public TurnDirector getPhaseInterface() {
		return turnInterface;
	}

	public void setPhaseInterface(TurnDirector phaseInterface) {
		this.turnInterface = phaseInterface;
	}
	
}
