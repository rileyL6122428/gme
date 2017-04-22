package l2kstudios.gme.levelview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import l2kstudios.gme.level.Unit;
import l2kstudios.gme.level.grid.PlayingGrid;
import processing.core.PApplet;

public class UnitViewList implements InitializingBean, View {
	
	@Autowired
	private Level level;
	
	@Autowired 
	private PApplet ctx; 
	
	@Autowired
	private PlayingGrid playingGrid;
	
	private List<UnitView> unitViews;
	
	public void draw() {
		unitViews.forEach(UnitView::draw);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		unitViews = new ArrayList<UnitView>();
		
		level.getUnits().forEach((unit) -> {
			unitViews.add(new UnitView(ctx, unit, playingGrid));						
		});
		
	}
}
