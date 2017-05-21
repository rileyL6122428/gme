package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.Position;
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
	private Unit unit;
	
	static {
		SPACE_OFFSETS = new Offsets() {{
			setVertical(0);
			setHorizontal(0);
		}};
	}

	public void draw() {
		setUnitFill();
		drawUnit();
	}
	
	private void setUnitFill() {
		if(!unit.turnIsOver())
			ctx.fill(0, 0, 255);			
		else 
			ctx.fill(0, 255, 0);
				
	}
	
	private void drawUnit() {
		Position unitPos = getUnit().getPosition();
		gridDrawingUtil.drawEllipseAt(unitPos, SPACE_OFFSETS, 1, 1);		
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
