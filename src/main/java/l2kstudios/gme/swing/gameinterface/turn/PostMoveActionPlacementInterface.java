package l2kstudios.gme.swing.gameinterface.turn;

import java.awt.Graphics;
import java.util.Set;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.ActionUtil;
import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.grid.position.Position;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.swing.view.View;

public class PostMoveActionPlacementInterface extends TurnInterfaceBase implements ActionPlacementInterface {
	
	private Action action;
	private Set<PlayingGridSpace> chooseableSpaces;
	private PlayingGrid playingGrid;
	
	private View view;

	@Override
	public void draw(Graphics drawingCtx) {
		view.draw(drawingCtx);
	}

	@Override
	public PhaseProgressionFlag select() {
		if(action.ableToExecuteAt(getCursorPosition())) {
			turn.takeAction(this::placeAction, null);
			
			return PhaseProgressionFlag.ADVANCE;
		} else {
			return PhaseProgressionFlag.STAND_BY;			
		}
	}
	
	private void placeAction() {
		PlayingGrid playingGrid = turn.getPlayingGrid();
		Space space = playingGrid.getSpaceAt(getCursorPosition());
		action.setSpaceToExecuteAt(space);
		action.execute();
	}

	@Override
	public void initialize() {
		action = turn.getBufferedAction();
		chooseableSpaces = ActionUtil.chooseableSpaces(action, turn.getPlayingGrid());
		playingGrid = turn.getPlayingGrid();
		
		view = new ActionPlacementView(this);
	}

	@Override
	public Set<PlayingGridSpace> getChooseableSpaces() {
		return chooseableSpaces;
	}

	@Override
	public Position getCursorPosition() {
		return playingGrid.getCursorPosition();
	}

	@Override
	public RangeOfEffect getRangeOfEffect() {
		return action.getRangeOfEffect();
	}

	@Override
	public boolean canChoose(Position cursorPosition) {
		PlayingGrid playingGrid = turn.getPlayingGrid();
		PlayingGridSpace space = (PlayingGridSpace)playingGrid.getSpaceAt(cursorPosition);
		return chooseableSpaces.contains(space);
	}

	@Override
	public void moveCursorDown() {
		playingGrid.moveCursorDown();
	}

	@Override
	public void moveCursorUp() {
		playingGrid.moveCursorUp();
	}

	@Override
	public void moveCursorRight() {
		playingGrid.moveCursorRight();
	}

	@Override
	public void moveCursorLeft() {
		playingGrid.moveCursorLeft();
	}


}
