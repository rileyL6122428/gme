package l2kstudios.gme.model.turn;

import l2kstudios.gme.swing.gameinterface.TurnInterfaceBase;

public class Phase {
	
	private Phase next;
	private Phase previous;
	
	private TurnInterfaceBase turnInterface;

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

	public TurnInterfaceBase getPhaseInterface() {
		return turnInterface;
	}

	public void setPhaseInterface(TurnInterfaceBase phaseInterface) {
		this.turnInterface = phaseInterface;
	}

	public void initialize() {
		turnInterface.initialize();
	}

	
}
