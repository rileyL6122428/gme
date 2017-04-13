package l2kstudios.gme.levelctrl;

import static l2kstudios.gme.level.InputDispatcher.Input.*;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import processing.core.PApplet;

public class LevelCtrl {
	
	@Autowired
	private Level level;
	@Autowired
	private PApplet ctx;
	
	public void keyPressed() {
		if(ctx.key == 'a') level.registerInput(LEFT);
    	if(ctx.key =='s') level.registerInput(DOWN);
    	if(ctx.key == 'd') level.registerInput(RIGHT);
    	if(ctx.key =='w') level.registerInput(UP);
	}
}
