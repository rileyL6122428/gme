package l2kstudios.gme.movement;

import java.util.List;

import l2kstudios.gme.level.Unit;

public class MovementCycle {
	
	private MoveSpread moveSpread;
	private UnitMovementData unitMovementData;
	private List<Unit> moveOrder;
	
	public MovementCycle() {} 
	
	public MovementCycle(List<Unit> units) {
		setUnits(units);
	}
	
	public void setUnits(List<Unit> units) {
		unitMovementData = new UnitMovementData(units);
		moveSpread = new MoveSpread(unitMovementData);
		moveOrder = moveSpread.getCondensed();
	}

	public Unit getNext() {
		return moveOrder.get(0);
	}
	
	public void shift() {
		Unit unit = moveOrder.get(0);
		moveOrder.remove(0);
		moveOrder.add(unit);
	}
	
	public List<Unit> getOrder() {
		return moveOrder;
	}
}
