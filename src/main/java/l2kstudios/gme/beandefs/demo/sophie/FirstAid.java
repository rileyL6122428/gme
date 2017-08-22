package l2kstudios.gme.beandefs.demo.sophie;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.Cross;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

import static l2kstudios.gme.model.unit.Unit.StatType.*; 

public class FirstAid extends RegenerativeBurstArtes {
	
	{
		executionRange = Range.closed(0, 0);
		rangeOfEffect = new Cross(1);
	}

	@Override
	protected void affectSpace(Space space) {
		if(!(space.isOccupied() && space.getOccupier() instanceof Unit)) return;
		
		Unit unit = (Unit)space.getOccupier();
		unit.increaseStat(HEALTH, 1);
	}

}
