package l2kstudios.gme.view;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.unit.ActionMenuView;
import l2kstudios.gme.view.unit.UnitView;

public class LevelView extends View<Level>  {

	private View<PlayingGrid> playingGridView;
	private List<View<Unit>> unitViewList;
	private MoveOrderView moveOrderView;
	private ActionMenuView actionMenuView;

	public void draw() {
		ctx.background(255, 255, 255);
		playingGridView.draw();
		unitViewList.forEach(View<Unit>::draw);
		moveOrderView.draw();
		actionMenuView.draw();
	}

	public void setModel(Level model) {
		this.model = model;
		afterPropertiesSet();
	}
	
	public void afterPropertiesSet() {
		setupGridDrawingUtil();
		setupPlayingGridView();		
		setupUnitViewList();
		setupMoveOrderView();
		setupActionMenuView();
	}

	private void setupGridDrawingUtil() {
		GridDrawingUtil.getInstance().setDrawingContext(ctx);
	}


	private void setupPlayingGridView() {
		playingGridView = new PlayingGridView();
		playingGridView.setModel(model.getPlayingGrid());
		playingGridView.setDrawingContext(ctx);
	}

	private void setupUnitViewList() {
		List<Unit> units = model.getPlayingGrid().getUnits();
		final PlayingGrid playingGrid = model.getPlayingGrid();
		final List<View<Unit>> unitViewList = new ArrayList<View<Unit>>();
		units.forEach((unit) -> {
			UnitView unitView = new UnitView();
			unitView.setDrawingContext(ctx);
			unitView.setModel(unit);
			unitView.setPlayingGrid(playingGrid);
			unitViewList.add(unitView);
		});
		
		this.unitViewList = unitViewList;
	}

	private void setupMoveOrderView() {
		ActingUnitTracker actingUnitTracker = model.getActingUnitTracker();
		moveOrderView = new MoveOrderView();
		moveOrderView.setActingUnitTracker(actingUnitTracker);
		moveOrderView.setDrawingContext(ctx);
	}
	
	private void setupActionMenuView() {
		ActionMenu actionMenu = model.getActionMenu();
		actionMenuView = new ActionMenuView();
		actionMenuView.setDrawingContext(ctx);
		actionMenuView.setModel(actionMenu);
	}
}
