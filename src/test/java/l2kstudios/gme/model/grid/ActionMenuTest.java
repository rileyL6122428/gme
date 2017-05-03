package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenuTest {	
	
	private List<Action> actingUnitActions;
	private Unit actingUnit;
	private ActingUnitTracker actingUnitTracker;
	private ActionMenu actionMenu;
	
	@Before
	public void setup() {
		actingUnitActions = new ArrayList<Action>() {{
			add(mock(Action.class));
			add(mock(Action.class));
			add(mock(Action.class));
		}};
		
		actingUnit = mock(Unit.class);
		when(actingUnit.getActions()).thenReturn(actingUnitActions);

		actingUnitTracker = mock(ActingUnitTracker.class);
		when(actingUnitTracker.getActingUnit()).thenReturn(actingUnit);
		
		actionMenu = new ActionMenu(actingUnitTracker);
	}
	
	@Test
	public void getSelectableActions__returnsTheSetOfActionsExecutableByTheUnit() {
		when(actingUnitActions.get(0).ableToExecute()).thenReturn(true);
		when(actingUnitActions.get(1).ableToExecute()).thenReturn(false);
		when(actingUnitActions.get(2).ableToExecute()).thenReturn(true);
		
		actionMenu.initialize();
		
		List<Action> selectableActions = actionMenu.getSelectableActions();
		
		assertEquals(2, selectableActions.size());
		assertEquals(actingUnitActions.get(0), selectableActions.get(0));
		assertEquals(actingUnitActions.get(2), selectableActions.get(1));
	}
	
	
	
	@Test
	public void shouldDraw_afterInitializationCall_returnsTrue() {
		actionMenu.initialize();
		assertTrue(actionMenu.getShouldDraw());
	}
	
	@Test
	public void shouldDraw_afterSelection_returnsFalse() {
		when(actingUnitActions.get(0).ableToExecute()).thenReturn(true);
		when(actingUnitActions.get(1).ableToExecute()).thenReturn(true);
		when(actingUnitActions.get(2).ableToExecute()).thenReturn(true);
		
		actionMenu.initialize();
		actionMenu.select();
		assertFalse(actionMenu.getShouldDraw());
	}
}
