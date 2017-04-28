package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.View;
import processing.core.PApplet;

public class UnitOverView implements View {
	
	private Unit unit;
	private PApplet ctx;
	private PlayingGrid playingGrid;
	
	public UnitOverView(Unit unit, PApplet ctx, PlayingGrid playingGrid) {
		this.setUnit(unit);
		this.setCtx(ctx);
		this.setPlayingGrid(playingGrid);
	}

	public UnitOverView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		getCtx().fill(0);
		
		if(getPlayingGrid().unitIsHovered(getUnit())) {
			getCtx().text(getUnit().getName(), getCtx().width - 100, getCtx().height - 100);
			getCtx().text("HP: " + getUnit().getHealth().getVal(), getCtx().width - 100, getCtx().height - 80);
		}
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public PApplet getCtx() {
		return ctx;
	}

	public void setCtx(PApplet ctx) {
		this.ctx = ctx;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
}
