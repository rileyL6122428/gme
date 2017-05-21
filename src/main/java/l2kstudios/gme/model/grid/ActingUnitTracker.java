package l2kstudios.gme.model.grid;

import java.util.List;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class ActingUnitTracker {
	
	private MovementCycle movementCycle;
	private Unit actingUnit;

	public Unit getActingUnit() {
		if(actingUnit.turnIsOver()) {
			movementCycle.shift();
			getNextActingUnit();
		}
		
		return actingUnit;
	}
	
	private void getNextActingUnit() {
		actingUnit = movementCycle.getNext();
		actingUnit.beginTurn();
	}
	
	public List<Unit> getUnitMoveOrder() {
		return movementCycle.getOrder();
	}
	
	public void configureMovementCycle(List<Unit> units) {
		movementCycle = new MovementCycle(units);
		actingUnit = movementCycle.getNext();
		actingUnit.beginTurn();
	}
}
