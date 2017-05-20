package l2kstudios.gme.model.action.attack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.Delta;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;
import l2kstudios.gme.testutils.SpacesFactory;
import l2kstudios.gme.model.unit.ConsummableStat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GameModelService.class)
public class AttackTest {
	
	private Unit executingUnit;
	
	private PlayingGrid playingGrid;
	
	private Attack attack;
	
	@Before
	public void setup() {
		executingUnit = new Unit();
		
		attack = new Attack(executingUnit){{
			baseDamage = 2;
			
			executionRange = Range.closed(2, 3);
			
			rangeOfEffect = new ArrayList<Delta>(){{
				add(new Delta(0, 0));
			}};
		}};
		
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyGridSpaces(8, 8));
		playingGrid.place(executingUnit, 3, 3);
		
		PowerMockito.mockStatic(GameModelService.class);
		Mockito.when(GameModelService.getCurrentPlayingGrid()).thenReturn(playingGrid);
	}
	
	
	@Test
	public void executeAt_suppliedPositionOutOfExecutionRange_returnsFalse() {
		assertFalse(attack.executeAt(new Position(0,0)));
		assertFalse(attack.executeAt(new Position(3, 2)));
	}
	
	@Test
	public void executeAt_suppliedPositionInExecutionRange_returnsTrue() {
		assertTrue(attack.executeAt(new Position(2, 2)));
		assertTrue(attack.executeAt(new Position(1, 2)));
	}
	
	@Test
	public void executeAt_suppliedPositionInExecutionRange_inflictsDamageOnUnitsInRangeOfAffect() {
		Unit willReceiveDamage = new Unit(){{
			setHealth(new ConsummableStat(){{
				setCap(20);
				setVal(20);
			}});
		}};
		playingGrid.place(willReceiveDamage, 2, 2);
		
		attack.executeAt(new Position(2,2));
		
		assertEquals(willReceiveDamage.getRemainingHealth(), 18);
	}
	
//	@Ignore
	@Test
	public void executeAt_suppliedPositionInExecutionRangeAndMultipleUnitsInRangeOfEffect_inflictsDamageOnUnitsInRangeOfAffect() {
		Unit willReceiveDamage1 = new Unit(){{
			setHealth(new ConsummableStat(){{
				setCap(20);
				setVal(20);
			}});
		}};
		playingGrid.place(willReceiveDamage1, 2, 2);
		
		Unit willReceiveDamage2 = new Unit(){{
			setHealth(new ConsummableStat(){{
				setCap(20);
				setVal(20);
			}});
		}};
		playingGrid.place(willReceiveDamage2, 2, 3);
		
		attack.rangeOfEffect = new ArrayList<Delta>(){{
			add(new Delta(0, 0));
			add(new Delta(1, 0));
			add(new Delta(-1, 0));
			add(new Delta(0, 1));
			add(new Delta(0, -1));
		}};
		
		
		attack.executeAt(new Position(2, 2));
		assertEquals(willReceiveDamage1.getRemainingHealth(), 18);
		assertEquals(willReceiveDamage2.getRemainingHealth(), 18);
	}
}
