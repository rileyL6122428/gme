package l2kstudios.gme.model.turn;

import l2kstudios.gme.swing.gameinterface.TurnInterfaceBase;

public class TurnPhaseSequence {
	
	public enum PhaseProgressionFlag {
		ADVANCE, REGRESS, STAND_BY
	}
	
	private Phase start;
	private Phase terminal;
	private Phase current;
	private boolean finished;
	
	public void advance() {
		if(current == null) return;
		
		current = current.getNext();
		
		if(current == null) 
			finished = true;
		else
			current.initialize();
	}
	
	public void regress() {
		if(current == null || current.getPrevious() == null) return;
		
		current = current.getPrevious();
	}
	
	public void add(Phase phase) {
		if(start == null)
			initialize(phase);
		else 
			addToEnd(phase);
	}
	
	private void initialize(Phase phase) {
		start = phase;
		terminal = phase;
		current = phase;
		current.initialize();
	}
	
	private void addToEnd(Phase phase) {
		terminal.setNext(phase);
		phase.setPrevious(terminal);
		terminal = phase;
	}

	public boolean isFinished() {
		return finished;
	}

	public TurnInterfaceBase getPhaseInterface() {
		return current.getPhaseInterface();
	}

	public void registerFlag(PhaseProgressionFlag phaseFlag) {
		switch(phaseFlag) {
			case ADVANCE:
				advance();
				break;
			case REGRESS:
				regress();
				break;
		}
		
	}

}
