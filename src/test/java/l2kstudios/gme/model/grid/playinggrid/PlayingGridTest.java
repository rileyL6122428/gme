package l2kstudios.gme.model.grid.playinggrid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.testutils.SpacesFactory;

public class PlayingGridTest {
	
	private PlayingGrid playingGrid;
	
	@Before
	public void setup() {
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyGridSpaces(12, 12));
	}
	
	@Test
	public void getUnits__returnsAListOfAllUnitsOnThePlayingGrid() {
		Unit unit1 = new Unit();
		Unit unit2 = new Unit();
		Unit unit3 = new Unit();
		
		playingGrid.place(unit1, 0, 0);
		playingGrid.place(unit2, 3, 4);
		playingGrid.place(unit3, 8, 11);
		
		List<Unit> units = playingGrid.getUnits();
		
		assertEquals(3, units.size());
		assertTrue(units.contains(unit1));
		assertTrue(units.contains(unit2));
		assertTrue(units.contains(unit3));
	}
	
	@Test
	public void getAlliedUnits__returnsAListOfAllUnitsOnThePlayingGridWithTeamAlly() {
		Unit unit1 = new Unit(){{ setTeam(Unit.Team.ALLY); }};
		Unit unit2 = new Unit(){{ setTeam(Unit.Team.ALLY); }};
		Unit unit3 = new Unit(){{ setTeam(Unit.Team.ENEMY); }};
		
		playingGrid.place(unit1, 0, 0);
		playingGrid.place(unit2, 3, 4);
		playingGrid.place(unit3, 8, 11);
		
		List<Unit> units = playingGrid.getAlliedUnits();
		
		assertEquals(2, units.size());
		assertTrue(units.contains(unit1));
		assertTrue(units.contains(unit2));
	}
	
	@Test
	public void getEnemyUnits__returnsAListOfAllUnitsOnThePlayingGridWithTeamEnemy() {
		Unit unit1 = new Unit(){{ setTeam(Unit.Team.ALLY); }};
		Unit unit2 = new Unit(){{ setTeam(Unit.Team.ALLY); }};
		Unit unit3 = new Unit(){{ setTeam(Unit.Team.ENEMY); }};
		
		playingGrid.place(unit1, 0, 0);
		playingGrid.place(unit2, 3, 4);
		playingGrid.place(unit3, 8, 11);
		
		List<Unit> units = playingGrid.getEnemyUnits();
		
		assertEquals(1, units.size());
		assertTrue(units.contains(unit3));
	}
	
	
}
