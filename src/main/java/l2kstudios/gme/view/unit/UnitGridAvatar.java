package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.view.View;
import l2kstudios.gme.view.GridDrawingUtil.Offsets;
import processing.core.PApplet;

public class UnitGridAvatar implements View {
	
	private static final Offsets SPACE_OFFSETS;
	
	private PlayingGrid playingGrid;
	private PApplet ctx;
	private Unit unit;
	private GridDrawingUtil gridDrawingUtil;
	
	static {
		SPACE_OFFSETS = new Offsets() {{
			setVertical(0);
			setHorizontal(0);
		}};
	}
	
	public UnitGridAvatar(Unit unit, PApplet ctx, PlayingGrid playingGrid) {
		this.setUnit(unit);
		this.setCtx(ctx);
		this.setPlayingGrid(playingGrid);
	}

	public UnitGridAvatar() {
		// TODO Auto-generated constructor stub
	}

	public void draw() {
		setUnitFill();
		drawUnit();
	}
	
	private void setUnitFill() {
		if(getPlayingGrid().isActingUnit(getUnit())) {
			getCtx().fill(0, 0, 255);			
		} else {
			getCtx().fill(0, 255, 0);
		}		
	}
	
	private void drawUnit() {
		Position unitPos = getUnit().getPosition();
		getGridDrawingUtil().drawEllipseAt(getUnit().getPosition(), SPACE_OFFSETS, 1, 1);
//		ctx.ellipse(unitPos.getX() * GRID_BOX_WIDTH, unitPos.getY() * GRID_BOX_HEIGHT, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);		
	}

	public GridDrawingUtil getGridDrawingUtil() {
		return gridDrawingUtil;
	}

	public void setGridDrawingUtil(GridDrawingUtil gridDrawingUtil) {
		this.gridDrawingUtil = gridDrawingUtil;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public PApplet getCtx() {
		return ctx;
	}

	public void setCtx(PApplet ctx) {
		this.ctx = ctx;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
