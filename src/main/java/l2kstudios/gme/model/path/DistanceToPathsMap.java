package l2kstudios.gme.model.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import l2kstudios.gme.model.unit.Unit;

public class DistanceToPathsMap {
	
	private Map<Integer, List<Path>> map;
	
	public DistanceToPathsMap(Unit unit) {
		map = new HashMap<Integer, List<Path>>();
		
		for(int distance = 0; distance <= unit.getRemainingEnergy(); distance++) {
			map.put(distance, new ArrayList<Path>());
		}
	}
	
	public void addPath(int distance, Path path) {
		map.get(distance).add(path);
	}
	
	public List<Path> getPathsWithDistance(int distance) {
		return map.get(distance);
	}
	
}
