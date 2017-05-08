package l2kstudios.gme.view.unit;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.factory.Level;
import l2kstudios.gme.view.View;

public class UnitViewList extends View implements InitializingBean {
	
	@Autowired
	private PlayingGrid playingGrid;

	@Autowired 
	private UnitViewFactory unitViewFactory;
	
	private List<UnitView> unitViews;
	
	public void draw() {
		unitViews.forEach(UnitView::draw);
	}

	@Override
	public void afterPropertiesSet() {		
		unitViews = playingGrid.getUnits().stream()
									.map(unitViewFactory::newUnitView)
									.collect(Collectors.toList());
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
	public void setUnitViewFactory(UnitViewFactory unitViewFactory) {
		this.unitViewFactory = unitViewFactory;
	}
}
