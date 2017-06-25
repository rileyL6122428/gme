package l2kstudios.gme;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.view.image.SampleUnitImage;
import processing.core.PApplet;
import processing.core.PImage;


public class AssetLoader {
	
	@Autowired
	private PApplet ctx;
	
	public void loadAssets() {
		PImage asbelImage = ctx.loadImage("tales_of_chibi_sprites_2.jpg")
    			.get(745, 425, 162, 235);
    	SampleUnitImage.setAsbelImage(asbelImage);
    	
    	PImage richardImage = ctx.loadImage("sample_tales_of_richard_sprite.jpg");
    	SampleUnitImage.setRichardImage(richardImage);
    	
    	PImage estelleImage = ctx.loadImage("estelle.jpg");
    	SampleUnitImage.setEstelleImage(estelleImage);
    	
    	PImage sophieImage = ctx.loadImage("Sophie.jpg");
    	SampleUnitImage.setSophieImage(sophieImage);
	}
}
