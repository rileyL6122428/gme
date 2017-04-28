package l2kstudios.gme.view;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import processing.core.PApplet;

public class UnitView implements View {
	
	private UnitOverView unitOverView = new UnitOverView();
	private UnitMovementGrid unitMovementGrid = new UnitMovementGrid();
	private UnitGridAvatar gridAvatar = new UnitGridAvatar();
	
	public UnitView() {
		
	}
	
	public UnitView(PApplet ctx, Unit unit, PlayingGrid playingGrid) {
		unitOverView = new UnitOverView(unit, ctx, playingGrid);
		unitMovementGrid = new UnitMovementGrid(unit, ctx, playingGrid);
		gridAvatar = new UnitGridAvatar(unit, ctx, playingGrid);
	}
	
	public void draw() {
		unitMovementGrid.draw();
		unitOverView.draw();
		gridAvatar.draw();
	}
	
	public void setUnit(Unit unit) {
		unitOverView.setUnit(unit);
		unitMovementGrid.setUnit(unit);
		gridAvatar.setUnit(unit);
	}
	
	public void setDrawingContext(PApplet ctx) {
		unitOverView.setCtx(ctx);
		unitMovementGrid.setCtx(ctx);
		gridAvatar.setCtx(ctx);
	}
	
	public void setPlayingGrid(PlayingGrid grid) {
		unitOverView.setPlayingGrid(grid);
		unitMovementGrid.setPlayingGrid(grid);
		gridAvatar.setPlayingGrid(grid);
	}
	
	public void setGridDrawingUtil(GridDrawingUtil util) {
		gridAvatar.setGridDrawingUtil(util);
	}
}
