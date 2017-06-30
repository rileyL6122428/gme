package l2kstudios.gme.swing.view;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.model.turn.Turn;

public class LevelView {
	
	private Level level;
	
	private PlayingGridView playingGridView;
	private List<CharacterView> characterViews;
	private PlayerControlledTurnView turnView;
	

	public void draw(Graphics drawingCtx) {
		playingGridView.draw(drawingCtx);
		characterViews.forEach( (characterView) -> characterView.draw(drawingCtx) );
		turnView.draw(drawingCtx);
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		this.playingGridView = new PlayingGridView(){{ setPlayingGrid(level.getPlayingGrid()); }};
		this.characterViews = level.getPlayingGrid()
									.getUnits()
									.stream()
									.map((unit) -> new CharacterView(){{setUnit(unit);}})
									.collect(Collectors.toList());
		this.turnView = new PlayerControlledTurnView(){{ setTurn((PlayerControlledTurn)level.getCurrentTurn()); }};
		
	}
	
}
