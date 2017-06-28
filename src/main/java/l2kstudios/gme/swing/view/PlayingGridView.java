package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;

public class PlayingGridView {
	
	private PlayingGrid playingGrid;
	
	private int spaceHeight = 80;
	private int spaceWidth = 80;
	

	public void draw(Graphics drawingCtx) {
		drawVerticalGridLines(drawingCtx);
		drawHorizontalGridLines(drawingCtx);
	}
	
	
	private void drawVerticalGridLines(Graphics drawingCtx) {
		int width = playingGrid.getWidth();
		int height = playingGrid.getHeight();
		
		for(int x = 0; x <= width; x++) {
			drawingCtx.drawLine(x * spaceWidth, 0, x * spaceWidth, height * spaceHeight);
		}
	}


	public void drawHorizontalGridLines(Graphics drawingCtx) {
		int width = playingGrid.getWidth();
		int height = playingGrid.getHeight();
		
		for(int y = 0; y <= height; y++) {
			drawingCtx.drawLine(0, y * spaceHeight, width * spaceWidth, y * spaceHeight);
		}
	}


	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}


	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

}
