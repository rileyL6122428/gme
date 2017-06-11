package l2kstudios.gme.model.turn;

import static l2kstudios.gme.model.turn.PlayerControlledTurn.TurnState.CHOOSING_POST_MOVE_ACTION_INSTANCE;
import static l2kstudios.gme.model.turn.PlayerControlledTurn.TurnState.CHOOSING_POST_MOVE_ACTION_TYPE;
import static l2kstudios.gme.model.turn.PlayerControlledTurn.TurnState.FINISHED;
import static l2kstudios.gme.model.turn.PlayerControlledTurn.TurnState.PLACING_MOVE;
import static l2kstudios.gme.model.turn.PlayerControlledTurn.TurnState.PLACING_POST_MOVE_ACTION;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.move.Move;
import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.actioninterface.ActionInstanceMenu;
import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.actioninterface.ActionPlacementInterface;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.unit.Unit;

public class PlayerControlledTurn implements Turn {
	
	enum TurnState {
		PLACING_MOVE, 
		CHOOSING_POST_MOVE_ACTION_TYPE,
		CHOOSING_POST_MOVE_ACTION_INSTANCE,
		PLACING_POST_MOVE_ACTION,
		FINISHED
	}
	
	private Move move;
	private PostMoveAction postMoveAction;
	private Class postMoveActionType;

	private Unit actingUnit;	
	private PlayingGrid playingGrid;
	private ActionInterface actionInterface;
	
	private TurnState turnState = PLACING_MOVE;

	@Override
	public void receiveInput(Input input) {
		switch(input) {
		case UP:    
			actionInterface.moveCursorUp(); 
			break;
		case RIGHT: 
			actionInterface.moveCursorRight(); 
			break;
		case LEFT:
			actionInterface.moveCursorLeft();
			break;
		case DOWN:
			actionInterface.moveCursorDown();
			break;
		case SPACE:
			if(actionInterface.select()) setNextActionInterface();
			break;
		case BACK:
			setPreviousActionInterface();
			break;
		}
		
	}

	private void setNextActionInterface() {
		switch(turnState) {
			case PLACING_MOVE: 
				move.execute();
				actionInterface = new PostMoveDecisionMenu();
				turnState = CHOOSING_POST_MOVE_ACTION_TYPE;
				break;
			case CHOOSING_POST_MOVE_ACTION_TYPE: 
				actionInterface = new ActionInstanceMenu();
				turnState = CHOOSING_POST_MOVE_ACTION_INSTANCE;
				break;
			case CHOOSING_POST_MOVE_ACTION_INSTANCE:
				actionInterface = new ActionPlacementInterface();
				turnState = PLACING_POST_MOVE_ACTION;
				break;
			case PLACING_POST_MOVE_ACTION:
				turnState = FINISHED;
				break;
			default:
				throw new RuntimeException("ILLEGAL STATE IN TURN");
		}
		
		actionInterface.initialize(this);	
	}
	
	private void setPreviousActionInterface() {
		switch(turnState) {
			case PLACING_MOVE: 
				break;
			case CHOOSING_POST_MOVE_ACTION_TYPE: 
				move.undo();
				actionInterface = new ActionPlacementInterface();
				actionInterface.initialize(this);
				turnState = PLACING_MOVE;
				break;
			case CHOOSING_POST_MOVE_ACTION_INSTANCE:
				postMoveActionType = null;
				actionInterface = new PostMoveDecisionMenu();
				actionInterface.initialize(this);
				turnState = CHOOSING_POST_MOVE_ACTION_TYPE;
				break;
				
			case PLACING_POST_MOVE_ACTION:
				postMoveAction = null;
				actionInterface = new ActionInstanceMenu();
				actionInterface.initialize(this);
				turnState = CHOOSING_POST_MOVE_ACTION_INSTANCE;
				break;
				
			default:
				throw new RuntimeException("ILLEGAL STATE IN TURN");
		}
	}

	public boolean readyToCommit() {
		return turnState == FINISHED;
	}
	
	public void commit() {
		postMoveAction.execute();
	}
	
	public void setActingUnit(Unit unit) {
		this.actingUnit = unit;
	}

	public ActionInterface getCurrentActionInterface() {
		return actionInterface;
	}

	public Unit getActingUnit() {
		return actingUnit;
	}	
	
	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}
	
	public void afterPropertiesSet() {
		move = new Move();
		move.setExecutingUnit(actingUnit);
		move.setPlayingGrid(playingGrid);
		actionInterface = new ActionPlacementInterface();
		actionInterface.initialize(this);
	}

	public Action getPlacingAction() {
		return (postMoveAction == null) ? move : postMoveAction;		
	}

	public Class getPostMoveActionType() {
		return postMoveActionType;
	}

	public void setPostMoveActionType(Class postMoveActionType) {
		this.postMoveActionType = postMoveActionType;
	}

	public List<Action> getPostMoveActions() {
		List<Class> actionTypes = actingUnit.getActionTypes(postMoveActionType);
		
		final List<Action> postMoveActions = new ArrayList<Action>();
		actionTypes.forEach((ActionType) -> {
			try {
				Action action = (Action) ActionType.newInstance();
				action.setExecutingUnit(actingUnit);
				action.setPlayingGrid(playingGrid);
				postMoveActions.add(action);
				action.setSpaceToExecuteFrom(move.getSpaceToExecuteAt());
				
			} catch (Exception e) { e.printStackTrace(); }
		});
		
		return postMoveActions;
	}

	public void setPostMoveAction(PostMoveAction action) {
		postMoveAction = action;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
