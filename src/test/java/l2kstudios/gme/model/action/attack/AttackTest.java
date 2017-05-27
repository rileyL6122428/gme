package l2kstudios.gme.model.action.attack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.Cross;
import l2kstudios.gme.model.action.rangeofeffect.SingleSpace;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;
import l2kstudios.gme.testutils.SpacesFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GameModelService.class)
public class AttackTest {
	
	private static int ATTACKED_UNIT_STARTING_HEALTH = 20;
	private static int ATTACKED_UNIT_DEFENSE = 1;
	private static int ATTACKING_UNIT_OFFENSE = 1;
	private static int BASE_DAMAGE = 2;
	private static int MINIMUM_DAMAGE = 1;
	
	private Unit executingUnit;
	private PlayingGrid playingGrid;
	private Attack attack;
	
	@Before
	public void setup() {
		executingUnit = new Unit();
		
		attack = new Attack(executingUnit){{
			baseDamage = BASE_DAMAGE;
			executionRange = Range.closed(2, 3);
			rangeOfEffect = new SingleSpace();
		}};
		
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyGridSpaces(8, 8));
		playingGrid.place(executingUnit, 3, 3);
		
		PowerMockito.mockStatic(GameModelService.class);
		Mockito.when(GameModelService.getCurrentPlayingGrid()).thenReturn(playingGrid);
	}
	
	
	@Test
	public void executeAt_suppliedPositionOutOfExecutionRange_returnsFalse() {
		List<Position> outOfExecutionRange = new ArrayList<Position>(){{
			add(new Position(0, 0));
			add(new Position(3, 2));
		}};
		
		outOfExecutionRange.forEach((position) -> {
			assertFalse(attack.executeAt(position));
		});
	}
	
	@Test
	public void executeAt_suppliedPositionInExecutionRange_returnsTrue() {
		List<Position> inExecutionRange = new ArrayList<Position>() {{
			add(new Position(2, 2));
			add(new Position(1, 2));
		}};
		
		inExecutionRange.forEach((position) -> {
			assertTrue(attack.executeAt(position));
		});
	}
	
	@Test
	public void executeAt_suppliedPositionInExecutionRange_executingUnitEndsTurn() {
		Unit willReceiveDamage = newUnitWithHealthSetTo(ATTACKED_UNIT_STARTING_HEALTH);
		playingGrid.place(willReceiveDamage, 2, 2);
		
		attack.executeAt(new Position(2,2));
		assertTrue(executingUnit.turnIsOver());
	}
	
	@Test
	public void executeAt_suppliedPositionInExecutionRange_inflictsDamageOnUnitsInRangeOfEffect() {
		Unit willReceiveDamage = newUnitWithHealthSetTo(ATTACKED_UNIT_STARTING_HEALTH);
		playingGrid.place(willReceiveDamage, 2, 2);
		
		attack.executeAt(new Position(2,2));
		
		assertEquals(expectedRemainingHealth(), willReceiveDamage.getRemainingHealth());
	}
	
	@Test
	public void executeAt_suppliedPositionInExecutionRangeAndMultipleUnitsInRangeOfEffect_inflictsDamageOnUnitsInRangeOfEffect() {
		Unit willReceiveDamage1 = newUnitWithHealthSetTo(ATTACKED_UNIT_STARTING_HEALTH);
		playingGrid.place(willReceiveDamage1, 2, 2);
		
		Unit willReceiveDamage2 = newUnitWithHealthSetTo(ATTACKED_UNIT_STARTING_HEALTH);
		playingGrid.place(willReceiveDamage2, 2, 3);
		
		attack.setRangeOfEffect(new Cross(1));
		
		attack.executeAt(new Position(2, 2));
		assertEquals(expectedRemainingHealth(), willReceiveDamage1.getRemainingHealth());
		assertEquals(expectedRemainingHealth(), willReceiveDamage2.getRemainingHealth());
	}
	
	private Unit newUnitWithHealthSetTo(int healthVal) {
		return new Unit(){{
			setHealth(new ConsummableStat(){{
				setCap(healthVal);
				setVal(healthVal);
			}});
		}};
	}
	
	private int expectedRemainingHealth() {
		return ATTACKED_UNIT_STARTING_HEALTH - Math.max(BASE_DAMAGE + ATTACKING_UNIT_OFFENSE - ATTACKED_UNIT_DEFENSE, MINIMUM_DAMAGE);
	}
}
