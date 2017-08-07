package l2kstudios.gme.model.action;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public class ActionFactory {
	
	private PlayingGrid playingGrid;
	
	public List<Action> getPostMoveActions(Unit unit, Class postMoveActionType) {
		final List<Action> postMoveActions = new ArrayList<Action>();
		
		unit.getActionTypes(postMoveActionType).forEach((actionType) -> {
			Action action = instantiateAction(unit, actionType);
			postMoveActions.add(action);
		});
		
		return postMoveActions;
	}
	
	public Action instantiateAction(Unit unit, Class actionType) {
		try {
			Action action = (Action) actionType.newInstance();
			action.setExecutingUnit(unit);
			action.setPlayingGrid(getPlayingGrid());
			action.setSpaceToExecuteFrom(unit.getOccupiedSpace());
			return action;
		} catch (Exception e) {
			throw new RuntimeException("Unable to instantiate action type");
		}
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
}
