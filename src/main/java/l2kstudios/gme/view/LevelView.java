package l2kstudios.gme.view;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.ComputerControlledTurn;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.turn.TurnViewFactory;
import l2kstudios.gme.view.unit.ActingUnitView;
import l2kstudios.gme.view.unit.UnitView;

public class LevelView extends View<Level>  {

	private View<PlayingGrid> playingGridView;
	private List<View<Unit>> unitViewList;
	private View<Unit> actingUnitView;
	private MoveOrderView moveOrderView;

	
	private View turnView;
	private TurnViewFactory turnViewFactory;

	public void draw() {
		ctx.background(255, 255, 255);
		playingGridView.draw();
		drawUnitViews();
		actingUnitView.draw();
		moveOrderView.draw();
		
		Turn turn = model.getCurrentTurn();
		if(!(turn instanceof ComputerControlledTurn)) {
			if(model.turnIsOver((Turn)turnView.getModel())) 
				turnView = turnViewFactory.newTurnView(model.getCurrentTurn());
			
			
				turnView.draw();
			
		}
		
	}

	private void drawUnitViews() {
		Iterator<View<Unit>> unitViewIterator = unitViewList.iterator();
		while(unitViewIterator.hasNext()) {
			View<Unit> unitView = unitViewIterator.next();
			Unit unit = unitView.getModel();
			
			if(unit.isDefeated())
				unitViewIterator.remove();
			else
				unitView.draw();
		}
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
		
		turnViewFactory = new TurnViewFactory();
		turnViewFactory.setDrawingContext(ctx);
		
		turnView = turnViewFactory.newTurnView(model.getCurrentTurn());
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
		final List<View<Unit>> unitViewList = new LinkedList<View<Unit>>();
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
