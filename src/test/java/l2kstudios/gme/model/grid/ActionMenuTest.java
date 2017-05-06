package l2kstudios.gme.model.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
			add(new DummyAction(true));
			add(new DummyAction(false));
			add(new DummyAction(true));
			add(new DummyAction(true));
		}};
		
		actingUnit = mock(Unit.class);
		when(actingUnit.getActions()).thenReturn(actingUnitActions);

		actingUnitTracker = mock(ActingUnitTracker.class);
		when(actingUnitTracker.getActingUnit()).thenReturn(actingUnit);
		
		actionMenu = new ActionMenu(actingUnitTracker);
	}
	
	
	@Test
	public void shouldDraw_beforeInitialization_returnsFalse() {
		assertFalse(actionMenu.getShouldDraw());
	}
	
	@Test
	public void shouldDraw_afterInitializationCall_returnsTrue() {
		actionMenu.initialize();
		assertTrue(actionMenu.getShouldDraw());
	}
	
	@Test
	public void getSelectableActions__returnsTheSetOfActionsExecutableByTheUnit() {
		actionMenu.initialize();
		
		List<Action> selectableActions = actionMenu.getSelectableActions();
		
		assertEquals(3, selectableActions.size());
		assertEquals(actingUnitActions.get(0), selectableActions.get(0));
		assertEquals(actingUnitActions.get(2), selectableActions.get(1));
		assertEquals(actingUnitActions.get(3), selectableActions.get(2));
	}
	
	@Test
	public void select__setsShouldDrawToFalse() {
		actionMenu.initialize();
		actionMenu.select();
		assertFalse(actionMenu.getShouldDraw());
	}
	
	@Test
	public void select__executesTheHoveredAction() {		
		actionMenu.initialize();
		actionMenu.select();
		assertEquals(1, ((DummyAction)actingUnitActions.get(0)).getCallCount());
		assertEquals(0, ((DummyAction)actingUnitActions.get(2)).getCallCount());
		assertEquals(0, ((DummyAction)actingUnitActions.get(3)).getCallCount());
		
		actionMenu.initialize();
		actionMenu.moveCursorRight();
		actionMenu.select();
		assertEquals(1, ((DummyAction)actingUnitActions.get(0)).getCallCount());
		assertEquals(1, ((DummyAction)actingUnitActions.get(2)).getCallCount());
		assertEquals(0, ((DummyAction)actingUnitActions.get(3)).getCallCount());
	}
	
	static class DummyAction extends Action {
		private int callCount = 0;
		private boolean ableToExecute;
		
		public DummyAction(boolean ableToExecute) {
			this.ableToExecute = ableToExecute;
		}
		
		public boolean ableToExecute() {
			return ableToExecute;
		}
		
		public void execute() {
			callCount++;
		}
		
		public int getCallCount() {
			return callCount;
		}
	}
	
}
