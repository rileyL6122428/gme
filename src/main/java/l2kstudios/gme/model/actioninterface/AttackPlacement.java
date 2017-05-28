package l2kstudios.gme.model.actioninterface;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.unit.Unit;

public class AttackPlacement extends PlayingGridOverlayInterface {
		
	private Attack attack;
	
	public AttackPlacement(Attack attack) {
		this.attack = attack;
	}
	
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
		return false;
	}
	
	public void initialize() {
		Unit actingUnit = attack.getExecutingUnit();
		moveCursorTo(actingUnit.getPosition());
	}

	public Range<Integer> getExectuionRange() {
		return attack.getExecutionRange();
	}
	
	public RangeOfEffect getRangeOfEffect() {
		return attack.getRangeOfEffect();
	}
}
