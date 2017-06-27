package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.level.Level;

public class LevelView {
	
	private Level level;
	
	private PlayingGridView playingGridView;
	

	public void draw(Graphics drawingCtx) {
		playingGridView.draw(drawingCtx);
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		this.playingGridView = new PlayingGridView(){{ setPlayingGrid(level.getPlayingGrid()); }};
	}
	
}
