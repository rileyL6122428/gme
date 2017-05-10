package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.view.View;
import l2kstudios.gme.view.GridDrawingUtil.Offsets;
import processing.core.PApplet;

public class UnitGridAvatar extends View {
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	private static final Offsets SPACE_OFFSETS;
	
	private GridDrawingUtil gridDrawingUtil;
	private ActingUnitTracker actingUnitTracker;
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
		if(!getUnit().isInBoardState(Unit.BoardState.STAND_BY)) {
			ctx.fill(0, 0, 255);			
		} else {
			ctx.fill(0, 255, 0);
		}		
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
