package l2kstudios.gme.model.action.attack;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.actioninterface.AttackPlacement;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class Attack extends Action {
	
	private static int MINIMUM_DAMAGE = 1;
	
	protected RangeOfEffect rangeOfEffect;
	
	protected Range<Integer> executionRange;
	
	protected int baseDamage;
	
	protected Space spaceToExecuteAt;
	
	public Attack(Unit executingUnit) {
		super(executingUnit);
	}
	
	public boolean executeAt(Space space) {
		return executeAt(space.getPosition());
	}
	
	public boolean executeAt(Position position) {
		if(outOfRange(position)) return false;
		
		rangeOfEffect.affectedSpaces(position).forEach((space) -> {
			if(space.isOccupied()){
				Unit occupier = (Unit)space.getOccupier();
				occupier.setRemainingHealth(occupier.getRemainingHealth() - inflictedDamage(occupier));
			}
		});
		
		return true;
	}
	
	private boolean outOfRange(Position position) {
		int distanceToExecution = GridUtils.distanceBetween(position, executingUnit.getPosition());
		return !executionRange.contains(distanceToExecution);
	}
	
	private long inflictedDamage(Unit occupier) {
		return Math.max(baseDamage + executingUnit.getAttack() - occupier.getDefence(), MINIMUM_DAMAGE);
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
	
	public boolean isTurnEnding() {
		return true;
	}
	
	public Class getNextActionInterfaceType() {
		return AttackPlacement.class;
	}

	@Override
	public Class getPrecedingActionInterfaceType() {
		return PostMoveDecisionMenu.class;
	}

	@Override
	public void execute() {
		executeAt(spaceToExecuteAt);
	}
}
