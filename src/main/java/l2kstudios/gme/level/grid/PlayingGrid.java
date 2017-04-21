package l2kstudios.gme.level.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.level.Cursor;
import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;
import l2kstudios.gme.movement.MovementCycle;

public class PlayingGrid extends Grid implements InitializingBean {
	
	private List<Unit> units;
	private MovementCycle moveCycle;
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)spaces.get(y).get(x);
	}
	
	public List<Unit> getMoveOrder() {
		return moveCycle.getOrder();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		moveCycle = new MovementCycle(getUnits());
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	
	public List<Unit> getUnits() {
		return units;
	}
}
