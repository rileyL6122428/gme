package l2kstudios.gme.model.action.attack;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.unit.Unit;

public class BasicAttackWithRange extends Attack {
	{
		name = "Basic Attack With Range";
		
		executionRange = Range.closed(2, 3);
		
		rangeOfEffect = new SingleSpace();
		
		baseDamage = 1;
	}
	
	public BasicAttackWithRange(Unit executingUnit) {
		super(executingUnit);
	}
}
