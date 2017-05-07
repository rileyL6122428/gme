package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.View;
import processing.core.PApplet;

public class UnitOverView extends View {
	
	private Unit unit;
	private PlayingGrid playingGrid;

	@Override
	public void draw() {
		ctx.fill(0);
		
		if(getPlayingGrid().unitIsHovered(getUnit())) {
			ctx.text(getUnit().getName(), ctx.width - 100, ctx.height - 100);
			ctx.text("HP: " + getUnit().getHealth().getVal(), ctx.width - 100, ctx.height - 80);
		}
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
}
