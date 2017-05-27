package l2kstudios.gme.model.grid;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;

public class AttackPlacement extends TwoDimensionalGrid {
		
	private Attack attack;
	private ActingUnitTracker actingUnitTracker;
	
	public void setAttackToPlace(Attack attack) {
		this.attack = attack;
	}
	
	public boolean select() {
		return attack.executeAt(hoveredSpace());
	}
	
	public boolean revert() {
		
		
		return true;
	}
	
	public boolean shouldDraw() {
		return actingUnitTracker.getActingUnit().isPlacingAttack();
	}
	
	public void initialize() {
		Unit actingUnit = actingUnitTracker.getActingUnit();
		moveCursorTo(actingUnit.getPosition());
	}
	
	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}

	public Position getExecutingUnitPosition() {
		return actingUnitTracker.getActingUnit().getPosition();
	}

	public Range<Integer> getExectuionRange() {
		return attack.getExecutionRange();
	}
	
	public RangeOfEffect getRangeOfEffect() {
		return attack.getRangeOfEffect();
	}
}
