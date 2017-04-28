package l2kstudios.gme.view;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import processing.core.PApplet;

public class UnitViewFactory {
	
	@Autowired
	private PApplet ctx;
	
	@Autowired
	private PlayingGrid playingGrid;
	
	@Autowired
	private GridDrawingUtil gridDrawingUtil;
	
	public UnitView newUnitView(Unit unit) {
		return new UnitView() {{
			setDrawingContext(ctx);
			setPlayingGrid(playingGrid);
			setGridDrawingUtil(gridDrawingUtil);
			setUnit(unit);
		}};
	}
}
