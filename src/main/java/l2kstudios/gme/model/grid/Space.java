package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.action.rangeofeffect.Delta;
import l2kstudios.gme.model.grid.position.Position;

public class Space {
	
	public static List<Delta> ADJACENT_SPACE_DELTAS = new ArrayList<Delta>(){{
		add(new Delta( 0,  1));
		add(new Delta( 0, -1));
		add(new Delta( 1,  0));
		add(new Delta(-1,  0));
	}};
	
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
		return ADJACENT_SPACE_DELTAS.stream()
				
		     .map((Delta delta) -> delta.getRelativePositionFrom(getPosition()))
		     .filter((Position adjacentPosition) ->  grid.isInBounds(adjacentPosition))
		     .map((Position adjacentPosition) -> grid.getSpaceAt(adjacentPosition))
		     
		     .collect(Collectors.toList());
	}
	
}
