package l2kstudios.gme.model.path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.path.Path;
import l2kstudios.gme.testutils.SpacesFactory;

public class PathTest {
	
	private Path path;
	private PlayingGrid playingGrid;
	
	@Before
	public void setup() {
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyGridSpaces(12, 12));
		path = new Path();
	}
	
	@Test
	public void getLenth__returnsNumberOfSpacesInList() {
		path.add(playingGrid.getSpaceAt(0,0));
		path.add(playingGrid.getSpaceAt(0,1));
		path.add(playingGrid.getSpaceAt(1,1));
		
		assertEquals(3, path.getLength());
	}

	@Test(expected=Exception.class)
	public void addSpace_spaceNotAdjacentToSpaceAtEndOfPath_throws() {
		path.add(playingGrid.getSpaceAt(0, 0));
		path.add(playingGrid.getSpaceAt(2, 0));
	}
	
	@Test(expected=Exception.class)
	public void addSpace_spaceAlreadyInPath_throws() {
		path.add(playingGrid.getSpaceAt(0, 0));
		path.add(playingGrid.getSpaceAt(1, 0));
		path.add(playingGrid.getSpaceAt(1, 1));
		path.add(playingGrid.getSpaceAt(1, 0));
	}
	
	@Test
	public void contains_spaceInPath_returnsTrue() {
		path.add(playingGrid.getSpaceAt(0, 0));
		path.add(playingGrid.getSpaceAt(1, 0));
		path.add(playingGrid.getSpaceAt(1, 1));
		path.add(playingGrid.getSpaceAt(0, 1));
		
		assertTrue(path.contains(playingGrid.getSpaceAt(0, 0)));
		assertTrue(path.contains(playingGrid.getSpaceAt(1, 0)));
		assertTrue(path.contains(playingGrid.getSpaceAt(1, 1)));
		assertTrue(path.contains(playingGrid.getSpaceAt(0, 1)));
	}
	
	@Test
	public void contains_spaceNotInPath_returnsFalse() {
		path.add(playingGrid.getSpaceAt(0, 0));
		path.add(playingGrid.getSpaceAt(1, 0));
		path.add(playingGrid.getSpaceAt(1, 1));
		path.add(playingGrid.getSpaceAt(0, 1));
		
		assertFalse(path.contains(playingGrid.getSpaceAt(2, 0)));
		assertFalse(path.contains(playingGrid.getSpaceAt(1, 2)));
		assertFalse(path.contains(playingGrid.getSpaceAt(10, 6)));
		assertFalse(path.contains(playingGrid.getSpaceAt(2, 2)));
	}
	
}
