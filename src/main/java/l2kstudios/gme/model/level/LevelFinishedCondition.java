package l2kstudios.gme.model.level;

import java.util.function.BooleanSupplier;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;

public abstract class LevelFinishedCondition implements BooleanSupplier {
	
	protected Level level;
	protected PlayingGrid playingGrid;

	public LevelFinishedCondition(Level level) {
		this.level = level;
		this.playingGrid = level.getPlayingGrid();
	}
	
}
