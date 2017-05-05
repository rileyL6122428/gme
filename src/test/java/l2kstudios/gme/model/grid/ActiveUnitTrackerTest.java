package l2kstudios.gme.model.grid;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class ActiveUnitTrackerTest {

	private ActingUnitTracker actingUnitTracker;
	
	private MovementCycle movementCycle;
	
	private Unit fastest;
	private Unit medium;
	private Unit slowest;
	
	@Before
	public void setup() {
		fastest = new Unit(){{ setSpeed(9); }};
		medium = new Unit(){{ setSpeed(8); }};
		slowest = new Unit(){{ setSpeed(7); }};
		
		movementCycle = new MovementCycle(new ArrayList<Unit>(){{
			add(fastest);
			add(medium);
			add(slowest);
		}});
		
		actingUnitTracker = new ActingUnitTracker(movementCycle);
	}
	
	@Test
	public void getActiveUnit_initialCall_returnsTheFastestUnitAndTakesThemOffStandby() {
		assertEquals(fastest, actingUnitTracker.getActingUnit());
	}
	
	@Test
	public void getActiveUnit_notInitialCallAndUnitNotRevertedToStandBy_returnsThePreviouslyReturnedUnit() {
		assertEquals(fastest, actingUnitTracker.getActingUnit());
		assertEquals(fastest, actingUnitTracker.getActingUnit());
	}
	
	@Test
	public void getActiveUnit_notInitialCallAndUnitRevertedToStandBy_returnsTheNextUnitInTheMoveCycle() {
		fastest.endTurn();
		assertEquals(medium, actingUnitTracker.getActingUnit());
	}

}
