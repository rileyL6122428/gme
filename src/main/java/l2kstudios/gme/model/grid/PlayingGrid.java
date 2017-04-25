package l2kstudios.gme.model.grid;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGrid extends Grid implements InitializingBean {
	
	public enum State {
		MOVING_UNIT, SELECTING_ACTION
	}
	
	private List<Unit> units;
	private MovementCycle moveCycle;
	private Unit actingUnit;
	
	@Autowired
	private ActionMenu actionMenu;
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)spaces.get(y).get(x);
	}
	
	public List<Unit> getMoveOrder() {
		return moveCycle.getOrder();
	}
	
	public void selectSpace() {
		Unit unit = (Unit)getHovered();
		Position cursorPos = cursor.getPosition();
		
		if(unit == null && actingUnit.canMoveTo(cursorPos)) {
			moveActingUnitTo(cursorPos);
			actionMenu.showFor(actingUnit);
//			queueNextUnit();
		}
	}
	
	private void moveActingUnitTo(Position position) {
		Position actingUnitPos = actingUnit.getPosition();
		spaces.get(actingUnitPos.getY()).set(actingUnitPos.getX(), null);
		spaces.get(position.getY()).set(position.getX(), actingUnit);
		actingUnit.setPosition(position);
	}
	
	private void queueNextUnit() {
		actingUnit.registerTurnEnd();
		
		moveCycle.shift();
		actingUnit = moveCycle.getNext();
		actingUnit.registerTurnStart();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		units.forEach(this::place);
		moveCycle = new MovementCycle(getUnits());
		actingUnit = moveCycle.getNext();
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	
	public List<Unit> getUnits() {
		return units;
	}

	public boolean isActingUnit(Unit unit) {
		return unit == actingUnit;
	}

	public boolean isInBounds(Position position) {
		return dimensions.isInBounds(position);
	}

	public boolean unitIsHovered(Unit unit) {
		return (Unit)getHovered() == unit;
	}
}
