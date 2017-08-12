package l2kstudios.gme.swing.view;

import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.level.Level;

public class LevelViewFactory {
	
	public static LevelView newLevelView(Level level) {
		LevelView levelView = new LevelView();
		
		levelView.setPlayingGridView(newPlayingGridView(level));
		levelView.setCharacterViews(newCharacterViews(level));
		levelView.setMoveOrderView(newMoveOrderView(level));
		
		return levelView;
	}
	
	private static PlayingGridView newPlayingGridView(Level level) {
		PlayingGridView playingGridView = new PlayingGridView();
		playingGridView.setPlayingGrid(level.getPlayingGrid());
		return playingGridView;
	}
	
	private static List<CharacterView> newCharacterViews(Level level) {
		return level.getUnits()
					.stream()
					.map((unit) -> new CharacterView(){{setUnit(unit);}})
					.collect(Collectors.toList());
	}
	
	private static MoveOrderView newMoveOrderView(Level level) {
		MoveOrderView moveOrderView = new MoveOrderView();
		moveOrderView.setLevel(level);
		return moveOrderView;
	}
	
}
