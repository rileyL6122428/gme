package l2kstudios.gme.model.action.rangeofeffect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import l2kstudios.gme.model.grid.Position;

public class DeltaTest {
	

	@Test
	public void constructor_providedTwoPositions_xAndYAreDifferenceOfPositionCoords() {
		Position positionA = new Position(3, 4);
		Position positionB = new Position(4, 4);
		
		Delta delta = new Delta(positionA, positionB);
		
		assertEquals(1, delta.getX());
		assertEquals(0, delta.getY());
	}

}
