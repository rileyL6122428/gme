package l2kstudios.gme.model.grid.playinggrid;

import static l2kstudios.gme.model.unit.Unit.Team.ALLY;
import static l2kstudios.gme.model.unit.Unit.Team.ENEMY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import l2kstudios.gme.model.unit.Unit;

public class PlayingGridSpaceTest {
	
	private PlayingGridSpace playingGridSpace;
	
	@Before
	public void setup() {
		playingGridSpace = new PlayingGridSpace();
	}
	
	@Test
	public void canBeTraversedBy_isNotOccupiable_returnsFalse() {
		Unit unit = new Unit();
		playingGridSpace.setOccupiable(false);
		
		assertFalse(playingGridSpace.canBeTraversedBy(unit));
	}
	
	@Test
	public void canBeTraversedBy_containsUnitOfOpposingTeam_returnsFalse() {
		Unit unit = new Unit(){{ setTeam(ALLY); }};
		Unit occupyingUnit = new Unit(){{ setTeam(ENEMY); }};
		playingGridSpace.setOccupier(occupyingUnit);;
		
		assertFalse(playingGridSpace.canBeTraversedBy(unit));
	}
	
	@Test
	public void canBeTraversedBy_isOccupiableAndDoesNotContainUnit_returnsTrue() {
		Unit unit = new Unit(){{ setTeam(ALLY); }};
		playingGridSpace.setOccupiable(true);;
		
		assertTrue(playingGridSpace.canBeTraversedBy(unit));
	}
	
	@Test
	public void canBeTraversedBy_containsUnitOfSameTeam_returnsTrue() {
		Unit unit = new Unit(){{ setTeam(ALLY); }};
		Unit occupyingUnit = new Unit(){{ setTeam(ALLY); }};
		playingGridSpace.setOccupier(occupyingUnit);;
		
		assertTrue(playingGridSpace.canBeTraversedBy(unit));
	}

}
