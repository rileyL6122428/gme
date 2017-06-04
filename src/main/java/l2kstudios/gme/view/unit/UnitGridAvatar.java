package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.view.GridDrawingUtil.Offsets;
import l2kstudios.gme.view.View;
import l2kstudios.gme.view.constants.GridConstants;
import l2kstudios.gme.view.image.SampleUnitImage;
import processing.core.PImage;

public class UnitGridAvatar extends View<Unit> {
	
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
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}

	public void draw() {
		if(unit != movementCycle.getActingUnit()) {
			ctx.fill(0, 0, 255);
			drawUnit(unit.getPosition());			
		}
	}
	
	protected void drawUnit(Position position) {
		ctx.pushMatrix();
		
		ctx.scale(unit.getScale());
		ctx.image(
			unit.getImage(),
			position.getX() * GridConstants.SPACE_WIDTH * (1/unit.getScale()) + 30, 
			position.getY() * GridConstants.SPACE_HEIGHT * (1/unit.getScale()) + 5
		);
		ctx.popMatrix();
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
