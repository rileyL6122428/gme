package l2kstudios.gme.model.level.factory;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.factory.InputDispatcher.Input;
import l2kstudios.gme.model.unit.Unit;

public class Level implements InitializingBean {
	
	private InputDispatcher inputDispatcher;
	
	private PlayingGrid playingGrid;
	
	private ActionMenu actionMenu;
	
	protected ActingUnitTracker actingUnitTracker;
	
	public void registerInput(Input input) {
		getInputDispatcher().dispatchInput(input);
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public ActionMenu getActionMenu() {
		return actionMenu;
	}

	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}

	public void setActionMenu(ActionMenu actionMenu) {
		this.actionMenu = actionMenu;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public InputDispatcher getInputDispatcher() {
		return inputDispatcher;
	}

	public void setInputDispatcher(InputDispatcher inputDispatcher) {
		this.inputDispatcher = inputDispatcher;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		inputDispatcher.setActionMenu(actionMenu);
		inputDispatcher.setPlayingGrid(playingGrid);
		
		playingGrid.setActingUnitTracker(actingUnitTracker);
		
		actionMenu.setActingUnitTracker(actingUnitTracker);
	}
	
}
