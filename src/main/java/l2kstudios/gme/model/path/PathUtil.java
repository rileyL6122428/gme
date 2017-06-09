package l2kstudios.gme.model.path;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class PathUtil {
	
	public Map<Space, Path> moveablePaths(Unit unit) {
		final Map<Space, Path> endPointToPathMap = new HashMap<Space, Path>();
		final DistanceToPathsMap distanceToPathsMap = new DistanceToPathsMap(unit);
		
		Path stationaryPath = stationaryPath(unit);
		endPointToPathMap.put(unit.getOccupiedSpace(), stationaryPath);
		distanceToPathsMap.addPath(0, stationaryPath);
		
		for(int energy = 1; energy <= unit.getRemainingEnergy(); energy++) {
			for(Path prevPath : distanceToPathsMap.getPathsWithDistance(energy - 1)) {
				for(Space adjacentSpace : prevPath.getEnd().getAdjacentSpaces()) {
					if(!containsBlockerFor(unit, adjacentSpace) && !endPointToPathMap.containsKey(adjacentSpace))
						addPathLeadingToAdjacentSpace(endPointToPathMap, distanceToPathsMap, adjacentSpace, prevPath, energy);
				}
			}
		}
		
		return endPointToPathMap;
	}
	
	public Set<Space> convertEndPointPathMapToSetOfSpaces(Map<Space, Path> endPointToPathMap) {
		Set<Space> moveableSpaces = new HashSet<Space>(endPointToPathMap.keySet());
		
		endPointToPathMap.values().forEach(moveableSpaces::add);
		
		return moveableSpaces;
	}
	
	private Path stationaryPath(Unit unit) {
		Path stationaryPath = new Path();
		stationaryPath.add(unit.getOccupiedSpace());
		return stationaryPath;
	}
	
	private void addPathLeadingToAdjacentSpace(
		Map<Space, Path> endPointToPath, DistanceToPathsMap distanceToPathsMap, Space adjacentSpace, Path prevPath, int energy
		) {
		Path path = new Path(endPointToPath.get(prevPath.getEnd()));
		path.add(adjacentSpace);
		endPointToPath.put(adjacentSpace, path);
		distanceToPathsMap.addPath(energy, path);
	}
	

	private boolean containsBlockerFor(Unit unit, Space adjacentSpace) {
		if(!adjacentSpace.isOccupied()) return false;
		
		if(!(adjacentSpace.getOccupier() instanceof Unit)) return true;
		
		Unit occupyingUnit = (Unit) adjacentSpace.getOccupier();
		return unit.getTeam() != occupyingUnit.getTeam();
	}
	
	

}
