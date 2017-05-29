package l2kstudios.gme.model.action;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public abstract class Action extends Placeable {
	
	protected Unit executingUnit;
	protected Space spaceToExecuteAt;
	protected RangeOfEffect rangeOfEffect;
	protected Range<Integer> executionRange;
	
	public void execute() {
		Position position = spaceToExecuteAt.getPosition();
		
		rangeOfEffect.affectedSpaces(position).forEach(this::affectSpace);
	}
	
	protected abstract void affectSpace(Space space);
	
	public boolean targetSpaceSpecified() {
		return spaceToExecuteAt != null;
	}
	
	public Space getSpaceToExecuteAt() {
		return spaceToExecuteAt;
	}
	
	private boolean outOfRange(Position position) {
		int distanceToExecution = GridUtils.distanceBetween(position, getExecutingUnit().getPosition());
		return !executionRange.contains(distanceToExecution);
	}
	
	public boolean ableToExecuteAt(Space space) {
		return outOfRange(space.getPosition());
	}
	
	public void setRangeOfEffect(RangeOfEffect rangeOfEffect) {
		this.rangeOfEffect = rangeOfEffect;
	}
	
	public RangeOfEffect getRangeOfEffect() {
		return rangeOfEffect;
	}
	
	public Range<Integer> getExecutionRange() {
		return executionRange;
	}
	
	public Unit getExecutingUnit() {
		return executingUnit;
	}

	public void setSpaceOfExecution(Space space) {
		this.spaceToExecuteAt = space;
	}

	public void setExecutingUnit(Unit executingUnit) {
		this.executingUnit = executingUnit;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		rangeOfEffect.setPlayingGrid(playingGrid);
	}
}
