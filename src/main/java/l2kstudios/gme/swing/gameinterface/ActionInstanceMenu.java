package l2kstudios.gme.swing.gameinterface;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.turn.PlayerControlledTurn;

public class ActionInstanceMenu extends SingleRowActionInterface implements Interface {
	
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
			action.setIndex(actionIdx);
			actionIdx++;
			
			spaces.add(new Space(){{
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

	@Override
	public void draw(Graphics drawingCtx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveInput(Input input) {
		// TODO Auto-generated method stub
		
	}

}
