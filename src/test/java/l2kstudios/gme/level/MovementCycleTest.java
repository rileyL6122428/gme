package l2kstudios.gme.level;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

public class MovementCycleTest {
	
	private MovementCycle moveCycle;
	
	@After
	public void setup() {
		moveCycle = null;
	}
	
	@Test
	public void getCycle__returnsAInverseSpeedMultipleListOfUnits() {
		Unit fastestUnit = new Unit(){{setSpeed(11);}};
		Unit midSpeedUnit = new Unit(){{setSpeed(7);}};
		Unit slowestUnit = new Unit(){{setSpeed(3);}};
		List<Unit> units = Arrays.asList(slowestUnit, midSpeedUnit, fastestUnit);
		
		moveCycle = new MovementCycle();
		moveCycle.setUnits(units);
		
		List<Unit> moveOrder = moveCycle.getOrder();
		
		List<Unit> expectedOrder = Arrays.asList(
				fastestUnit, 
				midSpeedUnit, 
				fastestUnit, 
				fastestUnit, 
				midSpeedUnit, 
				slowestUnit, 
				slowestUnit, 
				fastestUnit, 
				midSpeedUnit, 
				fastestUnit,
				fastestUnit,
				midSpeedUnit,
				fastestUnit,
				slowestUnit,
				midSpeedUnit,
				fastestUnit,
				fastestUnit,
				midSpeedUnit,
				fastestUnit,
				slowestUnit,
				midSpeedUnit,
				fastestUnit);
		assertEquals(expectedOrder.size(), moveOrder.size());
		
		for(int idx = 0; idx < expectedOrder.size(); idx++) {
			assertEquals(expectedOrder.get(idx), moveOrder.get(idx));
		}
	}

}
