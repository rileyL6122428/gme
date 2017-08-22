package l2kstudios.gme.beandefs.demo.sophie;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;

public class TripleStrike extends MartialAssaultArtes {
	
	{
		executionRange = Range.closed(1, 1);
		rangeOfEffect = new SingleSpace();
		setBaseDamage(1);
	}
	
}
