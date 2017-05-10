package l2kstudios.gme.view;

import static l2kstudios.gme.view.constants.GridConstants.*;
//import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_WIDTH;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.Position;
import processing.core.PApplet;

public class GridDrawingUtil {
	
	static private GridDrawingUtil gridDrawingUtil;
			
	private PApplet ctx;
	
	private GridDrawingUtil() {}
	
	static public GridDrawingUtil getInstance() {
		if(gridDrawingUtil == null)
			gridDrawingUtil = new GridDrawingUtil();
		
		return gridDrawingUtil;
	}
	
	public void drawEllipseAt(Position spacePos, Offsets offsets, float widthRatio, float  heightRatio) {
		ctx.ellipse(
			spacePos.getX() * SPACE_WIDTH + offsets.getHorizontal(), 
			spacePos.getY() * SPACE_HEIGHT + offsets.getVertical(), 
			SPACE_WIDTH * widthRatio, 
			SPACE_HEIGHT * heightRatio
		);
	}
	
	public void drawRectAt(Position spacePos) {
		ctx.rect(
			spacePos.getX() * SPACE_WIDTH, 
			spacePos.getY() * SPACE_HEIGHT, 
			SPACE_WIDTH,
			SPACE_HEIGHT
		);
	}

	public void setDrawingContext(PApplet ctx) {
		this.ctx = ctx;
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
