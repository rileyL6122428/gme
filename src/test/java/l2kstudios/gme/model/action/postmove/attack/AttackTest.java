package l2kstudios.gme.model.action.postmove.attack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;

@RunWith(PowerMockRunner.class)
public class AttackTest {
	
	private Attack attack;
	
	private Unit attackingUnit;
	private Unit attackedUnit;
	
	private Space spaceAffectedByAttack;
	
	@Before
	public void setup() {
		attack = new Attack();
		
		attackingUnit = new Unit();
		attack.setExecutingUnit(attackingUnit);
		
		spaceAffectedByAttack = new Space();
		
		attackedUnit = newUnitWithHealthSetTo(20);
		attackedUnit.place(spaceAffectedByAttack);
	}
	
	@Test
	public void affectSpace_unitInSuppliedSpace_attackedUnitsHealthReducedByDefMinusOffenseMinusBase() {
		attackedUnit.setDefense(2);
		attackingUnit.setStrength(3);
		attack.setBaseDamage(4);
		
		attack.affectSpace(spaceAffectedByAttack);
		
		assertEquals(15, attackedUnit.getRemainingHealth());
	}
	
	@Test
	public void affectSpace_unitInSuppliedPositionHasHighDefense_minimumDamageIsOne() {
		attackedUnit.setDefense(10);
		attackingUnit.setStrength(1);
		attack.setBaseDamage(1);
		
		attack.affectSpace(spaceAffectedByAttack);
		
		assertEquals(19, attackedUnit.getRemainingHealth());
	}
	
	private Unit newUnitWithHealthSetTo(int healthVal) {
		return new Unit(){{
			setHealth(new ConsummableStat(){{
				setCap(healthVal);
				setVal(healthVal);
			}});
		}};
	}
	
}
