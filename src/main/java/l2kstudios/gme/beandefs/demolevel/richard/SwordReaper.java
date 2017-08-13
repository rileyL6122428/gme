package l2kstudios.gme.beandefs.demolevel.richard;

import static l2kstudios.gme.model.unit.Unit.StatType.HEALTH;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class SwordReaper extends CoercionBurstArtes {
	
	{
		executionRange = Range.closed(1, 4);
		rangeOfEffect = new SingleSpace();
	}

	@Override
	protected void affectSpace(Space space) {
		if(!(space.isOccupied() && space.getOccupier() instanceof Unit)) return;
		
		Unit unit = (Unit)space.getOccupier();
		if(unit.getTeam() != executingUnit.getTeam()) {
			unit.decreaseStat(HEALTH, 1);
			executingUnit.increaseStat(HEALTH, 1);
		}
	}

}
