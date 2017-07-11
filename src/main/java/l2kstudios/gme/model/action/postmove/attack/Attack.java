package l2kstudios.gme.model.action.postmove.attack;

import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class Attack extends PostMoveAction {
	
	private static int MINIMUM_DAMAGE = 1;
	
	private int baseDamage;

	@Override
	protected void affectSpace(Space space) {
		if(!(space.getOccupier() instanceof Unit)) return;
		
		Unit unit = (Unit)space.getOccupier(); 
		unit.decreaseStat(HEALTH, inflictedDamage(unit));
	}

	private long inflictedDamage(Unit occupier) {
		return Math.max(getBaseDamage() + executingUnit.get(STRENGTH) - occupier.get(PHYSICAL_DEFENSE), MINIMUM_DAMAGE);
	}

	public int getBaseDamage() {
		return baseDamage;
	}
	
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
}
