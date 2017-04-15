package l2kstudios.gme.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;

import l2kstudios.mathutils.LongArithmetic;

public class MovementCycle {
	
	private int peekCount;
	private Map<Unit, Integer> invertedUnitSpeeds;
	private List<Unit> moveOrder;
	
	public void setUnits(List<Unit> units) {
		List<Long> unitSpeeds = unitSpeeds(units);
		Long speedLCM = LongArithmetic.lcm(unitSpeeds);
		Long invertedSpeeds = LongArithmetic.invertDivisors(speedLCM, unitSpeeds);
	}
	
	private List<Long> unitSpeeds(List<Unit> units) {
		List<Long> unitSpeeds = new ArrayList<Long>();
		
		for(Unit unit : units) {
			unitSpeeds.add(unit.getSpeed());
		}
		
		return unitSpeeds;
	}
	
	
	public void removeUnit(Unit unit) {
		
	}
	
	public List<Unit> getOrder() {
		return null;
	}
}
