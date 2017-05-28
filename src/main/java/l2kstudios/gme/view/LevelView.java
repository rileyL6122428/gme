package l2kstudios.gme.view;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.actioninterface.ActionInterfaceViewFactory;
import l2kstudios.gme.view.actioninterface.MovementGridView;
import l2kstudios.gme.view.unit.ActingUnitView;
import l2kstudios.gme.view.unit.UnitGridAvatar;
import l2kstudios.gme.view.unit.UnitView;

public class LevelView extends View<Level>  {

	private View<PlayingGrid> playingGridView;
	private List<View<Unit>> unitViewList;
	private View<Unit> actingUnitView;
	private MoveOrderView moveOrderView;
	private View<ActionInterface> actionInterfaceView;

	public void draw() {
		ctx.background(255, 255, 255);
		playingGridView.draw();
		unitViewList.forEach(View<Unit>::draw);
		actingUnitView.draw();
		moveOrderView.draw();
		
		if(model.getCurrentActionInterface() != actionInterfaceView.getModel()) {
			actionInterfaceView = ActionInterfaceViewFactory.newActionInterfaceView(model.getCurrentActionInterface());
			actionInterfaceView.setDrawingContext(ctx);
		} 
		actionInterfaceView.draw();
		
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
		
		ActingUnitView actingUnitView = new ActingUnitView();
		actingUnitView.setDrawingContext(ctx);
		actingUnitView.setMovementCycle(model.getMovementCycle());
		actingUnitView.setLevel(model);
		this.actingUnitView = actingUnitView;
		
		actionInterfaceView = new MovementGridView();
		actionInterfaceView.setModel(model.getCurrentActionInterface());
		actionInterfaceView.setDrawingContext(ctx);
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
			unitView.setMovementCycle(model.getMovementCycle());
			unitViewList.add(unitView);
		});
		
		this.unitViewList = unitViewList;
	}

	private void setupMoveOrderView() {
		moveOrderView = new MoveOrderView();
		moveOrderView.setModel(model.getMovementCycle());
		moveOrderView.setDrawingContext(ctx);
	}
	
}
