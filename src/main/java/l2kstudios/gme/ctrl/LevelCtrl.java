package l2kstudios.gme.ctrl;

import static l2kstudios.gme.model.level.InputDispatcher.Input.*;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.level.Level;
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
    	if(ctx.key == ' ') level.registerInput(SPACE);
	}
}
