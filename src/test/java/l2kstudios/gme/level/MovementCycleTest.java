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
		Unit fastestUnit = new Unit(){{setSpeed(7);}};
		Unit midSpeedUnit = new Unit(){{setSpeed(3);}};
		Unit slowestUnit = new Unit(){{setSpeed(2);}};
		List<Unit> units = Arrays.asList(slowestUnit, midSpeedUnit, fastestUnit);
		
		moveCycle = new MovementCycle();
		moveCycle.setUnits(units);
		
		List<Unit> moveOrder = moveCycle.getOrder();
		
		List<Unit> expectedOrder = Arrays.asList(
				fastestUnit, //6
				fastestUnit, //12
				midSpeedUnit, //14
				fastestUnit, //18
				slowestUnit, //21
				fastestUnit, //24
				midSpeedUnit, //28
				fastestUnit, //30
				fastestUnit, //36
				slowestUnit, //42
				midSpeedUnit, //42
				fastestUnit); //42
		assertEquals(expectedOrder.size(), moveOrder.size());
		
		for(int idx = 0; idx < expectedOrder.size(); idx++) {
			assertEquals(expectedOrder.get(idx), moveOrder.get(idx));
		}
	}

}
