package l2kstudios.gme.swing.animation;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static ImageLoader resourceObject;
	
	static {
		resourceObject = new ImageLoader();
	}
	
	public static Image getBoardSprite(String spritePath, int widthInset, int heightInset) {
		try {			
			URL imageURL = getResourceURL(spritePath);
			Image image = ImageIO.read(imageURL);
			image = image.getScaledInstance(SPACE_WIDTH  - widthInset, SPACE_HEIGHT - heightInset, Image.SCALE_DEFAULT);
			return image;
			
		} catch (IOException e) { throw new RuntimeException(e); }
	}
	
	private static URL getResourceURL(String resourcePath) {
		return resourceObject.getClass().getResource("/" + resourcePath);
	}
	
}
