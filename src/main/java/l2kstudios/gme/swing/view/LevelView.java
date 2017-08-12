package l2kstudios.gme.swing.view;

import java.awt.Graphics;
import java.util.List;

public class LevelView implements View {
	
	private PlayingGridView playingGridView;
	private List<CharacterView> characterViews;
	private MoveOrderView moveOrderView;
	

	public void draw(Graphics drawingCtx) {
		playingGridView.draw(drawingCtx);
		characterViews.forEach( (characterView) -> characterView.draw(drawingCtx) );
		moveOrderView.draw(drawingCtx);
	}

	public PlayingGridView getPlayingGridView() {
		return playingGridView;
	}

	public void setPlayingGridView(PlayingGridView playingGridView) {
		this.playingGridView = playingGridView;
	}

	public List<CharacterView> getCharacterViews() {
		return characterViews;
	}

	public void setCharacterViews(List<CharacterView> characterViews) {
		this.characterViews = characterViews;
	}

	public MoveOrderView getMoveOrderView() {
		return moveOrderView;
	}

	public void setMoveOrderView(MoveOrderView moveOrderView) {
		this.moveOrderView = moveOrderView;
	}
	
}
