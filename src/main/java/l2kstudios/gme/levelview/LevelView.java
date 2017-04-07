package l2kstudios.gme.levelview;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import processing.core.PApplet;

public class LevelView {
	
	@Autowired
	GridView gridView;
	
	public void draw() {
		gridView.draw();
	}
	
	
}
