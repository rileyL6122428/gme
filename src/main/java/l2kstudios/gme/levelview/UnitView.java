package l2kstudios.gme.levelview;

import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;
import processing.core.PApplet;

import static l2kstudios.gme.levelview.PlayingGridView.*;

public class UnitView implements View {
	
	private PApplet ctx;
	private Unit unit;
	
	public UnitView(PApplet ctx, Unit unit) {
		this.ctx = ctx;
		this.unit = unit;
	}
	
	public void draw() {
		ctx.fill(0, 255, 0);
		
		Position unitPos = unit.getPosition();
		ctx.ellipse(unitPos.getX() * GRID_BOX_WIDTH, unitPos.getY() * GRID_BOX_HEIGHT, GRID_BOX_HEIGHT, GRID_BOX_WIDTH);
	}
}
