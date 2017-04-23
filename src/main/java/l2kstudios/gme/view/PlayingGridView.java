package l2kstudios.gme.view;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.level.Level;
import processing.core.PApplet;

public class PlayingGridView implements View {
	
	public static final int GRID_BOX_WIDTH = 50;
	public static final int GRID_BOX_HEIGHT = 50;

	@Autowired
	private PlayingGrid playingGrid;
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
		Position cursorPosition = playingGrid.getCursorPosition();
		ctx.rect(cursorPosition.getX() * GRID_BOX_WIDTH, cursorPosition.getY() * GRID_BOX_HEIGHT, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);
	}

	private void drawVerticalGridLines() {
		for(int horizIdx = 0; horizIdx <= playingGrid.getWidth(); horizIdx++) {
			ctx.line(horizIdx * GRID_BOX_WIDTH, 0, horizIdx * GRID_BOX_WIDTH, GRID_BOX_HEIGHT * playingGrid.getHeight());
		}
	}

	private void drawHorizontalGridLines() {
		for(int vertIdx = 0; vertIdx <= playingGrid.getHeight(); vertIdx++) {
			ctx.line(0, vertIdx * GRID_BOX_HEIGHT, GRID_BOX_WIDTH * playingGrid.getWidth(), vertIdx * GRID_BOX_HEIGHT);
		}		
	}
}
