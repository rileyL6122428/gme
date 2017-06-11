package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.level.Level;

public class ActingUnitView extends UnitGridAvatar {
	
	private Level level; 
	
	public void draw() {
		unit = movementCycle.getActingUnit();
		ctx.fill(0, 255, 0);
		drawUnit(unit.getPosition());
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
}
