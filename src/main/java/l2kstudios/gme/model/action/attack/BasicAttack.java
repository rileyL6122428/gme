package l2kstudios.gme.model.action.attack;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.unit.Unit;

public class BasicAttack extends Attack {
	
	{
		name = "Basic Attack";
		
		executionRange = Range.closed(1, 1);
		
		rangeOfEffect = new SingleSpace();
		
		baseDamage = 1;
	}
	
	public BasicAttack(Unit executingUnit) {
		super(executingUnit);
	}
	
}
