package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.AttackOptions;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.InputDispatcher.Input;

public class Level implements InitializingBean {
	
	private InputDispatcher inputDispatcher;
	
	private PlayingGrid playingGrid;
	
	private PostMoveDecisionMenu actionMenu;
	
	private AttackOptions attackOptions;
	
	protected ActingUnitTracker actingUnitTracker;
	
	public void registerInput(Input input) {
		inputDispatcher.dispatchInput(input);
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public PostMoveDecisionMenu getActionMenu() {
		return actionMenu;
	}

	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public AttackOptions getAttackOptions() {
		return attackOptions;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setupActingUnitTracker();
		playingGrid.setActingUnitTracker(actingUnitTracker);
		setupActionMenu();
		setupAttackOptionsMenu();
		setupInputDispatcher();
	}


	private void setupActingUnitTracker() {
		actingUnitTracker = new ActingUnitTracker();
		actingUnitTracker.configureMovementCycle(playingGrid.getUnits());
	}
	
	private void setupActionMenu() {
		actionMenu = new PostMoveDecisionMenu();
		actionMenu.setActingUnitTracker(actingUnitTracker);
	}
	
	private void setupAttackOptionsMenu() {
		attackOptions = new AttackOptions();
		attackOptions.setActingUnitTracker(actingUnitTracker);
	}
	
	private void setupInputDispatcher() {
		inputDispatcher = new InputDispatcher();
		inputDispatcher.setActionMenu(actionMenu);
		inputDispatcher.setPlayingGrid(playingGrid);
		inputDispatcher.setAttackOptions(attackOptions);
		inputDispatcher.setActingUnitTracker(actingUnitTracker);
		inputDispatcher.afterPropertiesSet();
	}

}
