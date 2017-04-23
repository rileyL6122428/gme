package l2kstudios.gme.model.level;

import static l2kstudios.gme.model.level.Level.State.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.level.InputDispatcher.Input;
import l2kstudios.gme.model.unit.Unit;

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
