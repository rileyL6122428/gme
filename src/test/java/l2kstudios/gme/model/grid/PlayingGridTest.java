package l2kstudios.gme.model.grid;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGridTest {
	
	private PlayingGrid playingGrid;
	
	private Unit unit1;
	private Unit unit2;
	private List<Unit> units;
	
	private ActionMenu actionMenu;
	
	@Before
	public void setup() throws Exception {
		actionMenu = new ActionMenu();
		setupUnits();
		setupGrid();
	}
	
	private void setupUnits() {
		unit1 = new Unit();
		unit1.setPosition(new Position (0, 0));
		unit1.setSpeed(4);
		unit1.setTeam(Unit.Team.ALLY);
		unit1.setEnergy(new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}});
		
		unit2 = new Unit();
		unit2.setPosition(new Position (3, 0));
		unit2.setSpeed(3);
		unit2.setTeam(Unit.Team.ALLY);
		unit2.setEnergy(new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}});
		
		units = Arrays.asList(unit1, unit2);
	}
	
	private void setupGrid() throws Exception {
		playingGrid = new PlayingGrid();
		playingGrid.setDimensions(new Dimension(20, 20));
		playingGrid.setUnits(units);
		playingGrid.setActionMenu(actionMenu);
		playingGrid.afterPropertiesSet();
	}
	
	@Test
	public void initialState__playingGridIsMovingUnit() {
		assertTrue(playingGrid.inInPlayingGridState(PlayingGrid.State.MOVING_UNIT));
	}
	
	@Test
	public void isActingUnit_noMovesMade_returnsFastestUnit() {
		assertTrue(playingGrid.isActingUnit(unit1));
	}
	
	@Test
	public void selectSpace_cursorOnPositionActingUnitCannotMoveTo_actingUnitDoesNotMove() {
		playingGrid.moveCursorBy(3, 3);
		playingGrid.selectSpace();
		
		assertTrue(playingGrid.isActingUnit(unit1));
		assertEquals(unit1, playingGrid.getUnitAt(0, 0));
	}
	
	@Test
	public void selectSpace_cursorOnPositionActingUnitCanMoveTo_actingUnitMovesAndBeginsMoveSelection() {
		playingGrid.moveCursorBy(0, 2);
		playingGrid.selectSpace();
		
		assertTrue(playingGrid.isActingUnit(unit1));
		assertEquals(unit1, playingGrid.getUnitAt(0, 2));
		assertTrue(unit1.isInBoardState(Unit.BoardState.CHOOSING_ACTION));
		assertTrue(playingGrid.inInPlayingGridState(PlayingGrid.State.SELECTING_ACTION));
	}
}
