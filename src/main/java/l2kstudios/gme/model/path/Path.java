package l2kstudios.gme.model.path;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;

public class Path {
	
	private List<PlayingGridSpace> orderedSpaces;
	private Set<PlayingGridSpace> containedSpaces;
	
	public static Path StationaryPath(PlayingGridSpace origin) {
		return new Path(){{
			add(origin);
		}};
	}
	
	{
		orderedSpaces = new ArrayList<PlayingGridSpace>();
		containedSpaces = new HashSet<PlayingGridSpace>();
	}
	
	public Path() {}

	public Path(Path path) {
		Iterator<PlayingGridSpace> pathIterator = path.getIterator();
		while(pathIterator.hasNext()) {
			add(pathIterator.next());
		}
	}

	public void add(PlayingGridSpace space) {
		verifySpaceIsNotAlreadyInPath(space);
		verifySpaceIsAdjacentToPathEnd(space);
		orderedSpaces.add(space);
		containedSpaces.add(space);
	}
	
	private void verifySpaceIsNotAlreadyInPath(Space space) {
		if(this.contains(space))
			throw new RuntimeException("Tried to add a space already in path");
	}

	public void remove(Space space) {
		if(!orderedSpaces.isEmpty()) {
			orderedSpaces.remove(orderedSpaces.size() - 1);
			containedSpaces.remove(space);
		}
	}
	
	public boolean contains(Space space) {
		return containedSpaces.contains(space);
	}
	
	private void verifySpaceIsAdjacentToPathEnd(Space space) {
		if(!orderedSpaces.isEmpty() && !getEnd().isAdjacentTo(space))
			throw new RuntimeException("Attempted to append non adjacent space to the end of a path");
	}
	
	public boolean spaceIsAdjacentToo(Space otherSpace) {
		return !orderedSpaces.isEmpty() && !getEnd().isAdjacentTo(otherSpace);
	}

	public PlayingGridSpace getStart() {
		return orderedSpaces.isEmpty() ? null : orderedSpaces.get(0);
	}
	
	public PlayingGridSpace getEnd() {
		return orderedSpaces.isEmpty() ? null : orderedSpaces.get(orderedSpaces.size() - 1);
	}
	
	public Iterator<PlayingGridSpace> getIterator() {
		return orderedSpaces.iterator();
	}

	public int getLength() {
		return orderedSpaces.size() - 1;
	}
}
