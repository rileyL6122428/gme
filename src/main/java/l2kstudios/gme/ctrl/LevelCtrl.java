package l2kstudios.gme.ctrl;

import static l2kstudios.gme.model.level.factory.InputDispatcher.Input.*;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.level.factory.Level;
import processing.core.PApplet;
import processing.core.PConstants;

public class LevelCtrl extends Controller<Level> {
	
	public void keyPressed() {
		if(ctx.key == 'a') model.registerInput(LEFT);
    	if(ctx.key =='s') model.registerInput(DOWN);
    	if(ctx.key == 'd') model.registerInput(RIGHT);
    	if(ctx.key =='w') model.registerInput(UP);
    	if(ctx.key == ' ') model.registerInput(SPACE);
    	
    	if(ctx.key == PConstants.BACKSPACE) model.registerInput(BACK);
	}

}
