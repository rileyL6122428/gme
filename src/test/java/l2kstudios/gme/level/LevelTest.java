package l2kstudios.gme.level;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LevelTest {
	
	private Level level;
	private Grid playingGrid;
	
	@Before
	public void setup() {
		playingGrid = new Grid();
		playingGrid.setHeight(12);
		playingGrid.setWidth(6);
		
		level = new Level();
		level.setPlayingGrid(playingGrid);
		
		Position defaultCursorPosition = level.getCursorPosition();
		assertEquals(0, defaultCursorPosition.getX());
		assertEquals(0, defaultCursorPosition.getY());
	}
	
	@Test
	public void moveCursorPosition_xAndYInGridBounds_setsGridBoundsToTheSuppliedCoords() {
		level.moveCursorPositionBy(1, 2);
		
		Position cursorPosition = level.getCursorPosition();
		assertEquals(1, cursorPosition.getX());
		assertEquals(2, cursorPosition.getY());
	}
	
	@Test
	public void moveCursorPosition_yBecomesLessThan0_cursorWrapsToBottomOfGrid() {
		level.moveCursorPositionBy(0, -1);
		
		Position cursorPosition = level.getCursorPosition();
		assertEquals(0, cursorPosition.getX());
		assertEquals(11, cursorPosition.getY());
	}
	
	@Test
	public void moveCursorPosition_yBecomesGreaterThanHeightMinus1_cursorWrapsToTopOfGrid() {
		level.moveCursorPositionBy(0, 13);
		
		Position cursorPosition = level.getCursorPosition();
		assertEquals(0, cursorPosition.getX());
		assertEquals(1, cursorPosition.getY());
	}
	
	@Test
	public void moveCursorPosition_xBecomesLessThan0_cursorWrapsToRightSideOfGrid() {
		level.moveCursorPositionBy(-1, 0);
		
		Position cursorPosition = level.getCursorPosition();
		assertEquals(11, cursorPosition.getX());
		assertEquals(0, cursorPosition.getY());
	}
	
	@Test
	public void moveCursorPosition_xBecomesGreaterThanWidthMinus1_cursorWrapsToLeftSideOfGrid() {
		level.moveCursorPositionBy(7, 0);
		
		Position cursorPosition = level.getCursorPosition();
		assertEquals(1, cursorPosition.getX());
		assertEquals(0, cursorPosition.getY());
	}

}
