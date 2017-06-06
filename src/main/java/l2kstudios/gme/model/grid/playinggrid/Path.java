package l2kstudios.gme.model.grid.playinggrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import l2kstudios.gme.model.grid.Space;

public class Path {
	
	private List<Space> orderedSpaces;
	private Set<Space> containedSpaces;
	
	{
		orderedSpaces = new ArrayList<Space>();
		containedSpaces = new HashSet<Space>();
	}

	public void add(Space space) {
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

	public Space getStart() {
		return orderedSpaces.isEmpty() ? null : orderedSpaces.get(0);
	}
	
	public Space getEnd() {
		return orderedSpaces.isEmpty() ? null : orderedSpaces.get(orderedSpaces.size() - 1);
	}
	
	public Iterator<Space> getIterator() {
		return orderedSpaces.iterator();
	}

	public int getLength() {
		return orderedSpaces.size();
	}
}
