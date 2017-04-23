package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import l2kstudios.gme.model.grid.GridUtils;

public class GridUtilsTest {
	
	class DistanceBetweenTestData {
		private int expectedDistance;
		private Position posA;
		private Position posB;
		public int getExpectedDistance() {
			return expectedDistance;
		}
		public void setExpectedDistance(int expectedDistance) {
			this.expectedDistance = expectedDistance;
		}
		public Position getPosA() {
			return posA;
		}
		public void setPosA(Position posA) {
			this.posA = posA;
		}
		public Position getPosB() {
			return posB;
		}
		public void setPosB(Position posB) {
			this.posB = posB;
		}
	}
	
	@Test
	public void distanceBetween__returnsTheCorrectDistanceForProvidedPositions() {
		distanceBetweenTestDataSets()
		.forEach(this::verifyDistanceBetweenResult);
	}
	
	private List<DistanceBetweenTestData> distanceBetweenTestDataSets() {
		return new ArrayList<DistanceBetweenTestData>() {{
			add(new DistanceBetweenTestData() {{
				setExpectedDistance(3);
				setPosA(new Position(1, 1));
				setPosB(new Position(2, 3));
			}});
		}};
	}
	
	private void verifyDistanceBetweenResult(DistanceBetweenTestData dataSet) {
		int expectedDistance = dataSet.getExpectedDistance();
		Position posA = dataSet.getPosA();
		Position posB = dataSet.getPosB();
		assertEquals(dataSet.getExpectedDistance(), GridUtils.distanceBetween(posA, posB));
	}

}
