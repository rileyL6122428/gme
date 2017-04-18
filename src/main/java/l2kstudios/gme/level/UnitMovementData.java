package l2kstudios.gme.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import l2kstudios.mathutils.LongArithmetic;

public class UnitMovementData {
	private Map<Unit, Long> invertedUnitSpeeds;
	private long speedLCM;
	
	public UnitMovementData(List<Unit> units) {
		List<Long> unitSpeeds = unitSpeeds(units);
		speedLCM = LongArithmetic.lcm(unitSpeeds);
		List<Long> invertedSpeeds = LongArithmetic.invertDivisors(speedLCM, unitSpeeds);
		
		invertedUnitSpeeds = new HashMap<Unit, Long>();
		for(int idx = 0; idx < units.size(); idx++) {
			invertedUnitSpeeds.put(units.get(idx), invertedSpeeds.get(idx));
		}
	}
	
	private List<Long> unitSpeeds(List<Unit> units) {
		List<Long> unitSpeeds = new ArrayList<Long>();
		
		for(Unit unit : units) {
			unitSpeeds.add(unit.getSpeed());
		}
		
		return unitSpeeds;
	}
	
	public long getInvertedSpeed(Unit unit) {
		return invertedUnitSpeeds.get(unit);
	}
	
	public Iterator<Unit> getUnitInterator() {
		return (Iterator<Unit>) invertedUnitSpeeds.keySet();
	}
	
	public long getLCM() {
		return speedLCM;
	}
}
