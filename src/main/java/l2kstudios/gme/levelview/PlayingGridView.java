package l2kstudios.gme.levelview;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Level;
import l2kstudios.gme.level.Position;
import processing.core.PApplet;

public class PlayingGridView {
	
	public static final int GRID_BOX_WIDTH = 50;
	public static final int GRID_BOX_HEIGHT = 50;

	@Autowired
	private Level level;
	@Autowired
	private PApplet ctx;
	
	public void draw() {
		ctx.fill(0);
		drawHorizontalGridLines();
		drawVerticalGridLines();
		drawCursorPosition();
	}
	
	private void drawCursorPosition() {
		ctx.fill(0, 255, 255);
		Position cursorPosition = level.getCursorPosition();
		ctx.rect(cursorPosition.getX() * GRID_BOX_WIDTH, cursorPosition.getY() * GRID_BOX_HEIGHT, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);
	}

	private void drawVerticalGridLines() {
		for(int horizIdx = 0; horizIdx <= level.getGridWidth(); horizIdx++) {
			ctx.line(horizIdx * GRID_BOX_WIDTH, 0, horizIdx * GRID_BOX_WIDTH, GRID_BOX_HEIGHT * level.getGridHeight());
		}
	}

	private void drawHorizontalGridLines() {
		for(int vertIdx = 0; vertIdx <= level.getGridHeight(); vertIdx++) {
			ctx.line(0, vertIdx * GRID_BOX_HEIGHT, GRID_BOX_WIDTH * level.getGridWidth(), vertIdx * GRID_BOX_HEIGHT);
		}		
	}
}
