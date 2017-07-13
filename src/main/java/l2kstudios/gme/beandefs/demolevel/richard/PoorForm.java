package l2kstudios.gme.beandefs.demolevel.richard;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class PoorForm extends RapierAssaultArtes {

	@Override
	protected void affectSpace(Space space) {
		if(!(space.isOccupied() && space.getOccupier() instanceof Unit)) return;
		
		Unit unit = (Unit)space.getOccupier();
		unit.decreaseStat(HEALTH, 1);
	}

}