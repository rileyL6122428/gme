package l2kstudios.gme.view.unit;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.view.View;
import processing.core.PApplet;

public class UnitView extends View {
	
	private UnitOverView unitOverView = new UnitOverView();
	private UnitMovementGrid unitMovementGrid = new UnitMovementGrid();
	private UnitGridAvatar gridAvatar = new UnitGridAvatar();
	
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
		unitOverView.setDrawingContext(ctx);
		unitMovementGrid.setCtx(ctx);
		gridAvatar.setDrawingContext(ctx);
	}
	
	public void setPlayingGrid(PlayingGrid grid) {
		unitOverView.setPlayingGrid(grid);
		unitMovementGrid.setPlayingGrid(grid);
	}
	
	public void setGridDrawingUtil(GridDrawingUtil util) {
		gridAvatar.setGridDrawingUtil(util);
	}
}
