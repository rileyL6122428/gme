package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.position.Position;
import l2kstudios.gme.testutils.SpacesFactory;

public class SpaceTest {
	
	@Test
	public void getPosition__returnsTheResultOfPlayingGridsPositionOfMethod() {
		Space space = new Space();
		PlayingGrid playingGrid = mock(PlayingGrid.class);
		Position position = Position.fromCached(0, 0);
		
		space.setGrid(playingGrid);
		when(playingGrid.positionOf(space)).thenReturn(position);
		
		Position spacePosition = space.getPosition();
		
		assertEquals(position, spacePosition);
	}

	@Test
	public void isOccupied_occupierSet_returnsTrue() {
		Space space = new Space();
		assertFalse(space.isOccupied());
	}
	
	@Test
	public void isOccupied_occupierNotSet_returnsTrue() {
		Space space = new Space();
		Placeable placeable = mock(Placeable.class);		
		space.setOccupier(placeable);
		assertTrue(space.isOccupied());
	}
	
	@Test
	public void isAdjacentTo_spaceWithinOneSpaceOfSpace_returnsTrue() {
		PlayingGrid playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyPlayingGridSpaces(12, 12));
		
		Space space = playingGrid.getSpaceAt(3, 3);
		
		assertTrue(space.isAdjacentTo(playingGrid.getSpaceAt(3, 2)));
		assertTrue(space.isAdjacentTo(playingGrid.getSpaceAt(3, 4)));
		assertTrue(space.isAdjacentTo(playingGrid.getSpaceAt(2, 3)));
		assertTrue(space.isAdjacentTo(playingGrid.getSpaceAt(4, 3)));
	}
	
	@Test
	public void isAdjacentTo_spaceNotWithinOneSpaceOfSpace_returnsFalse() {
		PlayingGrid playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyPlayingGridSpaces(12, 12));
		
		Space space = playingGrid.getSpaceAt(3, 3);
		
		
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(4, 4)));
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(2, 2)));
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(2, 4)));
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(4, 2)));
		
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(0, 0)));
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(11, 11)));
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(11, 0)));
		assertFalse(space.isAdjacentTo(playingGrid.getSpaceAt(0, 11)));
	}
}
