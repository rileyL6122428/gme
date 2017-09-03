package l2kstudios.gme.model.grid.position;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PositionCacheTest {

	@Test
	public void get__returnsPositionWithMatchingXAndY() {
		Position position = Position.fromCached(2, 3);
		assertEquals(2, position.getX());
		assertEquals(3, position.getY());
	}
	
	@Test
	public void get__positionReturnedWithSameCoordinatesAreEqual() {
		Position position = Position.fromCached(2, 3);
		Position samePosition = Position.fromCached(2, 3);
		assertTrue(position.equals(samePosition));
	}

}
