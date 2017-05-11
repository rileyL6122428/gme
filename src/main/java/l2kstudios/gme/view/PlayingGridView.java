package l2kstudios.gme.view;

import static l2kstudios.gme.view.constants.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.view.constants.GridConstants.SPACE_WIDTH;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import processing.core.PApplet;

public class PlayingGridView extends View<PlayingGrid> {

	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	private GridDrawingUtil gridDrawingUtil;

	public void draw() {
		ctx.fill(0);
		drawHorizontalGridLines();
		drawVerticalGridLines();
		drawCursorPosition();
	}
	
	private void drawCursorPosition() {
		ctx.fill(0, 255, 255);
		Position cursorPosition = model.getCursorPosition();
		gridDrawingUtil.drawRectAt(cursorPosition);
	}

	private void drawVerticalGridLines() {
		for(int horizIdx = 0; horizIdx <= model.getWidth(); horizIdx++) {
			ctx.line(horizIdx * SPACE_WIDTH, 0, horizIdx * SPACE_WIDTH, SPACE_HEIGHT * model.getHeight());
		}
	}

	private void drawHorizontalGridLines() {
		for(int vertIdx = 0; vertIdx <= model.getHeight(); vertIdx++) {
			ctx.line(0, vertIdx * SPACE_HEIGHT, SPACE_HEIGHT * model.getWidth(), vertIdx * SPACE_HEIGHT);
		}		
	}
	
	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.model = playingGrid;
	}
	
	public void setGridDrawingUtil(GridDrawingUtil gridDrawingUtil) {
		this.gridDrawingUtil = gridDrawingUtil;
	}
}
