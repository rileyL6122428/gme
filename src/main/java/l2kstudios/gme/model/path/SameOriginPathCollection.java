package l2kstudios.gme.model.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;

public class SameOriginPathCollection {
	
	private PlayingGridSpace origin;
	private Map<PlayingGridSpace, Path> endPointToPathMap;
	private Map<Integer, List<Path>> distanceToPathsMap;
	
	public SameOriginPathCollection(PlayingGridSpace origin) {
		this.origin = origin;
		
		Path stationaryPath = Path.StationaryPath(origin);
		
		distanceToPathsMap = new HashMap<Integer, List<Path>>();
		distanceToPathsMap.put(0, new ArrayList<Path>(){{ add(stationaryPath); }});
		
		endPointToPathMap = new HashMap<PlayingGridSpace, Path>();
	}
	
	public void addPath(Path path) {
		
	}

}
