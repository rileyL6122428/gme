package l2kstudios.gme.level.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.level.Cursor;
import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;

public class PlayingGrid extends Grid implements InitializingBean {
	
	List<Unit> units;
	
	public void addUnit(Unit unit) {
		Position position = unit.getPosition();
		int x = position.getX();
		int y = position.getY();
		
		spaces.get(y).set(x, unit);
		units.add(unit);
	}
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)spaces.get(y).get(x);
	}
	
	public List<Unit> getUnits() {
		return units;
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		units = new ArrayList<Unit>();
	}
}