package l2kstudios.gme.model.grid.playinggrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

import l2kstudios.gme.model.action.rangeofeffect.Delta;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class PathUtil {
	
	private PlayingGrid playingGrid;
	
	
	public Map<Space, Path> moveablePaths(Unit unit) {
		final Map<Space, Path> endPointToPath = new HashMap<Space, Path>();
		final Map<Integer, List<Path>> distanceToPaths = new HashMap<Integer, List<Path>>();
		
		Path initialPath = new Path();
		initialPath.add(unit.getOccupiedSpace());
		endPointToPath.put(unit.getOccupiedSpace(), initialPath);
		distanceToPaths.put(0, new ArrayList<Path>(){{ add(initialPath); }});
		
		for(long energy = 1; energy <= unit.getRemainingEnergy(); energy++) {

			distanceToPaths.put((int)energy, new ArrayList<Path>());
			
			for(Path prevPath : distanceToPaths.get((int)(energy - 1))) {
				for(Space adjacentSpace : prevPath.getEnd().getAdjacentSpaces()) {
					if(!containsBlockerFor(unit, adjacentSpace) && endPointToPath.get(adjacentSpace) == null) {
						Path path = new Path(endPointToPath.get(prevPath.getEnd()));
						path.add(adjacentSpace);
						endPointToPath.put(adjacentSpace, path);
						distanceToPaths.get((int)energy).add(path);
					}					
				}
									
			}
			
		}
		
		return endPointToPath;
	}

	

	private boolean containsBlockerFor(Unit unit, Space adjacentSpace) {
		if(!adjacentSpace.isOccupied()) return false;
		
		if(!(adjacentSpace.getOccupier() instanceof Unit)) return true;
		
		Unit occupyingUnit = (Unit) adjacentSpace.getOccupier();
		return unit.getTeam() != occupyingUnit.getTeam();
	}
	
	public List<Space> spacesWithDistanceFromUnit(int distance, Unit unit) {
		List<Space> spaces = new ArrayList<Space>();
		Position unitPosition = unit.getPosition();
		
		int x = unitPosition.getX();
		int y = unitPosition.getY();
		
		int idx = 0;
		while(idx < distance) {
			Space space = playingGrid.getSpaceAt(x + idx, y + distance - idx); 
			if(space != null) spaces.add(space);
			idx++;
		}
		
		idx = 0;
		while(idx < distance) {
			Space space = playingGrid.getSpaceAt(x + distance - idx, y - idx);
			if(space != null) spaces.add(space);
			idx++;
		}
		
		idx = 0;
		while(idx < distance) {
			Space space = playingGrid.getSpaceAt(x - idx, y - distance + idx); 
			if(space != null) spaces.add(space);
			idx++;
		}
		
		idx = 0;
		while(idx < distance) {
			Space space = playingGrid.getSpaceAt(x - distance + idx, y - distance + idx);
			if(space != null) spaces.add(space);
			idx++;
		}
		
		return spaces;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
}
