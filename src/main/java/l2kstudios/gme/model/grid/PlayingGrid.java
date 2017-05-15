package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGrid extends TwoDimensionalGrid {
	
	protected ActingUnitTracker actingUnitTracker;
	
	public void initialize() {
		Unit actingUnit = actingUnitTracker.getActingUnit();
		moveCursorTo(actingUnit.getPosition());
	}
	
	public boolean select() {
		Unit actingUnit = actingUnitTracker.getActingUnit();
		
		if(actingUnit.canMoveTo(hoveredSpace())) {
			actingUnit.moveTo(hoveredSpace());
			return true;
		}
		
		return false;
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
	
	public boolean unitIsHovered(Unit unit) {
		return unit == hoveredSpace().getOccupier();
	}
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)getSpaces().get(y).get(x).getOccupier();
	}
	
	public Space getSpaceAt(int x, int y) {
		return getSpaces().get(y).get(x);
	}
	
	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}
}
