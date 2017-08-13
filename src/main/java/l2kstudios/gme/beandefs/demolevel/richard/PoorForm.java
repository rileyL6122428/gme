package l2kstudios.gme.beandefs.demolevel.richard;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

import static l2kstudios.gme.model.unit.Unit.StatType.*;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;

public class PoorForm extends RapierAssaultArtes {
	
	{
		executionRange = Range.closed(1, 1);
		rangeOfEffect = new SingleSpace();
	}

	@Override
	protected void affectSpace(Space space) {
		if(!(space.isOccupied() && space.getOccupier() instanceof Unit)) return;
		
		Unit unit = (Unit)space.getOccupier();
		unit.decreaseStat(HEALTH, 1);
	}

}
