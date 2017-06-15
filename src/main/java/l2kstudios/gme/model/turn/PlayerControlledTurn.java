package l2kstudios.gme.model.turn;

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
	
	private PhaseSequence phaseSequence;
	private ActionInterface actionInterface;
	
	private Move move;
	private PostMoveAction postMoveAction;
	private Class postMoveActionType;
	private UnitActionFactory unitActionFactory;

	private Unit actingUnit;	
	private PlayingGrid playingGrid;
	
	public boolean readyToCommit() {
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
			case UP   : actionInterface.moveCursorUp();                       break;
			case RIGHT: actionInterface.moveCursorRight();                    break;
			case LEFT : actionInterface.moveCursorLeft();                     break;
			case DOWN : actionInterface.moveCursorDown();                     break;
			
			case SPACE: if(actionInterface.select()) phaseSequence.advance(); break;
			case BACK : phaseSequence.regress();                              break;
		}
	}

	public void afterPropertiesSet() {
		initializeUnitActionFactory();
		initializeUnitMove();
		setActionInterface(new ActionPlacementInterface());
		initializePhaseSequence();
	}
	
	private void initializeUnitActionFactory() {
		unitActionFactory = new UnitActionFactory();
		unitActionFactory.setPlayingGrid(playingGrid);		
	}
	
	private void initializeUnitMove() {
		move = new Move();
		move.setExecutingUnit(actingUnit);
		move.setPlayingGrid(playingGrid);
		move.setSpaceToExecuteFrom(actingUnit.getOccupiedSpace());
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
