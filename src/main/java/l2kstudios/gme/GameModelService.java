package l2kstudios.gme;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.Level;

public class GameModelService {
	
	private static App game;

	public static void setGame(App game) {
		GameModelService.game = game;
	}
	
	public static Level getCurrentLevel() {
		return game.getLevel();
	}
	
	public static PlayingGrid getCurrentPlayingGrid() {
		return getCurrentLevel().getPlayingGrid();
	}
}
