package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlaceableTest {
	
	private Placeable placeable;
	private Space space;
	
	@Test
	public void place__setsPlaceableSpaceAndTheOccupierOfTheSpace() {
		placeable = new Placeable();
		space = new Space();
		
		placeable.place(space);
		
		assertEquals(space, placeable.getOccupiedSpace());
		assertEquals(placeable, space.getOccupier());
	}

}
