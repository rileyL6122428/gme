package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import l2kstudios.gme.model.unit.Unit;

public class PlayingGrid extends RectangularGrid {
	
	public List<Unit> getUnits() {
		List<Unit> units = new ArrayList<Unit>();
		
		forEachSpace((Space space) -> {
			if(space.isOccupied() && space.getOccupier() instanceof Unit) 
				units.add((Unit) space.getOccupier());
		});
		
		return units;
	}
	
	public List<Unit> getEnemyUnits() {
		List<Unit> units = new ArrayList<Unit>();
		
		forEachSpace((Space space) -> {
			if(spaceOccupiedByEnemyUnit(space)) 
				units.add((Unit) space.getOccupier());
		});
		
		return units;
	}
	
	private boolean spaceOccupiedByEnemyUnit(Space space) {
		try {
			Unit unit = (Unit) space.getOccupier();
			return unit.isEnemyUnit();
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Unit> getAlliedUnits() {
		List<Unit> units = new ArrayList<Unit>();
		
		forEachSpace((Space space) -> {
			if(spaceOccupiedByAlliedUnit(space)) 
				units.add((Unit) space.getOccupier());
		});
		
		return units;
	}
	
	private boolean spaceOccupiedByAlliedUnit(Space space) {
		try {
			Unit unit = (Unit) space.getOccupier();
			return unit.isAlliedUnit();
		} catch (Exception e) {
			return false;
		}
	}
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)getSpaces().get(y).get(x).getOccupier();
	}
	
	public Space getSpaceAt(int x, int y) {
		return getSpaces().get(y).get(x);
	}
	
	public void forEachSpace(Consumer<Space> consumer) {
		for(List<Space> row : spaces) {
			for(Space space : row) {
				consumer.accept(space);
			}
		}
	}
	
	public void clearSpace(Position position) {
		getSpaceAt(position).setOccupier(null);
	}
}
