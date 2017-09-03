package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

public class Space {
	
	private Placeable occupier;
	private RectangularGrid grid;
	
	public boolean isOccupied() {
		return occupier != null;
	}

	public Placeable getOccupier() {
		return occupier;
	}

	public void setOccupier(Placeable occupier) {
		this.occupier = occupier;
		if(occupier != null) occupier.setOccupiedSpace(this);			
	}
	
	public Position getPosition() {
		return getGrid().positionOf(this);
	}

	public RectangularGrid getGrid() {
		return grid;
	}

	public void setGrid(RectangularGrid grid) {
		this.grid = grid;
	}

	public boolean isAdjacentTo(Space space) {
		return GridUtils.distanceBetween(getPosition(), space.getPosition()) == 1;
	}
	
	public boolean hasCoordinates(int x, int y) {
		return getPosition().hasCoordinates(x, y);
	}

	public List<Space> getAdjacentSpaces() {
		Position position = getPosition();
		List<Space> adjacentSpaces = new ArrayList<Space>();
		
		if(grid.isInBounds(position.getX(), position.getY() + 1)) {
			Space adjacentSpace = grid.getSpaceAt(position.getX(), position.getY() + 1);
			if(!isAdjacentTo(adjacentSpace)) {
				System.out.println("ERROR OCCURRING");
			}
			adjacentSpace = grid.getSpaceAt(position.getX(), position.getY() + 1);
			Position position2 = adjacentSpace.getPosition();
			adjacentSpaces.add(adjacentSpace);
		}
		
		if(grid.isInBounds(position.getX(), position.getY() - 1)) {
			Space adjacentSpace = grid.getSpaceAt(position.getX(), position.getY() - 1);
			if(!isAdjacentTo(adjacentSpace)) {
				System.out.println("ERROR OCCURRING");
			}
			adjacentSpaces.add(adjacentSpace);
		}
		
		if(grid.isInBounds(position.getX() + 1, position.getY())) {
			Space adjacentSpace = grid.getSpaceAt(position.getX() + 1, position.getY());
			if(!isAdjacentTo(adjacentSpace)) {
				System.out.println("ERROR OCCURRING");
			}
			adjacentSpaces.add(adjacentSpace);
		}
		
		if(grid.isInBounds(position.getX() - 1, position.getY())) {
			Space adjacentSpace = grid.getSpaceAt(position.getX() - 1, position.getY());
			if(!isAdjacentTo(adjacentSpace)) {
				System.out.println("ERROR OCCURRING");
			}
			adjacentSpaces.add(adjacentSpace);			
		}
		
		return adjacentSpaces;
	}
	
}
