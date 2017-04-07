package l2kstudios.gme.levelview;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import processing.core.PApplet;

public class GridView {
	@Autowired
	private Level level;
	
	@Autowired
	private PApplet ctx;
	
	private int gridBoxWidth = 50;
	private int gridBoxHeight = 50;
	
	public void draw() {
		ctx.fill(0);
		drawHorizontalGridLines();
		drawVerticalGridLines();
	}
	
	private void drawVerticalGridLines() {
		for(int horizIdx = 0; horizIdx <= level.getGridWidth(); horizIdx++) {
			ctx.line(horizIdx * gridBoxWidth, 0, horizIdx * gridBoxWidth, gridBoxHeight * level.getGridHeight());
		}
	}

	private void drawHorizontalGridLines() {
		for(int vertIdx = 0; vertIdx <= level.getGridHeight(); vertIdx++) {
			ctx.line(0, vertIdx * gridBoxHeight, gridBoxWidth * level.getGridWidth(), vertIdx * gridBoxHeight);
		}		
	}
	
	public int getGridBoxWidth() {
		return gridBoxWidth;
	}
	public void setGridBoxWidth(int gridBoxWidth) {
		this.gridBoxWidth = gridBoxWidth;
	}
	public int getGridBoxHeight() {
		return gridBoxHeight;
	}
	public void setGridBoxHeight(int gridBoxHeight) {
		this.gridBoxHeight = gridBoxHeight;
	}
}
