package l2kstudios.gme.view.image;

import processing.core.PImage;

public class SampleUnitImage {
	
	private static PImage asbelImage;
	private static PImage richardImage;
	private static PImage estelleImage;
	private static PImage sophieImage;
	
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

	public static PImage getEstelleImage() {
		return estelleImage;
	}

	public static void setEstelleImage(PImage estelleImage) {
		SampleUnitImage.estelleImage = estelleImage;
	}

	public static PImage getSophieImage() {
		return sophieImage;
	}

	public static void setSophieImage(PImage sophieImage) {
		SampleUnitImage.sophieImage = sophieImage;
	}
	
}
