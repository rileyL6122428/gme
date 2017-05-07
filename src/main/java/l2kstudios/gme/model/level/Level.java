package l2kstudios.gme.model.level;

import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.InputDispatcher.Input;

public class Level {
	
	protected InputDispatcher inputDispatcher;
	protected PlayingGrid playingGrid;
	protected ActionMenu actionMenu;
	
	public void registerInput(Input input) {
		inputDispatcher.dispatchInput(input);
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public ActionMenu getActionMenu() {
		return actionMenu;
	}	
}
