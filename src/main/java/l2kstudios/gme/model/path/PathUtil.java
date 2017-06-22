package l2kstudios.gme.model.path;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.unit.Unit;

public class PathUtil {
	
	public Set<PlayingGridSpace> moveableSpaces(Unit unit) {
		Map<PlayingGridSpace, Path> moveablePaths = moveablePaths(unit);
		return new HashSet<PlayingGridSpace>(moveablePaths.keySet());
	}
	
	public Map<PlayingGridSpace, Path> moveablePaths(Unit unit) {
		final Map<PlayingGridSpace, Path> endPointToPathMap = new HashMap<PlayingGridSpace, Path>();
		final DistanceToPathsMap distanceToPathsMap = new DistanceToPathsMap(unit);
		
		Path stationaryPath = stationaryPath(unit);
		endPointToPathMap.put(unit.getOccupiedSpace(), stationaryPath);
		distanceToPathsMap.addPath(0, stationaryPath);
		
		for(int energy = 1; energy <= unit.getRemainingEnergy(); energy++) {
			for(Path prevPath : distanceToPathsMap.getPathsWithDistance(energy - 1)) {
				for(PlayingGridSpace adjacentSpace : prevPath.getEnd().getAdjacentPlayingGridSpaces()) {
					if(!containsBlockerFor(unit, adjacentSpace) && !endPointToPathMap.containsKey(adjacentSpace))
						addPathLeadingToAdjacentSpace(endPointToPathMap, distanceToPathsMap, adjacentSpace, prevPath, energy);
				}
			}
		}
		
		trimPathsContainingNonBlockingUnits(endPointToPathMap);
		
		return endPointToPathMap;
	}
	
	
	private void trimPathsContainingNonBlockingUnits(Map<PlayingGridSpace, Path> endPointToPathMap) {
		Iterator<Map.Entry<PlayingGridSpace, Path>> mapIterator = endPointToPathMap.entrySet().iterator();
		
		while(mapIterator.hasNext()) {
			
			Map.Entry<PlayingGridSpace, Path> entry = mapIterator.next();
			PlayingGridSpace space = entry.getKey();
			Path path = entry.getValue();
			
			if(path.getLength() != 0 && space.getOccupier() != null && space.getOccupier() instanceof Unit)
				mapIterator.remove();
		}
		
	}

	private Path stationaryPath(Unit unit) {
		Path stationaryPath = new Path();
		stationaryPath.add(unit.getOccupiedSpace());
		return stationaryPath;
	}
	
	private void addPathLeadingToAdjacentSpace(
		Map<PlayingGridSpace, Path> endPointToPath, DistanceToPathsMap distanceToPathsMap, PlayingGridSpace adjacentSpace, Path prevPath, int energy
		) {
		Path path = new Path(endPointToPath.get(prevPath.getEnd()));
		path.add(adjacentSpace);
		endPointToPath.put(adjacentSpace, path);
		distanceToPathsMap.addPath(energy, path);
	}
	

	private boolean containsBlockerFor(Unit unit, PlayingGridSpace adjacentSpace) {
		//TODO refactor
		// need a method called IS TRAVERSABLE on playingGridSpace for unit
		
		return !adjacentSpace.isOccupiable() ||
				adjacentSpace.isOccupiedByMemberOfOppositeTeam(unit.getTeam());
	}
	
	

}
