package l2kstudios.gme.model.grid;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	
	private List<Space> row1;
	private List<Space> row2;
	private List<Space> row3;
	private List<Space> row4;
	
	private ActionMenu actionMenu;
	
	@Before
	public void setup() throws Exception {
		actionMenu = new ActionMenu();
		setupUnits();
		setupRows();
		setupGrid();
	}
	

	private void setupUnits() {
		unit1 = new Unit();
		unit1.setSpeed(4);
		unit1.setTeam(Unit.Team.ALLY);
		unit1.setEnergy(new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}});
		
		unit2 = new Unit();
		unit2.setSpeed(3);
		unit2.setTeam(Unit.Team.ALLY);
		unit2.setEnergy(new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}});
		
	}
	
	private void setupRows() {
		row1 = new ArrayList<Space>() {{
			add(new Space(){{ setOccupier(unit1); }});
			add(new Space());
			add(new Space());
			add(new Space());
		}};
		
		row2 = new ArrayList<Space>() {{
			add(new Space());
			add(new Space(){{ setOccupier(unit2); }});
			add(new Space());
			add(new Space());
		}};
		
		row3 = new ArrayList<Space>() {{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}};
		
		row4 = new ArrayList<Space>() {{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}};
	}
	
	private void setupGrid() throws Exception {
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(new ArrayList<List<Space>>(){{
			add(row1);
			add(row2);
			add(row3);
			add(row4);
		}});
		playingGrid.setActionMenu(actionMenu);
		playingGrid.afterPropertiesSet();
	}
	
	@Test
	public void isActingUnit_noMovesMade_returnsFastestUnit() {
		assertTrue(playingGrid.isActingUnit(unit1));
	}
	
	@Test
	public void selectSpace_cursorOnPositionActingUnitCannotMoveTo_actingUnitDoesNotMove() {
		playingGrid.moveCursorBy(3, 3);
		playingGrid.select();
		
		assertTrue(playingGrid.isActingUnit(unit1));
		assertEquals(unit1, playingGrid.getUnitAt(0, 0));
	}
	
	
}
