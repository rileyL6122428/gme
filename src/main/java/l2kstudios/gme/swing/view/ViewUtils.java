package l2kstudios.gme.swing.view;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.grid.position.Position;

public class ViewUtils {
	
	public static void drawFillRectAt(PlayingGridSpace space, Graphics drawingCtx) {
		Position position = space.getPosition();
		drawFillRectAt(position, drawingCtx);
	}
	
	public static void drawFillRectAt(Position position, Graphics drawingCtx) {
		drawingCtx.fillRect(
			position.getX() * SPACE_WIDTH, 
			position.getY() * SPACE_HEIGHT, 
			SPACE_WIDTH, 
			SPACE_HEIGHT
		);
	}

}
