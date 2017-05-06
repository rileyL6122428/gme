package l2kstudios.gme.model.grid;

import java.util.List;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class ActingUnitTracker {
	
	private MovementCycle movementCycle;
	private Unit actingUnit;
	
	public ActingUnitTracker(MovementCycle movementCycle) {
		this.movementCycle = movementCycle;
		getNextActingUnit();
	}

	public Unit getActingUnit() {
		if(actingUnit.isInBoardState(Unit.BoardState.STAND_BY)) {
			movementCycle.shift();
			getNextActingUnit();
		}
		
		return actingUnit;
	}
	
	private void getNextActingUnit() {
		actingUnit = movementCycle.getNext();
		actingUnit.registerTurnStart();
	}
	
	public List<Unit> getUnitMoveOrder() {
		return movementCycle.getOrder();
	}
}
