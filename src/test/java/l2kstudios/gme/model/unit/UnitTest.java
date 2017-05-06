package l2kstudios.gme.model.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UnitTest {
	
	private Unit unit;
	
	@Before
	public void setup() {
		unit = new Unit();
	}
	
	@Test
	public void instantiation__unitStartsInStandby() {
		assertTrue(unit.isInBoardState(Unit.BoardState.STAND_BY));
	}
	
	@Test
	public void registerTurnStart__turnOverReturnsFalseUntilRegisterTurnEndIsCalled() {
		unit.registerTurnStart();
		assertFalse(unit.turnOver());
		unit.registerTurnEnd();
		assertTrue(unit.turnOver());
	}

}
