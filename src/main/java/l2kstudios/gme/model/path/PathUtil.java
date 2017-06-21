package l2kstudios.gme.model.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.unit.Unit;

public class PathUtil {
	
	public Set<Space> moveableSpaces(Unit unit) {
		Map<Space, Path> moveablePaths = moveablePaths(unit);
		return new HashSet<Space>(moveablePaths.keySet());
	}
	
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
		
		trimPathsContainingNonBlockingUnits(endPointToPathMap);
		
		return endPointToPathMap;
	}
	
	
	private void trimPathsContainingNonBlockingUnits(Map<Space, Path> endPointToPathMap) {
//		Iterator<Space> spaceIterator = endPointToPathMap.keySet().iterator();
		Iterator<Map.Entry<Space, Path>> mapIterator = endPointToPathMap.entrySet().iterator();
		
		while(mapIterator.hasNext()) {
			Map.Entry<Space, Path> entry = mapIterator.next();
			Space space = entry.getKey();
			if(space.getOccupier() != null && space.getOccupier() instanceof Unit)
				mapIterator.remove();
		}
//		for(Space space : endPointToPathMap.keySet()) {
//			if(space.getOccupier() != null && space.getOccupier() instanceof Unit)
//				endPointToPathMap.remove(space);
//		}
		
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
		//TODO refactor
		PlayingGridSpace space = (PlayingGridSpace)adjacentSpace;
		if(!space.isOccupiable()) return true;
		
		if(!adjacentSpace.isOccupied()) return false;
		if(!(adjacentSpace.getOccupier() instanceof Unit)) return true;
		Unit occupyingUnit = (Unit) adjacentSpace.getOccupier();
		return unit.getTeam() != occupyingUnit.getTeam();
	}
	
	

}
