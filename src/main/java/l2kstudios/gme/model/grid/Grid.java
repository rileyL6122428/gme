package l2kstudios.gme.model.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import l2kstudios.gme.model.customerror.MethodNotImplementedException;

public class Grid {

	protected Cursor cursor = new Cursor();
	protected List<List<Space>> spaces;
	private Map<Space, Position> spaceToPosition;
	
	public void initialize() {
		throw new MethodNotImplementedException();
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
	
	public void place(Placeable placeable, int x, int y) {
		Space space = getSpaces().get(y).get(x);
		placeable.place(space);
	}
	
	public int getWidth() {
		return spaces.get(0).size();
	}

	public int getHeight() {
		return spaces.size();
	}
	
	public Position getCursorPosition() {
		return cursor.getPosition();
	}
	
	
	public Space getSpaceAt(int x, int y) {
		return getSpaces().get(y).get(x);
	}
	
	public Space getSpaceAt(Position position) {
		int x = position.getX();
		int y = position.getY();
		return getSpaces().get(y).get(x);
	}
	
	public Space hoveredSpace() {
		return getSpaceAt(cursor.getPosition());
	}


	public Position positionOf(Space space) {
		return spaceToPosition.get(space);
	}
	
	public boolean isInBounds(Position position) {
		return spaces.size() > position.getY() && 
				position.getY() >= 0 && 
				spaces.get(position.getY()).size() > position.getX() &&
				position.getX() >= 0;
	}
	
	public List<List<Space>> getSpaces() {
		return spaces;
	}
	
	public void setSpaces(List<List<Space>> spaces) {
		this.spaces = spaces;
		validateDimensions();
		setPositionsToSpacesMap();
		passGridReferenceToSpaces();
	}
	
	private void validateDimensions() {
		for(List<Space> row : spaces) {
			if(row.size() != getWidth())
				throw new RuntimeException("GRID NOT AN EVEN RECTANGLE");
		}
	}
	
	private void setPositionsToSpacesMap() {
		spaceToPosition = new HashMap<Space, Position>();
		
		for(int y = 0; y < spaces.size(); y++) {
			for(int x = 0; x < spaces.get(y).size(); x++) {
				spaceToPosition.put(spaces.get(y).get(x), new Position(x, y));
			}
		}
	}
	
	private void passGridReferenceToSpaces() {
		for(int y = 0; y < spaces.size(); y++) {
			for(int x = 0; x < spaces.get(y).size(); x++) {
				spaces.get(y).get(x).setGrid(this);
			}
		}
	}
}
