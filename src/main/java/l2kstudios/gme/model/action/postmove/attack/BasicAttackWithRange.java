package l2kstudios.gme.model.action.postmove.attack;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.Cross;
import l2kstudios.gme.model.unit.Unit;

public class BasicAttackWithRange extends Attack {
	
	{		
		executionRange = Range.closed(2, 3);	
		rangeOfEffect = new Cross(1);
		setBaseDamage(1);
	}
	
}
