package l2kstudios.gme.model.action.rangeofeffect;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Ignore;
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
	
	static class RotationTestData {
		
		private double rotationDegrees;
		
		private int deltaX;
		private int deltaY;
		
		private int rotatedDeltaX;
		private int rotatedDeltaY;
		
		public double getRotation() {
			return rotationDegrees;
		}
		public void setRotation(double rotation) {
			this.rotationDegrees = rotation;
		}
		public int getDeltaX() {
			return deltaX;
		}
		public void setDeltaX(int deltaX) {
			this.deltaX = deltaX;
		}
		public int getDeltaY() {
			return deltaY;
		}
		public void setDeltaY(int deltaY) {
			this.deltaY = deltaY;
		}
		public int getRotatedDeltaX() {
			return rotatedDeltaX;
		}
		public void setRotatedDeltaX(int rotatedDeltaX) {
			this.rotatedDeltaX = rotatedDeltaX;
		}
		public int getRotatedDeltaY() {
			return rotatedDeltaY;
		}
		public void setRotatedDeltaY(int rotatedDeltaY) {
			this.rotatedDeltaY = rotatedDeltaY;
		}
	}
	
	@Test
	public void getRotatedCoordinate_0DegreeRotation_returnsDeltaCoordinate() {
		new ArrayList<RotationTestData>(){{
			add(new RotationTestData(){{
				setDeltaX(0);
				setDeltaY(0);
				setRotation(0);
				setRotatedDeltaX(0);
				setRotatedDeltaY(0);
			}});
			
			add(new RotationTestData(){{
				setDeltaX(2);
				setDeltaY(3);
				setRotation(0);
				setRotatedDeltaX(2);
				setRotatedDeltaY(3);
			}});
			
		}}.forEach(this::verifyRotationReturnsCorrectDeltaCoordinates);
	}
	
	@Test
	public void getRotatedCoordinate_90DegreeRotation_returnsTransformedDeltaCoordinate() {
		new ArrayList<RotationTestData>(){{
			add(new RotationTestData(){{
				setDeltaX(0);
				setDeltaY(0);
				setRotation(90);
				setRotatedDeltaX(0);
				setRotatedDeltaY(0);
			}});
			
			add(new RotationTestData(){{
				setDeltaX(2);
				setDeltaY(3);
				setRotation(90);
				setRotatedDeltaX(3);
				setRotatedDeltaY(-2);
			}});
			
		}}.forEach(this::verifyRotationReturnsCorrectDeltaCoordinates);
	}
	
	@Test
	public void getRotatedCoordinate_180DegreeRotation_returnsTransformedDeltaCoordinate() {
		new ArrayList<RotationTestData>(){{
			add(new RotationTestData(){{
				setDeltaX(0);
				setDeltaY(0);
				setRotation(180);
				setRotatedDeltaX(0);
				setRotatedDeltaY(0);
			}});
			
			add(new RotationTestData(){{
				setDeltaX(2);
				setDeltaY(3);
				setRotation(180);
				setRotatedDeltaX(-2);
				setRotatedDeltaY(-3);
			}});
			
		}}.forEach(this::verifyRotationReturnsCorrectDeltaCoordinates);
	}
	
	@Test
	public void getRotatedCoordinate_270DegreeRotation_returnsTransformedDeltaCoordinate() {
		new ArrayList<RotationTestData>(){{
			add(new RotationTestData(){{
				setDeltaX(0);
				setDeltaY(0);
				setRotation(270);
				setRotatedDeltaX(0);
				setRotatedDeltaY(0);
			}});
			
			add(new RotationTestData(){{
				setDeltaX(2);
				setDeltaY(3);
				setRotation(270);
				setRotatedDeltaX(-3);
				setRotatedDeltaY(2);
			}});
			
		}}.forEach(this::verifyRotationReturnsCorrectDeltaCoordinates);
	}
	
	
	
	private void verifyRotationReturnsCorrectDeltaCoordinates(RotationTestData testData) {
		Delta delta = new Delta(testData.getDeltaX(), testData.getDeltaY());
		assertEquals(testData.getRotatedDeltaX(), delta.getRotatedX(testData.getRotation()));
		assertEquals(testData.getRotatedDeltaY(), delta.getRotatedY(testData.getRotation()));
	}
}
