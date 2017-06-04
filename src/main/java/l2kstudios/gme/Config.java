package l2kstudios.gme;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.view.image.SampleUnitImage;
import processing.core.PApplet;
import processing.core.PImage;

public class Config {
	
	@Autowired
	private PApplet ctx;
	
	public void setup() {
		ctx.ellipseMode(ctx.CORNER);
    	ctx.frameRate(30);
    	ctx.background(255, 255, 255);
	}
	
	public void settings() {
		ctx.fullScreen();
	}
}
