package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.view.GridDrawingUtil.Offsets;
import l2kstudios.gme.view.View;

public class UnitGridAvatar extends View<Unit> {
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	private static final Offsets SPACE_OFFSETS;
	
	private GridDrawingUtil gridDrawingUtil;
	protected Unit unit;
	protected MovementCycle movementCycle;
	
	static {
		SPACE_OFFSETS = new Offsets() {{
			setVertical(0);
			setHorizontal(0);
		}};
	}

	public void draw() {
		if(unit != movementCycle.getActingUnit()) {
			ctx.fill(0, 0, 255);
			drawUnit(unit.getPosition());			
		}
	}
	
	protected void drawUnit(Position position) {
		gridDrawingUtil.drawEllipseAt(position, SPACE_OFFSETS, 1, 1);		
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public void setMovementCycle(MovementCycle movementCycle) {
		this.movementCycle = movementCycle;
	}
}
