package l2kstudios.gme.model.action.postmove.attack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Stat;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.model.unit.Unit.StatType;

import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class AttackTest {
	
	private Attack attack;
	
	private Unit attackingUnit;
	private Unit attackedUnit;
	
	private Space spaceAffectedByAttack;
	
	@Before
	public void setup() {
		attack = new Attack();
		
		attackingUnit = new Unit();
		attack.setRangeOfEffect(new SingleSpace());
		attack.setExecutingUnit(attackingUnit);
		
		spaceAffectedByAttack = new Space();
		
		attackedUnit = new Unit();
		setStatVal(attackedUnit, HEALTH, 20);
		attackedUnit.place(spaceAffectedByAttack);
	}
	
	@Test
	public void affectSpace_unitInSuppliedSpace_attackedUnitsHealthReducedByDefMinusOffenseMinusBase() {
		attackedUnit.setStat(PHYSICAL_DEFENSE, new Stat(){{
			setMaxCap(2);
			setCap(2);
			setVal(2);
		}});
		
		attackingUnit.setStat(STRENGTH, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		attack.setBaseDamage(4);
		
		attack.affectSpace(spaceAffectedByAttack);
		
		assertEquals(15, attackedUnit.get(HEALTH));
	}
	
	@Test
	public void affectSpace_unitInSuppliedPositionHasHighDefense_minimumDamageIsOne() {
		setStatVal(attackedUnit, PHYSICAL_DEFENSE, 10);
		setStatVal(attackingUnit, STRENGTH, 1);
		attack.setBaseDamage(1);
		
		attack.affectSpace(spaceAffectedByAttack);
		
		assertEquals(19, attackedUnit.get(HEALTH));
	}
	
	
	
	private void setStatVal(Unit unit, StatType statType, long val) {
		unit.setStat(statType, new Stat(){{
			setMaxCap(val);
			setCap(val);
			setVal(val);
		}});
	}
	
}
