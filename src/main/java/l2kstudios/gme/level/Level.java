package l2kstudios.gme.level;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.InputDispatcher.Input;
import l2kstudios.gme.level.grid.PlayingGrid;

import static l2kstudios.gme.level.Level.State.*;

public class Level {
	
	public enum State {
		MAKIN_PLAYS
	}
	
	@Autowired
	private InputDispatcher inputDispatcher;
	
	@Autowired
	private PlayingGrid playingGrid;
	
	private State currentState = MAKIN_PLAYS;
	
	public void registerInput(Input input) {
		inputDispatcher.dispatchInput(input);
	}	
	
	public void moveCursorPositionBy(int deltaX, int deltaY) {
		playingGrid.moveCursorBy(deltaX, deltaY);
	}
	
	public Position getCursorPosition() {
		return playingGrid.getCursorPosition();
	}
	
	void setPlayingGrid(PlayingGrid grid) {
		this.playingGrid = grid;
	}
	
	public List<Unit> getUnits() {
		return playingGrid.getUnits();
	}
}
