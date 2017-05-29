package l2kstudios.gme.model.actioninterface;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.Turn;

public class ActionInstanceMenu extends SingleRowActionInterface {
	
	private Turn turn;
	
	public void initialize(Turn turn) {
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
		
		actions.forEach((action) -> {
			spaces.add(new Space(){{
				setOccupier(action);
			}});
		});
		
		return spaces;
	}
}
