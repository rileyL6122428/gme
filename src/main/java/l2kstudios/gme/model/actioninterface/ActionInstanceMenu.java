package l2kstudios.gme.model.actioninterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.PlayerControlledTurn;

public class ActionInstanceMenu extends SingleRowActionInterface {
	
	private PlayerControlledTurn turn;
	
	public void initialize(PlayerControlledTurn turn) {
		super.initialize(turn);
		this.turn = turn;
		List<Action> actions = turn.getPostMoveActions();
		List<Space> row = mapActionsToSpaces(actions);
		setRow(row);
		chooseableSpaces = row;
		cursor.setPosition(getSpaceAt(0).getPosition());
	}
	
	public boolean select() {
		PostMoveAction action = (PostMoveAction) hoveredSpace().getOccupier();
		turn.setPostMoveAction(action);
		return true;
	}
	
	private List<Space> mapActionsToSpaces(List<Action> actions) {
		final List<Space> spaces = new ArrayList<Space>();
		int actionIdx = 0;
		
		for(Action action : actions) {
			spaces.add(new Space(){{
				action.setIndex(actionIdx);
				setOccupier(action);
			}});
		}
		
		return spaces;
	}

	public void forEachActionInstance(Consumer<Action> callback) {
		chooseableSpaces.forEach((space) -> {
			Action action = (Action) space.getOccupier();
			callback.accept(action);
		});
	}

}
