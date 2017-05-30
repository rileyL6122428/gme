package l2kstudios.gme.model.action.postmove.attack;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;

public class BasicAttack extends Attack {

	{
		executionRange = Range.closed(1, 1);
		baseDamage = 1;
		setRangeOfEffect(new SingleSpace());
	}
	
}
