package l2kstudios.gme.model.action;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public abstract class Action extends Placeable {
	
	protected Unit executingUnit;
	protected Space spaceToExecuteAt;
	protected Space spaceToExecuteFrom;
	protected RangeOfEffect rangeOfEffect;
	protected Range<Integer> executionRange;
	private int index;
	
	public void execute() {
		Position position = spaceToExecuteAt.getPosition();
		rangeOfEffect.affectedSpaces(position).forEach(this::affectSpace);
	}
	
	protected abstract void affectSpace(Space space);
	
	public boolean ableToExecuteAt(Space space) {		
		return ableToExecuteAt(space.getPosition());
	}
	
	public boolean ableToExecuteAt(Position executeAtPosition) {
		Position executeFromPosition = spaceToExecuteFrom.getPosition();
		int distanceToExecution = GridUtils.distanceBetween(executeAtPosition, executeFromPosition);
		return executionRange.contains(distanceToExecution);
	}
	
	public boolean targetSpaceSpecified() {
		return spaceToExecuteAt != null;
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
	
	public void setExecutingUnit(Unit executingUnit) {
		this.executingUnit = executingUnit;
	}

	public void setSpaceToExecuteAt(Space space) {
		this.spaceToExecuteAt = space;
	}
	
	public Space getSpaceToExecuteAt() {
		return spaceToExecuteAt;
	}
	
	public Space getSpaceToExecuteFrom() {
		return spaceToExecuteFrom;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		rangeOfEffect.setPlayingGrid(playingGrid);
	}

	public void setSpaceToExecuteFrom(Space spaceToExecuteFrom) {
		this.spaceToExecuteFrom = spaceToExecuteFrom;
	}
	
	public void setExecutionRange(Range range) {
		this.executionRange = range;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
