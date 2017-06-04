package l2kstudios.gme.view.image;

import processing.core.PImage;

public class SampleUnitImage {
	
	private static PImage asbelImage;
	private static PImage richardImage;
	
	public static void setAsbelImage(PImage image) {
		asbelImage = image;
	}
	
	public static PImage getAsbelImage() {
		return asbelImage;
	}

	public static PImage getRichardImage() {
		return richardImage;
	}

	public static void setRichardImage(PImage richardImage) {
		SampleUnitImage.richardImage = richardImage;
	}
	
}
