package l2kstudios.gme.beandefs.demolevel.asbel;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.RelativeLine;

public class DemonFang extends DrawnSwordArtes {

	{
		executionRange = Range.closed(1, 1);
		rangeOfEffect = new RelativeLine(4);
		setBaseDamage(1);
	}

}
