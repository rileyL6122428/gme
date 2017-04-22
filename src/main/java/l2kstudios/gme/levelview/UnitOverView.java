package l2kstudios.gme.levelview;

import l2kstudios.gme.level.Unit;
import l2kstudios.gme.level.grid.PlayingGrid;
import processing.core.PApplet;

public class UnitOverView implements View {
	
	private Unit unit;
	private PApplet ctx;
	private PlayingGrid playingGrid;
	
	public UnitOverView(Unit unit, PApplet ctx, PlayingGrid playingGrid) {
		this.unit = unit;
		this.ctx = ctx;
		this.playingGrid = playingGrid;
	}

	@Override
	public void draw() {
		ctx.fill(0);
		
		if(playingGrid.unitIsHovered(unit)) {
			ctx.text(unit.getName(), ctx.width - 100, ctx.height - 100);
			ctx.text("HP: " + unit.getHealth(), ctx.width - 100, ctx.height - 80);
		}
	}
}
