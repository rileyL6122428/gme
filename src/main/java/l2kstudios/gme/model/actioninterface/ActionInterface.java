package l2kstudios.gme.model.actioninterface;

import java.util.List;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.customerror.MethodNotImplementedException;
import l2kstudios.gme.model.grid.Cursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.PlayerControlledTurn;

public class ActionInterface extends RectangularGrid {
	
	protected Cursor cursor = new Cursor();
	protected Position actingUnitPosition;
	protected List<Space> chooseableSpaces;
	
	public void initialize(PlayerControlledTurn turn) {
		actingUnitPosition = turn.getActingUnit().getPosition();
	}
	
	public Position getCursorPosition() {
		return cursor.getPosition();
	}
	
	public boolean select() {
		throw new MethodNotImplementedException();
	}
	
	public void moveCursorTo(Position position) {
		cursor.setPosition(position);
	}
	
	public void moveCursorTo(Space space) {
		cursor.setPosition(space.getPosition());
	}
	
	public Space hoveredSpace() {
		return getSpaceAt(cursor.getPosition());
	}
	
	public RangeOfEffect getRangeOfEffect() {
		return null;
	}
	
	public void moveCursorDown() {
		Position cursorPosition = cursor.getPosition();
		int nextYCoord = (cursorPosition.getY() >= getHeight() - 1) ? 0 : cursorPosition.getY() + 1; 
		Position nextCursorPosition = getSpaceAt(cursorPosition.getX(), nextYCoord).getPosition(); 
		cursor.setPosition(nextCursorPosition);
	}
	
	public void moveCursorUp() {
		Position cursorPosition = cursor.getPosition();
		int nextYCoord = (cursorPosition.getY() == 0) ? getHeight() - 1 : cursorPosition.getY() - 1; 
		Position nextCursorPosition = getSpaceAt(cursorPosition.getX(), nextYCoord).getPosition(); 
		cursor.setPosition(nextCursorPosition);
	}
	
	public void moveCursorRight() {
		Position cursorPosition = cursor.getPosition();
		int nextXCoord = (cursorPosition.getX() >= getWidth() - 1) ? 0 : cursorPosition.getX() + 1; 
		Position nextCursorPosition = getSpaceAt(nextXCoord, cursorPosition.getY()).getPosition(); 
		cursor.setPosition(nextCursorPosition);
	}
	
	public void moveCursorLeft() {
		Position cursorPosition = cursor.getPosition();
		int nextXCoord = (cursorPosition.getX() == 0) ? getWidth() - 1 : cursorPosition.getX() - 1; 
		Position nextCursorPosition = getSpaceAt(nextXCoord, cursorPosition.getY()).getPosition(); 
		cursor.setPosition(nextCursorPosition);
	}
	
	public List<Space> getChooseableSpaces() {
		return chooseableSpaces;
	}

	public Position getActingUnitPosition() {
		return actingUnitPosition;
	}
}
