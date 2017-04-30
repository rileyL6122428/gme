package l2kstudios.gme.model.grid;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

import static l2kstudios.gme.model.grid.PlayingGrid.State.*;

public class PlayingGrid extends Grid implements InitializingBean {
	
	public enum State {
		MOVING_UNIT, SELECTING_ACTION
	}
	
	private List<Unit> units;
	private MovementCycle moveCycle;
	private Unit actingUnit;
	private State state;
	
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
		
		if(unit == null && actingUnit.canMoveTo(cursorPos)) 
			moveActingUnitTo(cursorPos);
	}
	
	private void moveActingUnitTo(Position position) {
		Position actingUnitPos = actingUnit.getPosition();
		spaces.get(actingUnitPos.getY()).set(actingUnitPos.getX(), null);
		spaces.get(position.getY()).set(position.getX(), actingUnit);
		actingUnit.moveTo(position);
		state = SELECTING_ACTION;
	}
	
	private void queueNextUnit() {
		actingUnit = moveCycle.getNext();
		actingUnit.registerTurnStart();
		getActionMenu().attachTo(actingUnit);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		units.forEach(this::place);
		moveCycle = new MovementCycle(getUnits());
		queueNextUnit();
		state = MOVING_UNIT;
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

	public ActionMenu getActionMenu() {
		return actionMenu;
	}

	public void setActionMenu(ActionMenu actionMenu) {
		this.actionMenu = actionMenu;
	}
	
	public boolean inInPlayingGridState(PlayingGrid.State state) {
		return this.state == state;
	}
}
