package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.position.Position;

import static l2kstudios.gme.swing.view.GridConstants.*;

public class PlayingGridView {
	
	private PlayingGrid playingGrid;

	public void draw(Graphics drawingCtx) {
		drawingCtx.setColor(Color.BLACK);
		drawVerticalGridLines(drawingCtx);
		drawHorizontalGridLines(drawingCtx);
		fillInUnmoveableSpaces(drawingCtx);
	}	

	private void drawVerticalGridLines(Graphics drawingCtx) {
		int width = playingGrid.getWidth();
		int height = playingGrid.getHeight();
		
		for(int x = 0; x <= width; x++) {
			drawingCtx.drawLine(x * SPACE_WIDTH, 0, x * SPACE_WIDTH, height * SPACE_HEIGHT);
		}
	}

	public void drawHorizontalGridLines(Graphics drawingCtx) {
		int width = playingGrid.getWidth();
		int height = playingGrid.getHeight();
		
		for(int y = 0; y <= height; y++) {
			drawingCtx.drawLine(0, y * SPACE_HEIGHT, width * SPACE_WIDTH, y * SPACE_HEIGHT);
		}
	}

	private void fillInUnmoveableSpaces(Graphics drawingCtx) {
		drawingCtx.setColor(Color.BLACK);
		
		playingGrid.forEachSpace((space)-> {
			if(!space.isOccupiable()) {
				Position position = space.getPosition();
				drawingCtx.fillRect(position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
			}
		}); 
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}


	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

}
