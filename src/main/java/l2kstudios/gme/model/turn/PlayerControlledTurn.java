package l2kstudios.gme.model.turn;


import static l2kstudios.gme.model.turn.PlayerControlledTurn.TurnState.*;
import static l2kstudios.gme.model.turn.PlayerControlledTurn.SelectionContext.*;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.UnitActionFactory;
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
	
	enum SelectionContext {
		FROM_SELECT_INPUT, FROM_UNDO_INPUT
	}
	
	private PhaseSequence phaseSequence;
	
	private Move move;
	private PostMoveAction postMoveAction;
	private Class postMoveActionType;
	private UnitActionFactory unitActionFactory;

	private Unit actingUnit;	
	private PlayingGrid playingGrid;
	private ActionInterface actionInterface;
	
	private TurnState turnState = PLACING_MOVE;
	
	public boolean readyToCommit() {
//		return turnState == FINISHED;
		return phaseSequence.isFinished();
	}
	
	public void commit() {
		postMoveAction.execute();
	}
	
	public List<Action> getPostMoveActions() {
		return unitActionFactory.getPostMoveActions(actingUnit, postMoveActionType);
	}
	
	public void update() { }

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
//				if(actionInterface.select()) advanceTurnState();
				if(actionInterface.select()) phaseSequence.advance();
				break;
			case BACK: 
//				regressTurnState();
				phaseSequence.regress();
				break;
		}
		
	}

	private void advanceTurnState() {
		switch(turnState) {
			case PLACING_MOVE: 
				transitionToChoosingPostMoveActionTypeSelection(FROM_SELECT_INPUT);
				break;
			case CHOOSING_POST_MOVE_ACTION_TYPE: 
				transitionToActionInstanceSelection(FROM_SELECT_INPUT);
				break;
			case CHOOSING_POST_MOVE_ACTION_INSTANCE:
				transitionToPlacingPostMoveAction(FROM_SELECT_INPUT);
				break;
			case PLACING_POST_MOVE_ACTION:
				turnState = FINISHED;
				break;
		}
	}
	
	private void regressTurnState() {
		switch(turnState) {
			case PLACING_MOVE: 
				break;
			case CHOOSING_POST_MOVE_ACTION_TYPE: 
				transitionToMoveSelection(FROM_UNDO_INPUT); 
				break;
			case CHOOSING_POST_MOVE_ACTION_INSTANCE:
				transitionToChoosingPostMoveActionTypeSelection(FROM_UNDO_INPUT);
				break;
			case PLACING_POST_MOVE_ACTION:
				transitionToActionInstanceSelection(FROM_UNDO_INPUT);
				break;				
		}
		
	}
	
	private void transitionToMoveSelection(SelectionContext selectionContext) {
		if(selectionContext == FROM_UNDO_INPUT) 
			move.undo();
		else if(selectionContext == FROM_SELECT_INPUT)
			initializeMove();			
		
		setActionInterface(new ActionPlacementInterface());
		turnState = PLACING_MOVE;
	}
	
	private void transitionToChoosingPostMoveActionTypeSelection(SelectionContext selectionContext) {
		if(selectionContext == FROM_UNDO_INPUT) 
			postMoveActionType = null;
		 else if(selectionContext == FROM_SELECT_INPUT) 
			move.execute();
		
		setActionInterface(new PostMoveDecisionMenu());
		turnState = CHOOSING_POST_MOVE_ACTION_TYPE;
	}
	
	private void transitionToActionInstanceSelection(SelectionContext selectionContext) {
		if(selectionContext == FROM_UNDO_INPUT) 
			postMoveAction = null;
		
		setActionInterface(new ActionInstanceMenu());
		turnState = CHOOSING_POST_MOVE_ACTION_INSTANCE;
	}
	
	private void transitionToPlacingPostMoveAction(SelectionContext selectionContext) {
		setActionInterface(new ActionPlacementInterface());
		turnState = PLACING_POST_MOVE_ACTION;
	}
	
	private void initializeMove() {
		move = new Move();
		move.setExecutingUnit(actingUnit);
		move.setPlayingGrid(playingGrid);
	}
	
	public void afterPropertiesSet() {
		initializeUnitActionFactory();
//		transitionToMoveSelection(FROM_SELECT_INPUT);
		initializeMove();
		setActionInterface(new ActionPlacementInterface());
		initializePhaseSequence();
	}
	
	private void transitionToPostMovePhase() {
		move.execute();
		setActionInterface(new PostMoveDecisionMenu());
	}
	
	private void initializePhaseSequence() {
		phaseSequence = new PhaseSequence();
		
		phaseSequence.add(new MovePlacementPhase());
		phaseSequence.add(new PostMoveActionTypeSelectionPhase());
		phaseSequence.add(new PostMoveActionInstanceSelectionPhase());
		phaseSequence.add(new PostMoveActionPlacementPhase());
	}
	
	class MovePlacementPhase extends Phase {{
		setAdvanceCallback(() -> {
			move.execute();
			setActionInterface(new PostMoveDecisionMenu());
		});
	}}
	
	class PostMoveActionTypeSelectionPhase extends Phase {{
		setAdvanceCallback( () -> setActionInterface(new ActionInstanceMenu()) );
		
		setRegressionCallback(() -> {
			move.undo();			
			setActionInterface(new ActionPlacementInterface());
		});
	}}
	
	class PostMoveActionInstanceSelectionPhase extends Phase {{
		setAdvanceCallback( () -> setActionInterface(new ActionPlacementInterface()) );
		
		setRegressionCallback(() -> {
			postMoveActionType = null;
			setActionInterface(new PostMoveDecisionMenu());
		});
	}}
	
	class PostMoveActionPlacementPhase extends Phase {{
		setRegressionCallback(() -> {
			postMoveAction = null;
			setActionInterface(new ActionInstanceMenu());
		});
	}}
	
	private void initializeUnitActionFactory() {
		unitActionFactory = new UnitActionFactory();
		unitActionFactory.setPlayingGrid(playingGrid);		
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
	
	public Action getPlacingAction() {
		return (postMoveAction == null) ? move : postMoveAction;		
	}

	public Class getPostMoveActionType() {
		return postMoveActionType;
	}

	public void setPostMoveActionType(Class postMoveActionType) {
		this.postMoveActionType = postMoveActionType;
	}

	public void setPostMoveAction(PostMoveAction action) {
		postMoveAction = action;
	}
	
	private void setActionInterface(ActionInterface actionInterface) {
		this.actionInterface = actionInterface;
		this.actionInterface.initialize(this);
	}

}
