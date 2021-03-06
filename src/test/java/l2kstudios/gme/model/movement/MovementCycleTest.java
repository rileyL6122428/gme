package l2kstudios.gme.model.movement;

import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import l2kstudios.gme.model.unit.Stat;
import l2kstudios.gme.model.unit.Unit;
import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class MovementCycleTest {
	
	private MovementCycle moveCycle;
	
	@After
	public void tearDown() {
		moveCycle = null;
	}
	
	@Test
	public void getCycle__returnsAInverseSpeedMultipleListOfUnits() {
		Unit fastestUnit = unitWithHealthAndSpeedSetTo(1, 7);
		Unit midSpeedUnit = unitWithHealthAndSpeedSetTo(1, 3);
		Unit slowestUnit = unitWithHealthAndSpeedSetTo(1, 2);
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
	
	@Test
	public void rebase_unitsDefeated_moveOrderDoesNotContainDefeatedUnits() {
		Unit fastestUnit = unitWithHealthAndSpeedSetTo(1, 7);
		Unit midSpeedUnit = unitWithHealthAndSpeedSetTo(1, 3);
		Unit slowestUnit = unitWithHealthAndSpeedSetTo(1, 2);
		List<Unit> units = Arrays.asList(slowestUnit, midSpeedUnit, fastestUnit);
		
		moveCycle = new MovementCycle();
		moveCycle.setUnits(units);
		midSpeedUnit.decreaseStat(HEALTH, midSpeedUnit.get(HEALTH));
		moveCycle.rebase(units);
		
		List<Unit> moveOrder = moveCycle.getOrder();
		
		List<Unit> expectedOrder = Arrays.asList(
				fastestUnit, //6
				fastestUnit, //12
				fastestUnit, //18
				slowestUnit, //21
				fastestUnit, //24
				fastestUnit, //30
				fastestUnit, //36
				slowestUnit, //42
				fastestUnit); //42
				
		assertExptectedOrderAndActualOrderAreSame(expectedOrder, moveOrder);
	}
	
	private void assertExptectedOrderAndActualOrderAreSame(List<Unit> expectedOrder, List<Unit> actualOrder) {
		assertEquals(expectedOrder.size(), actualOrder.size());
		
		for(int idx = 0; idx < expectedOrder.size(); idx++) {
			assertEquals(expectedOrder.get(idx), actualOrder.get(idx));
		}
	}
	
	private Unit unitWithHealthAndSpeedSetTo(long newUnitHealth, long newUnitSpeed) {
		return new Unit(){{
			setStat(HEALTH, new Stat() {{
				this.setMaxCap(newUnitHealth);
				this.setCap(newUnitHealth);
				this.setVal(newUnitHealth);
			}});
			
			setStat(SPEED, new Stat(){{
				this.setMaxCap(newUnitSpeed);
				this.setCap(newUnitSpeed);
				this.setVal(newUnitSpeed);
			}});
		}};
	}

}
