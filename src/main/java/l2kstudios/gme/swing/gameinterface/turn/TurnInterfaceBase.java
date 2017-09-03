package l2kstudios.gme.swing.gameinterface.turn;

import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.position.Position;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnDirector;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;

public abstract class TurnInterfaceBase implements TurnDirector {
	
	protected Turn turn;
	
	public PhaseProgressionFlag receiveInput(Input input) {
		switch(input) {
			case LEFT: 
				moveCursorLeft();
				return PhaseProgressionFlag.STAND_BY;
			case RIGHT: 
				moveCursorRight(); 
				return PhaseProgressionFlag.STAND_BY;
			case UP: 
				moveCursorUp(); 
				return PhaseProgressionFlag.STAND_BY;
			case DOWN: 
				moveCursorDown(); 
				return PhaseProgressionFlag.STAND_BY;
			case SPACE: 
				return select();
			case BACK: 
				turn.revertAction();
				return PhaseProgressionFlag.REGRESS;
			default:
				throw new RuntimeException("CASE NOT HANDLED IN RECEIVE INPUT");
		}
		
	}

	public abstract PhaseProgressionFlag select();

	public abstract void moveCursorDown();

	public abstract void moveCursorUp();

	public abstract void moveCursorRight();

	public abstract void moveCursorLeft();

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}
	
	public abstract void initialize();
}
