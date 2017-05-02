package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class SpaceTest {
	
	private Space space;
	
	private PlayingGrid playingGrid;
	private Placeable placeable;
	
	@Before
	public void setup() {
		playingGrid = mock(PlayingGrid.class);
		placeable = mock(Placeable.class);
		
		space = new Space();
	}

	
	@Test
	public void getPosition__returnsTheResultOfPlayingGridsPositionOfMethod() {
		Position position = new Position(0,0);
		when(playingGrid.positionOf(space)).thenReturn(position);
		space.setGrid(playingGrid);
		Position spacePosition = space.getPosition();
		assertEquals(position, spacePosition);
	}
	
	@Test
	public void setOccupier__callsPlaceMethodOnThePlaceable() {
		doNothing().when(placeable).place(any());
		space.setOccupier(placeable);
		verify(placeable).place(space);
	}

	@Test
	public void isOccupied_occupierSet_returnsTrue() {
		assertFalse(space.isOccupied());
	}
	
	@Test
	public void isOccupied_occupierNotSet_returnsTrue() {
		space.setOccupier(placeable);
		assertTrue(space.isOccupied());
	}
}
