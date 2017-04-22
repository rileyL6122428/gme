package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import l2kstudios.gme.model.grid.Dimension;
import l2kstudios.gme.model.level.Position;

public class DimensionTest {
	
	@Test
	public void isInBounds_positionIsWithinWidthAndHeight_returnsTrue() {
		Dimension dimension = new Dimension(3, 4);
		
		spacesWithinBounds(3, 4).forEach((position) -> {
			assertTrue(dimension.isInBounds(position));
		});
	}
	
	public List<Position> spacesWithinBounds(int xBound, int yBound) {
		return new ArrayList<Position>(){{
			for(int x = 0; x < xBound; x++) {
				for(int y = 0; y < yBound; y++) {
					add(new Position(x, y));
				}
			}
		}};
	}
	
	@Test
	public void isInBounds_positionOutsideOfWidthAndHeight_returnsFalse() {
		Dimension dimension = new Dimension(3, 4);
		
		spacesAlongPerimeter(3, 4).forEach((position) -> {
			assertFalse(dimension.isInBounds(position));
		});
	}
	
	private List<Position> spacesAlongPerimeter(int xBound, int yBound) {
		return new ArrayList<Position>(){{
			for(int x = -1; x <= xBound; x++) {
				add(new Position(x, -1));
				add(new Position(x, yBound));
			}
			
			for(int y = -1; y <= yBound; y++) {
				add(new Position(-1, y));
				add(new Position(xBound, y));
			}
		}};
	}
}
