package l2kstudios.gme.model.actioninterface;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.model.unit.Unit;

public class ActionPlacementInterface extends ActionInterface {
	
	protected List<Space> chooseableSpaces;
	
	private Action action;

	public List<Space> getChooseableSpaces() {
		return chooseableSpaces;
	}
	
	public void initialize(PlayerControlledTurn turn) {
		this.action = turn.getPlacingAction();
		setSpaces(turn.getPlayingGrid().getSpaces());
		setChooseableSpaces(turn.getPlayingGrid());
		cursor.setPosition(turn.getActingUnit().getPosition());
	}
	
	private void setChooseableSpaces(PlayingGrid playingGrid) {
		chooseableSpaces = new ArrayList<Space>();
		
		playingGrid.forEachSpace((space) -> {
			if(action.ableToExecuteAt(space)) chooseableSpaces.add(space);
		});
	}

	public boolean select() {
		if(action.ableToExecuteAt(hoveredSpace())) {
			action.setSpaceToExecuteAt(hoveredSpace());
			return true;
		}
		
		return false;
	}
	
	
	public void initialize() {
		Unit actingUnit = action.getExecutingUnit();
		moveCursorTo(actingUnit.getPosition());
	}

	public Range<Integer> getExectuionRange() {
		return action.getExecutionRange();
	}
	
	public RangeOfEffect getRangeOfEffect() {
		return action.getRangeOfEffect();
	}
}
