package l2kstudios.gme.model.grid.playinggrid;

import l2kstudios.gme.model.action.rangeofeffect.Delta;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class PathUtil {
	
	private PlayingGrid playingGrid;
	
	public boolean pathExistsToSpaceForUnit(Space space, Unit unit) {
		int distance = GridUtils.distanceBetween(space.getPosition(), unit.getPosition());
		
		return distance > unit.getRemainingEnergy() &&
				(directPathToSpaceForUnit(space, unit) != null ||
				 indirectPathToSpaceForUnit(space, unit) != null);
		
	}
	
	public Path directPathToSpaceForUnit(Space space, Unit unit) {
		Position startPosition = unit.getPosition();
		Position endPosition = space.getPosition();
		
		Delta endPointDelta = new Delta(startPosition, endPosition);
		
		Path directPath = new Path();
		directPath.add(playingGrid.getSpaceAt(unit.getPosition()));
		
		buildDirectPath(directPath, endPointDelta);
		
		return null;
	}

	private void buildDirectPath(Path directPath, Delta endPointDelta) {
		if(endPointDelta.isZeroDelta()) return;
		
	}

	private Path indirectPathToSpaceForUnit(Space space, Unit unit) {
		return null;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
}
