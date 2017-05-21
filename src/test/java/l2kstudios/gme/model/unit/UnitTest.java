package l2kstudios.gme.model.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	
	private Unit unit;
	
	@Before
	public void setup() {
		unit = new Unit();
	}
	
	@Test
	public void instantiation__unitStartsWithTurnOver() {
		assertTrue(unit.turnIsOver());
	}
	
	@Test
	public void registerTurnStart__turnOverReturnsFalseUntilRegisterTurnEndIsCalled() {
		unit.beginTurn();
		assertFalse(unit.turnIsOver());
		unit.endTurn();
		assertTrue(unit.turnIsOver());
	}

}
