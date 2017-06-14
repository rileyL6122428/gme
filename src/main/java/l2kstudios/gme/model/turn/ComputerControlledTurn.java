package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.action.UnitActionFactory;
import l2kstudios.gme.model.action.move.Move;
import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.actioninterface.ActionInstanceMenu;
import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.actioninterface.ActionPlacementInterface;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.turn.PlayerControlledTurn.MovePlacementPhase;
import l2kstudios.gme.model.turn.PlayerControlledTurn.PostMoveActionInstanceSelectionPhase;
import l2kstudios.gme.model.turn.PlayerControlledTurn.PostMoveActionPlacementPhase;
import l2kstudios.gme.model.turn.PlayerControlledTurn.PostMoveActionTypeSelectionPhase;
import l2kstudios.gme.model.unit.ComputerControlledUnit;
import l2kstudios.gme.model.unit.Unit;

public class ComputerControlledTurn implements Turn {

	private PhaseSequence phaseSequence;
	
	private Move move;
	private PostMoveAction postMoveAction;
	private Class postMoveActionType;
	private UnitActionFactory unitActionFactory;
	
	private ComputerControlledUnit actingUnit;	
	private PlayingGrid playingGrid;
	
	@Override
	public void receiveInput(Input input) { }

	@Override
	public boolean readyToCommit() {
		return phaseSequence.isFinished();
	}

	@Override
	public void commit() {
		postMoveAction.execute();
	}

	@Override
	public void update() {
		phaseSequence.advance();
	}

	@Override
	public void afterPropertiesSet() {
		iniatializeUnitActionFactory();
		initializeUnitMove();
		initializePhaseSequence();
	}
	
	private void iniatializeUnitActionFactory() {
		unitActionFactory = new UnitActionFactory();
		unitActionFactory.setPlayingGrid(getPlayingGrid());
	}

	private void initializeUnitMove() {
		move = new Move();
		move.setExecutingUnit(getActingUnit());
		move.setPlayingGrid(getPlayingGrid());
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
			move.setSpaceToExecuteAt(getActingUnit().getMoveSpace());
			move.execute();
		});
	}}
	
	class PostMoveActionTypeSelectionPhase extends Phase {{
		setAdvanceCallback(() -> {});
	}}
	
	class PostMoveActionInstanceSelectionPhase extends Phase {{
		setAdvanceCallback(() -> { 
			 postMoveActionType = getActingUnit().getPostMoveActionInstanceClass();
			 postMoveAction = (PostMoveAction) unitActionFactory.instantiateAction(getActingUnit(), postMoveActionType);
		});
	}}
	
	class PostMoveActionPlacementPhase extends Phase {{
		setAdvanceCallback(() -> {
			postMoveAction.setSpaceToExecuteAt(getActingUnit().getPostMoveActionPosition());
		});
	}}
	
	public ComputerControlledUnit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(ComputerControlledUnit actingUnit) {
		this.actingUnit = actingUnit;
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
}
