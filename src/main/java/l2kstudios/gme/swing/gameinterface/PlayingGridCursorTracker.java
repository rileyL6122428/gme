package l2kstudios.gme.swing.gameinterface;

import l2kstudios.gme.model.grid.Position;

public class PlayingGridCursorTracker {
	
	static final PlayingGridCursorTracker playingGridCursorTracker;
	
	static {
		playingGridCursorTracker = new PlayingGridCursorTracker();
	}
	
	public static PlayingGridCursorTracker getInstance() {
		return playingGridCursorTracker;
	}
	
	private Position lastHoveredBoardPosition;
	
	public Position getLastHoveredBoardPosition() {
		return lastHoveredBoardPosition;
	}

	public void setLastHoveredBoardPosition(Position lastHoveredBoardPosition) {
		this.lastHoveredBoardPosition = lastHoveredBoardPosition;
	}
	
}
