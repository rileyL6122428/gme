package l2kstudios.gme.view.unit;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import processing.core.PApplet;

public class UnitViewFactory {
	
	@Autowired
	private PApplet ctx;
	
	@Autowired
	private PlayingGrid playingGrid;
	
	@Autowired
	private GridDrawingUtil gridDrawingUtil;
	
	public UnitView newUnitView(Unit unit) {
		UnitView unitView = new UnitView();
		unitView.setDrawingContext(ctx);
		unitView.setPlayingGrid(playingGrid);
		unitView.setGridDrawingUtil(gridDrawingUtil);
		unitView.setUnit(unit);
		return unitView;
	}

	public void setCtx(PApplet ctx) {
		this.ctx = ctx;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public void setGridDrawingUtil(GridDrawingUtil gridDrawingUtil) {
		this.gridDrawingUtil = gridDrawingUtil;
	}
}
