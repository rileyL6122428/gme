package l2kstudios.gme.view;

import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_HEIGHT;
import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_WIDTH;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.Position;
import processing.core.PApplet;

public class GridDrawingUtil {
	
	@Autowired
	private PApplet ctx;
	
	public void drawEllipseAt(Position spacePos, Offsets offsets, float widthRatio, float  heightRatio) {
		ctx.ellipse(
			spacePos.getX() * GRID_BOX_WIDTH + offsets.getHorizontal(), 
			spacePos.getY() * GRID_BOX_HEIGHT + offsets.getVertical(), 
			GRID_BOX_WIDTH * widthRatio, 
			GRID_BOX_HEIGHT * heightRatio
		);
	}
	
	public static class Offsets {
		private int vertical;
		private int horizontal;
		
		public int getVertical() {
			return vertical;
		}
		public void setVertical(int vertical) {
			this.vertical = vertical;
		}
		public int getHorizontal() {
			return horizontal;
		}
		public void setHorizontal(int horizontal) {
			this.horizontal = horizontal;
		}
	}
}
