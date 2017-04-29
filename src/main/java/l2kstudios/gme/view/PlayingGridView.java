package l2kstudios.gme.view;

import static l2kstudios.gme.view.constants.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.view.constants.GridConstants.SPACE_WIDTH;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import processing.core.PApplet;

public class PlayingGridView implements View {

	@Autowired
	private PlayingGrid playingGrid;
	@Autowired
	private PApplet ctx;
	@Autowired
	private GridDrawingUtil gridDrawingUtil;
	
	public void draw() {
		ctx.fill(0);
		drawHorizontalGridLines();
		drawVerticalGridLines();
		drawCursorPosition();
	}
	
	private void drawCursorPosition() {
		ctx.fill(0, 255, 255);
		Position cursorPosition = playingGrid.getCursorPosition();
		gridDrawingUtil.drawRectAt(cursorPosition);
	}

	private void drawVerticalGridLines() {
		for(int horizIdx = 0; horizIdx <= playingGrid.getWidth(); horizIdx++) {
			ctx.line(horizIdx * SPACE_WIDTH, 0, horizIdx * SPACE_WIDTH, SPACE_HEIGHT * playingGrid.getHeight());
		}
	}

	private void drawHorizontalGridLines() {
		for(int vertIdx = 0; vertIdx <= playingGrid.getHeight(); vertIdx++) {
			ctx.line(0, vertIdx * SPACE_HEIGHT, SPACE_HEIGHT * playingGrid.getWidth(), vertIdx * SPACE_HEIGHT);
		}		
	}
}
