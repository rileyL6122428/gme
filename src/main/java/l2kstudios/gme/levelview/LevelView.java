package l2kstudios.gme.levelview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;
import processing.core.PApplet;

public class LevelView {

	@Autowired
	private Level level;
	
	@Autowired
	private PApplet ctx;
	
	@Autowired
	private PlayingGridView gridView;
	
	@Autowired
	private UnitViewList unitViews;
	
	@Autowired
	private MoveOrderView moveOrderView;
	
	public void draw() {
		ctx.background(255, 255, 255);
		gridView.draw();
		moveOrderView.draw();
		unitViews.draw();
		
		testDrawMoveOrder();
	}

	private void testDrawMoveOrder() {
		// TODO Auto-generated method stub
		
	}
	
	

}
