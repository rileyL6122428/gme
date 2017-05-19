package l2kstudios.gme.model.action.attack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;
import l2kstudios.gme.testutils.SpacesFactory;

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
			executionRange = Range.closed(2, 3);
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
	
//	@Ignore
	@Test
	public void executeAt_suppliedPositionInExecutionRange_returnsTrue() {
		assertTrue(attack.executeAt(new Position(2, 2)));
		assertTrue(attack.executeAt(new Position(1, 2)));
	}
	
	@Ignore
	@Test
	public void executeAt_suppliedPositionInExecutionRange_inflictsDamageOnUnitsInRangeOfAffect() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void executeAt_suppliedPositionInExecutionRangeAndMultipleUnitsInRangeOfEffect_inflictsDamageOnUnitsInRangeOfAffect() {
		fail("Not yet implemented");
	}
}
