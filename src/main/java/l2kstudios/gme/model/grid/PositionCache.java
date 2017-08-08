package l2kstudios.gme.model.grid;

import java.util.HashMap;
import java.util.Map;

public class PositionCache {
	
	private Map<Integer, Map<Integer, Position>> cachedRows;
	
	{
		cachedRows = new HashMap<Integer, Map<Integer, Position>>();
	}
	
	public Position get(int x, int y) {
		instantiateAndCachePositionIfNecessary(x, y); 
		return cachedRows.get(y).get(x);
	}
	
	private void instantiateAndCachePositionIfNecessary(int x, int y) {
		if(cachedRows.get(y) == null)
			cachedRows.put(y, new HashMap<Integer, Position>());
		
		Map<Integer, Position> cachedRow = cachedRows.get(y); 
		if(cachedRow.get(x) == null) 
			cachedRow.put(x, new Position(x, y));
	}
	
}
