package l2kstudios.gme.model.movement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.mathutils.LongArithmetic;

import static l2kstudios.gme.model.unit.Unit.StatType.*;

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
			unitSpeeds.add(unit.get(SPEED));
		}
		
		return unitSpeeds;
	}
	
	public long getInvertedSpeed(Unit unit) {
		return invertedUnitSpeeds.get(unit);
	}
	
	public Set<Unit> getUnitInterator() {
		return invertedUnitSpeeds.keySet();
	}
	
	public long getSpeedLCM() {
		return speedLCM;
	}
}
