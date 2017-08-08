package l2kstudios.gme.model.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularGrid implements TwoDimensionalGrid {

	protected List<List<Space>> spaces;
	protected Map<Space, Position> spaceToPosition;
	
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
	
	
	public Space getSpaceAt(int x, int y) {
		return getSpaces().get(y).get(x);
	}
	
	public Space getSpaceAt(Position position) {
		int x = position.getX();
		int y = position.getY();
		return getSpaces().get(y).get(x);
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
	
	public boolean isInBounds(int x, int y) {
		return spaces.size() > y && 
				y >= 0 && 
				spaces.get(y).size() > x &&
				x >= 0;
	}
	
	public List<List<Space>> getSpaces() {
		return spaces;
	}
	
	public void setSpaces(RectangularGrid grid) {
		setSpaces(grid.getSpaces());
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
				spaceToPosition.put(spaces.get(y).get(x), Position.fromCached(x, y));
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
