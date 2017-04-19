package l2kstudios.gme.movement;

import java.util.List;

import l2kstudios.gme.level.Unit;

public class MovementCycle {
	
	private MoveSpread moveSpread;
	private UnitMovementData unitMovementData;
	
	public void setUnits(List<Unit> units) {
		unitMovementData = new UnitMovementData(units);
		moveSpread = new MoveSpread(unitMovementData);
	}

	
	
	public List<Unit> getOrder() {
		return moveSpread.getCondensed();
	}
}
