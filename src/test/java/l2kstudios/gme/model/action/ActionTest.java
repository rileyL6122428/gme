package l2kstudios.gme.model.action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.Cross;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.testutils.SpacesFactory;

public class ActionTest {
	
	private Action nullSettingAction;
	private Unit executingUnit;
	private PlayingGrid playingGrid;
	
	
	@Before
	public void setup() {
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyPlayingGridSpaces(3, 3));
		playingGrid.forEachSpace((space) -> space.setOccupier(new Unit()));
		
		executingUnit = new Unit();
		
		nullSettingAction = newNullSettingAction();
		nullSettingAction.setExecutingUnit(executingUnit);
		nullSettingAction.setRangeOfEffect(new Cross(1));
		nullSettingAction.setPlayingGrid(playingGrid);
	}
	
	@Test
	public void execute_affectSpaceSetsOccupierToNull_callSetsOccupierOfAllSpacesInRangeToNull() {
		nullSettingAction.setSpaceToExecuteAt(playingGrid.getSpaceAt(1, 1));
		nullSettingAction.execute();
		
		assertNull(playingGrid.getUnitAt(0, 1));
		assertNull(playingGrid.getUnitAt(1, 0));
		assertNull(playingGrid.getUnitAt(1, 1));
		assertNull(playingGrid.getUnitAt(2, 1));
		assertNull(playingGrid.getUnitAt(1, 2));
		
		assertNotNull(playingGrid.getUnitAt(0,0));
		assertNotNull(playingGrid.getUnitAt(0,2));
		assertNotNull(playingGrid.getUnitAt(2,0));
		assertNotNull(playingGrid.getUnitAt(2,2));
	}

	@Test
	public void ableToExecuteAt_targetSpaceInExecutionRange_returnsTrue() {
		nullSettingAction.setSpaceToExecuteFrom(playingGrid.getSpaceAt(0, 0));
		nullSettingAction.setExecutionRange(Range.closed(0, 1));
		
		assertTrue(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(0,0)));
		assertTrue(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(1,0)));
		assertTrue(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(0,1)));
	}
	
	@Test
	public void ableToExecuteAt_targetSpaceOutsideExecutionRange_returnsFalse() {
		nullSettingAction.setSpaceToExecuteFrom(playingGrid.getSpaceAt(0, 0));
		nullSettingAction.setExecutionRange(Range.closed(0, 1));
		
		assertFalse(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(1,1)));
		assertFalse(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(2,0)));
		assertFalse(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(0,2)));
		assertFalse(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(1,2)));
		assertFalse(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(2,1)));
		assertFalse(nullSettingAction.ableToExecuteAt(playingGrid.getSpaceAt(2,2)));
	}
	
	@Test
	public void targetSpaceSpecified_targetSpaceNull_returnsFalse() {
		nullSettingAction.setSpaceToExecuteAt(null);
		assertFalse(nullSettingAction.targetSpaceSpecified());
	}
	
	@Test
	public void targetSpaceSpecified_targetNotNull_returnsTrue() {
		nullSettingAction.setSpaceToExecuteAt(playingGrid.getSpaceAt(0, 0));
		assertTrue(nullSettingAction.targetSpaceSpecified());
	}
	
	private Action newNullSettingAction() {
		return new Action() {
			
			protected void affectSpace(Space space) {
				space.setOccupier(null);
			}
			
		};
	}

}
