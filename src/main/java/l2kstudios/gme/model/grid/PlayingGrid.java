package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGrid extends Grid implements InitializingBean {
	
	private MovementCycle moveCycle;
	private Unit actingUnit;
	
	@Autowired
	private ActionMenu actionMenu;
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)getSpaces().get(y).get(x).getOccupier();
	}
	
	public List<Unit> getMoveOrder() {
		return moveCycle.getOrder();
	}
	
	public void select() {
		moveActingUnit();
	}

	private void moveActingUnit() {
		if(actingUnit.canMoveTo(hoveredSpace()))
			actingUnit.moveTo(hoveredSpace());
	}
	
	private void queueNextUnit() {
		actingUnit = moveCycle.getNext();
		actingUnit.registerTurnStart();
		getActionMenu().attachTo(actingUnit);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		moveCycle = new MovementCycle(getUnits());
		queueNextUnit();
	}

	public List<Unit> getUnits() {
		List<Unit> units = new ArrayList<Unit>();
		
		for(List<Space> row : spaces) {
			for(Space space : row) {
				if(space.isOccupied()) units.add((Unit) space.getOccupier());
			}
		}
		
		return units;
	}

	public boolean isActingUnit(Unit unit) {
		return unit == actingUnit;
	}

	public boolean isInBounds(Position position) {
		return spaces.size() > position.getY() && spaces.get(position.getY()).size() > position.getX();
	}

	public boolean unitIsHovered(Unit unit) {
		return hoveredSpace().getOccupier() == unit;
	}

	public ActionMenu getActionMenu() {
		return actionMenu;
	}

	public void setActionMenu(ActionMenu actionMenu) {
		this.actionMenu = actionMenu;
	}

}
