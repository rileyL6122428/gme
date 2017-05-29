package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGridTest {
	
	private PlayingGrid playingGrid;
	
	private ActingUnitTracker actingUnitTracker;
	
	private Unit actingUnit;
	private Unit notActingUnit;
	
	private List<Unit> row1;
	private List<Unit> row2;
	private List<Unit> row3;
	private List<Unit> row4;
	
	
	@Before
	public void setup() throws Exception {
		setupRows();
		setupUnits();
		setupActingUnitTracker();
		setupGrid();
	}

	private void setupUnits() {
		actingUnit = new Unit();
		actingUnit.setSpeed(4);
		actingUnit.setTeam(Unit.Team.ALLY);
		actingUnit.setEnergy(new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}});
		actingUnit.place(row1.get(1));
		
		notActingUnit = new Unit();
		notActingUnit.setSpeed(3);
		notActingUnit.setTeam(Unit.Team.ALLY);
		notActingUnit.setEnergy(new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}});
		actingUnit.place(row2.get(0));
	}
	
	private void setupActingUnitTracker() {
		actingUnitTracker = mock(ActingUnitTracker.class);
		when(actingUnitTracker.getActingUnit()).thenReturn(actingUnit);
	}
	
	private void setupRows() {
		row1 = new ArrayList<Unit>() {{
			add(new Unit());
			add(new Unit());
			add(new Unit());
			add(new Unit());
		}};
		
		row2 = new ArrayList<Unit>() {{
			add(new Unit());
			add(new Unit());
			add(new Unit());
			add(new Unit());
		}};
		
		row3 = new ArrayList<Unit>() {{
			add(new Unit());
			add(new Unit());
			add(new Unit());
			add(new Unit());
		}};
		
		row4 = new ArrayList<Unit>() {{
			add(new Unit());
			add(new Unit());
			add(new Unit());
			add(new Unit());
		}};
	}
	
	private void setupGrid() throws Exception {
		playingGrid = new PlayingGrid();
		playingGrid.setActingUnitTracker(actingUnitTracker);
		playingGrid.setSpaces(new ArrayList<List<Unit>>(){{
			add(row1);
			add(row2);
			add(row3);
			add(row4);
		}});
	}
	
	@Test
	public void initialize__movesCursorToPositionOfActiveUnit() {
		playingGrid.initialize();
		Position cursorPosition = playingGrid.getCursorPosition();
		Position actingUnitPosition = playingGrid.getCursorPosition();
		assertEquals(actingUnitPosition.getX(), cursorPosition.getX());
		assertEquals(actingUnitPosition.getY(), cursorPosition.getY());
	}
	
	@Test
	public void selectSpace_cursorOnSpaceActingUnitCannotMoveTo_actingUnitDoesNotMoveAndReturnsFalse() {
		playingGrid.initialize();
		
		Position actingUnitInitialPosition = actingUnit.getPosition();
		
		playingGrid.moveCursorDown();
		playingGrid.moveCursorDown();
		playingGrid.moveCursorRight();
		playingGrid.moveCursorRight();
		
		assertFalse(playingGrid.select());
		Position actingUnitPosition = actingUnit.getPosition();
		assertEquals(actingUnitInitialPosition.getX(), actingUnitPosition.getX());
		assertEquals(actingUnitInitialPosition.getY(), actingUnitPosition.getY());
	}
	
	@Test
	public void selectSpace_cursorOnSpaceActingUnitCanMoveTo_actingUnitMovesToSpaceAndReturnsTrue() {
		playingGrid.initialize();
		
		Position actingUnitInitialPosition = actingUnit.getPosition();
		
		playingGrid.moveCursorDown();
		playingGrid.moveCursorDown();
		
		assertTrue(playingGrid.select());
		Position actingUnitPosition = actingUnit.getPosition();
		assertEquals(actingUnitInitialPosition.getX(), actingUnitPosition.getX());
		assertEquals(actingUnitInitialPosition.getY() + 2, actingUnitPosition.getY());
	}
}
