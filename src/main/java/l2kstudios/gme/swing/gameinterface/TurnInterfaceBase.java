package l2kstudios.gme.swing.gameinterface;

import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnDirector;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;

public abstract class TurnInterfaceBase implements TurnDirector {
	
	protected BoundedCursor cursor;
	
	protected Turn turn;
	
	protected int width;
	protected int height;
	
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

	public void moveCursorDown() {
		cursor.incrementPosition(0, 1);
	}

	public void moveCursorUp() {
		cursor.incrementPosition(0, -1);
	}

	public void moveCursorRight() {
		cursor.incrementPosition(1, 0);
	};

	public void moveCursorLeft() {;
		cursor.incrementPosition(-1, 0);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		cursor.setXBound(width);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		cursor.setYBound(height);
	}
	
	public void setCursorPosition(Position position) {
		cursor.setPosition(position);
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}
	
	public abstract void initialize();
}
