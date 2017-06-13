package l2kstudios.gme.model.turn;

public class PhaseSequence {
	
	private Phase start;
	private Phase terminal;
	private Phase current;
	private boolean finished;
	
	public void advance() {
		if(current == null) return;
		
		current.invokeAdvanceCallback();
		current = current.getNext();
		
		if(current == null) finished = true;
	}
	
	public void regress() {
		if(current == null || current.getPrevious() == null) return;
		
		current.invokeRegressionCallback();
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
	}
	
	private void addToEnd(Phase phase) {
		terminal.setNext(phase);
		phase.setPrevious(terminal);
		terminal = phase;
	}

	public boolean isFinished() {
		return finished;
	}

}
