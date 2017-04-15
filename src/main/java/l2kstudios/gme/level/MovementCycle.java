package l2kstudios.gme.level;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;

import l2kstudios.mathutils.LongArithmetic;

public class MovementCycle {
	
	private int peekCount;
	private Map<Unit, Long> invertedUnitSpeeds;
	private long speedLCM;
	private List<List<Unit>> moveSpread;
	private List<Unit> collectedMoveSpreed;
	private List<Unit> moveOrder;
	
	public void setUnits(List<Unit> units) {
		configureInvertedUnitSpeeds(units);
		configureMoveSpread(units);
		setMoveOrder();
	}
	
	private void setMoveOrder() {
		moveOrder = new ArrayList<Unit>();
		
		for(List<Unit> moveSpreadNode : moveSpread) {
			moveOrder.addAll(moveSpreadNode);
		}
	}

	private void configureMoveSpread(List<Unit> units) {
		initializeMoveSpread(units);
		populateMoveSpread();
		sortMoveSpreadNodes();
	}
	
	private void sortMoveSpreadNodes() {
		moveSpread.forEach((moveSpreadNode) -> {
			moveSpreadNode.sort(new Comparator<Unit>(){
				@Override
				public int compare(Unit unit1, Unit unit2) {
					return (int)(unit1.getSpeed() - unit2.getSpeed());
				}
			});
		});
		
	}

	private void initializeMoveSpread(List<Unit> units) {
		moveSpread = new ArrayList<List<Unit>>();
		for(int idx = 0; idx < speedLCM; idx++) {
			moveSpread.add(new ArrayList<Unit>());
		}
	}
	
	private void populateMoveSpread() {
		for(Unit unit : invertedUnitSpeeds.keySet()) {
			long invertedSpeed = invertedUnitSpeeds.get(unit);
			for(long speedMultiple = invertedSpeed; speedMultiple < speedLCM; speedMultiple += invertedSpeed) {
				List<Unit> moveSpreadNode = moveSpread.get((int)speedMultiple - 1);
				moveSpreadNode.add(unit);
			}
		}
	}

	private void configureInvertedUnitSpeeds(List<Unit> units) {
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
	
	
	public void removeUnit(Unit unit) {
		
	}
	
	public List<Unit> getOrder() {
		return moveOrder;
	}
}
