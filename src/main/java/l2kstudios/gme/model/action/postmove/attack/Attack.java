package l2kstudios.gme.model.action.postmove.attack;

import l2kstudios.gme.model.action.postmove.PostMoveAction;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class Attack extends PostMoveAction {
	
	private static int MINIMUM_DAMAGE = 1;
	
	private int baseDamage;

	@Override
	protected void affectSpace(Space space) {
		if(!(space.getOccupier() instanceof Unit)) return;
		
		Unit unit = (Unit)space.getOccupier(); 
		unit.setRemainingHealth(unit.getRemainingHealth() - inflictedDamage(unit));
	}

	private long inflictedDamage(Unit occupier) {
		return Math.max(getBaseDamage() + getExecutingUnit().getStrength() - occupier.getDefense(), MINIMUM_DAMAGE);
	}

	public int getBaseDamage() {
		return baseDamage;
	}
	
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
}
