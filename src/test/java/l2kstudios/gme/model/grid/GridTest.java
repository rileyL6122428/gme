package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import l2kstudios.gme.model.customerror.MethodNotImplementedException;
import l2kstudios.gme.testutils.SpacesFactory;

public class GridTest {
	
	private TwoDimensionalGrid grid;
	private List<List<Space>> spaces;
	
	private static int GRID_WIDTH = 5;
	private static int GRID_HEIGHT = 5;
	
	@Before
	public void before() {
		spaces = SpacesFactory.emptyGridSpaces(GRID_WIDTH, GRID_HEIGHT);
		
		grid = new TwoDimensionalGrid();
		grid.setSpaces(spaces);
	}
	
	
	@Test(expected=MethodNotImplementedException.class)
	public void initialize__throwsNotImplementedError() {
		grid.initialize();
	}
	
	@Test(expected=MethodNotImplementedException.class)
	public void select__throwsNotImplementedError() {
		grid.select();
	}
	
	@Test
	public void moveCursorUp_cursorAtTopOfGrid_cursorWrapsGrid() {
		setCursorToCoordinates(1, 0);
		grid.moveCursorUp();
		verifyCursorPosition(1, GRID_HEIGHT - 1);
	}
	
	@Test
	public void moveCursorUp_cursorNotAtTopOfGrid_cursorMovesUpOneSpace() {
		setCursorToCoordinates(1, 1);
		grid.moveCursorUp();
		verifyCursorPosition(1, 0);
	}
	
	@Test
	public void moveCursorDown_cursorNotAtBottomOfGrid_cursorMovesDownOneSpace() {
		setCursorToCoordinates(1, 0);
		grid.moveCursorDown();
		verifyCursorPosition(1, 1);
	}
	
	@Test
	public void moveCursorDown_cursorAtBottomOfGrid_cursorWrapsToTopOfGrid() {
		setCursorToCoordinates(1, GRID_HEIGHT - 1);
		grid.moveCursorDown();
		verifyCursorPosition(1, 0);
	}
	
	@Test
	public void moveCursorRight_cursorAtRightEdgeOfGrid_cursorWrapsToLeftEdgeOfGrid() {
		setCursorToCoordinates(GRID_WIDTH - 1, 0);
		grid.moveCursorRight();
		verifyCursorPosition(0, 0);
	}
	
	@Test
	public void moveCursorRight_cursorNotAtRightEdgeOfGrid_cursorMovesOneSpaceRight() {
		setCursorToCoordinates(1, 0);
		grid.moveCursorRight();
		verifyCursorPosition(2, 0);
	}
	
	@Test
	public void moveCursorLeft_cursorNotAtLeftEdgeOfGrid_cursorMovesOneSpaceLeft() {
		setCursorToCoordinates(1, 0);
		grid.moveCursorLeft();
		verifyCursorPosition(0, 0);
	}
	
	@Test
	public void moveCursorLeft_cursorAtLeftEdgeOfGrid_cursorWrapsToRightEdgeOfGrid() {
		setCursorToCoordinates(0, 0);
		grid.moveCursorLeft();
		verifyCursorPosition(GRID_WIDTH - 1, 0);
	}
	
	@Test
	public void positionOf__returnsThePositionOfTheProvidedSpace() {
		Space space =grid.getSpaceAt(1, 2);
		Position spacePosition = grid.positionOf(space);
		assertEquals(1, spacePosition.getX());
		assertEquals(2, spacePosition.getY());
	}
	
	@Test(expected=RuntimeException.class)
	public void setSpaces_suppliedSpacesAreUnEven_throws() {
		List<List<Space>> unevenSpaces = new ArrayList<List<Space>>() {{
			add(new ArrayList<Space>(){{ 
				add(new Space());
				add(new Space());
			}});
			
			add(new ArrayList<Space>(){{ 
				add(new Space());
			}});
		}};
		
		grid.setSpaces(unevenSpaces);
	}
	
	@Test
	public void setSpaces__suppliedSpacesAreProvidedAReferenceToTheGrid() {
		for(int x = 0; x < grid.getWidth(); x++) {
			for(int y = 0; y < grid.getHeight(); y++) {
				Space gridSpace = grid.getSpaceAt(x, y);
				assertEquals(grid, gridSpace.getGrid());
			}
		}
	}
	
	private void setCursorToCoordinates(int x, int y) {
		Space space = grid.getSpaceAt(x, y);
		grid.moveCursorTo(space);
		assertEquals(x, space.getPosition().getX());
		assertEquals(y, space.getPosition().getY());
	}
	
	private void verifyCursorPosition(int x, int y) {
		Position cursorPosition = grid.getCursorPosition();
		assertEquals(y, cursorPosition.getY());
		assertEquals(x, cursorPosition.getX());
	}
}
