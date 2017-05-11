package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.InputDispatcher.Input;

public class Level implements InitializingBean {
	
	private InputDispatcher inputDispatcher;
	
	private PlayingGrid playingGrid;
	
	private ActionMenu actionMenu;
	
	protected ActingUnitTracker actingUnitTracker;
	
	public void registerInput(Input input) {
		inputDispatcher.dispatchInput(input);
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

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setupActingUnitTracker();
		playingGrid.setActingUnitTracker(actingUnitTracker);
		setupActionMenu();
		setupInputDispatcher();
	}

	private void setupActingUnitTracker() {
		actingUnitTracker = new ActingUnitTracker();
		actingUnitTracker.configureMovementCycle(playingGrid.getUnits());
	}
	
	private void setupActionMenu() {
		actionMenu = new ActionMenu();
		actionMenu.setActingUnitTracker(actingUnitTracker);
	}
	
	private void setupInputDispatcher() {
		inputDispatcher = new InputDispatcher();
		inputDispatcher.setActionMenu(actionMenu);
		inputDispatcher.setPlayingGrid(playingGrid);
		inputDispatcher.afterPropertiesSet();
	}
}
