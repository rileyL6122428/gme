package l2kstudios.gme.levelctrl;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import processing.core.PApplet;

public class LevelCtrl {
	
	@Autowired
	private Level level;
	@Autowired
	private PApplet ctx;
	
	public void keyReleased() {
		if(ctx.key == 'a') {
    		System.out.println("HELLO WORLD");
    	}
	}
}
