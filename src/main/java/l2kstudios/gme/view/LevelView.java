package l2kstudios.gme.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.view.unit.ActionMenuView;
import l2kstudios.gme.view.unit.UnitViewFactory;
import l2kstudios.gme.view.unit.UnitViewList;
import processing.core.PApplet;

public class LevelView extends View implements InitializingBean {
	
	@Autowired
	private Level level;
	
	private List<View> subViews;
	
	public void draw() {
		ctx.background(255, 255, 255);
		subViews.forEach(View::draw);
	}

	public List<View> getSubViews() {
		return subViews;
	}

	public void setSubViews(List<View> subViews) {
		this.subViews = subViews;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		GridDrawingUtil gridDrawingUtil = new GridDrawingUtil();
		gridDrawingUtil.setCtx(ctx);
		
		PlayingGridView playingGridView = new PlayingGridView();
		playingGridView.setDrawingContext(ctx);
		playingGridView.setPlayingGrid(level.getPlayingGrid());
		playingGridView.setGridDrawingUtil(gridDrawingUtil);
		
		UnitViewFactory unitViewFactory = new UnitViewFactory();
		unitViewFactory.setCtx(ctx);
		unitViewFactory.setGridDrawingUtil(gridDrawingUtil);
		unitViewFactory.setPlayingGrid(level.getPlayingGrid());
		
		UnitViewList unitViewList = new UnitViewList();
		unitViewList.setPlayingGrid(level.getPlayingGrid());
		unitViewList.setUnitViewFactory(unitViewFactory);
		unitViewList.afterPropertiesSet();
		
		MoveOrderView moveOrderView = new MoveOrderView();
		moveOrderView.setDrawingContext(ctx);
		moveOrderView.setActingUnitTracker(level.getActingUnitTracker());
		
		ActionMenuView actionMenuView = new ActionMenuView();
		actionMenuView.setDrawingContext(ctx);
		actionMenuView.setActionMenu(level.getActionMenu());
		
		subViews = new ArrayList<View>();
		subViews.add(playingGridView);
		subViews.add(unitViewList);
		subViews.add(moveOrderView);
		subViews.add(actionMenuView);
		
	}

}
