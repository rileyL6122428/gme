package l2kstudios.gme.levelview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;
import processing.core.PApplet;

public class LevelView implements InitializingBean {

	@Autowired
	private Level level;
	
	@Autowired
	private PApplet ctx;
	
	@Autowired
	private PlayingGridView gridView;
	
	private List<UnitView> unitView;
	
	public void draw() {
		ctx.background(255, 255, 255);
		gridView.draw();
		unitView.forEach(UnitView::draw);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		unitView = new ArrayList<UnitView>();
		
		List<Unit> units = level.getUnits();
		
		level.getUnits().forEach((unit) -> {
			unitView.add(new UnitView(ctx, unit));						
		});
	}
}
