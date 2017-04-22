package l2kstudios.gme.levelview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import l2kstudios.gme.level.Unit;
import processing.core.PApplet;

public class UnitViewList implements InitializingBean, View {
	
	@Autowired
	private Level level;
	
	@Autowired 
	private PApplet ctx; 
	
	private List<UnitView> unitViews;
	
	public void draw() {
		unitViews.forEach(UnitView::draw);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		unitViews = new ArrayList<UnitView>();
		
		level.getUnits().forEach((unit) -> {
			unitViews.add(new UnitView(ctx, unit));						
		});
		
	}
}
