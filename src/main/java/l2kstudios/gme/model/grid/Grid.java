package l2kstudios.gme.model.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Grid {

	protected Cursor cursor;
	protected List<List<Space>> spaces;
	private Map<Space, Position> spaceToPosition;
	
	
	public Grid() {
		this.cursor = new Cursor();
	}
	
	public void select() {
		throw new RuntimeException("SELECT METHOD NOT IMPLEMENTED ON GRID");
	}
	
	public void moveCursorBy(int deltaX, int deltaY) {
		moveCursorField(cursor::setX, cursor.getX() + deltaX, getWidth());
		moveCursorField(cursor::setY, cursor.getY() + deltaY, getHeight());
	}
	
	private void moveCursorField(Consumer<Integer> setter, int nextCursorVal, int gridDimension) {
		if(nextCursorVal < 0) {
			setter.accept(gridDimension + nextCursorVal);
		} else if(nextCursorVal >= gridDimension){
			setter.accept(nextCursorVal % gridDimension);
		} else {
			setter.accept(nextCursorVal);
		}
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
	
	public void place(Placeable placeable, int x, int y) {
		getSpaces().get(y).get(x).setOccupier(placeable);
	}
	
	public Placeable getHovered() {
		int x = cursor.getX();
		int y = cursor.getY();
		
		return getSpaces().get(y).get(x).getOccupier();
	}

	public List<List<Space>> getSpaces() {
		return spaces;
	}

	public Position positionOf(Space space) {
		return spaceToPosition.get(space);
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
