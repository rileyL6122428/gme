package l2kstudios.gme.view;

import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_HEIGHT;
import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_WIDTH;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.Position;
import l2kstudios.gme.model.level.Unit;
import processing.core.PApplet;

public class UnitGridAvatar {
	
	private PlayingGrid playingGrid;
	private PApplet ctx;
	private Unit unit;
	
	public UnitGridAvatar(Unit unit, PApplet ctx, PlayingGrid playingGrid) {
		this.unit = unit;
		this.ctx = ctx;
		this.playingGrid = playingGrid;
	}

	public void draw() {
		setUnitFill();
		drawUnit();
	}
	
	private void setUnitFill() {
		if(playingGrid.isActingUnit(unit)) {
			ctx.fill(0, 0, 255);			
		} else {
			ctx.fill(0, 255, 0);
		}		
	}
	
	private void drawUnit() {
		Position unitPos = unit.getPosition();
		ctx.ellipse(unitPos.getX() * GRID_BOX_WIDTH, unitPos.getY() * GRID_BOX_HEIGHT, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);		
	}
}
