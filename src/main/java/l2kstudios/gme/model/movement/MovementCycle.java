package l2kstudios.gme.model.movement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import l2kstudios.gme.model.unit.Unit;

public class MovementCycle {
	
	private MoveSpread moveSpread;
	private UnitMovementData unitMovementData;
	private List<Unit> moveOrder;
	private Set<Unit> activeUnits;
	
	public MovementCycle() {} 
	
	public MovementCycle(List<Unit> units) {
		setUnits(units);
	}
	
	public MovementCycle(Unit... units) {
		setUnits(Arrays.asList(units));
	}
	
	public void setUnits(List<Unit> units) {
		unitMovementData = new UnitMovementData(units);
		moveSpread = new MoveSpread(unitMovementData);
		moveOrder = moveSpread.setCondensed();
		activeUnits = new HashSet<Unit>(moveOrder);
	}

	public Unit getActingUnit() {
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

	public void rebase(List<Unit> units) {
		removeDefeatedUnitsFromMoveOrder();
	}

	private void removeDefeatedUnitsFromMoveOrder() {
		Iterator<Unit> moveOrderIterator = moveOrder.iterator();
		
		while(moveOrderIterator.hasNext()) { 
		    Unit unit = moveOrderIterator.next();
	        if(unit.isDefeated()) 
	        	moveOrderIterator.remove();
		}
		
	}
}
