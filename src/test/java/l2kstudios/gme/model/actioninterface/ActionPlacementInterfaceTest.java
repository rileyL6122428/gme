package l2kstudios.gme.model.actioninterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.testutils.SpacesFactory;

public class ActionPlacementInterfaceTest {

	private ActionPlacementInterface actionPlacementInterface;
	
	private PlayerControlledTurn turn;
	private PlayingGrid playingGrid;
	private Action action;
	
	@Before
	public void setup() {
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyPlayingGridSpaces(12, 12));
		
		action = mock(Action.class);
		
		turn = mock(PlayerControlledTurn.class);
		when(turn.getPlayingGrid()).thenReturn(playingGrid);
		when(turn.getPlacingAction()).thenReturn(action);
		
		actionPlacementInterface = new ActionPlacementInterface();
	}
	
	@Test
	public void initialize__movesCursorToSpaceToExecuteFrom() {
		when(action.getSpaceToExecuteFrom()).thenReturn(playingGrid.getSpaceAt(2, 3));
		
		actionPlacementInterface.initialize(turn);
		Position cursorPosition = actionPlacementInterface.getCursorPosition();
		
		assertEquals(2, cursorPosition.getX());
		assertEquals(3, cursorPosition.getY());
	}
	
	@Test
	public void select__returnsTrueIfTheCursorPositionIsExecuteable() {
		when(action.getSpaceToExecuteFrom()).thenReturn(playingGrid.getSpaceAt(2, 3));
		
		setActionAbleToExecuteAt(4, 3);
		
		actionPlacementInterface.initialize(turn);
		actionPlacementInterface.moveCursorRight();
		actionPlacementInterface.moveCursorRight();
		
		assertTrue(actionPlacementInterface.select());
	}
	
	@Test
	public void select__setsTheActionExecutionSpaceIfTheCursorPositionIsExecuteable() {
		when(action.getSpaceToExecuteFrom()).thenReturn(playingGrid.getSpaceAt(2, 3));
		
		setActionAbleToExecuteAt(4, 3);
		
		actionPlacementInterface.initialize(turn);
		actionPlacementInterface.moveCursorRight();
		actionPlacementInterface.moveCursorRight();
		
		actionPlacementInterface.select();
		Mockito.verify(action).setSpaceToExecuteAt(playingGrid.getSpaceAt(4, 3));
	}
	
	@Test
	public void select__returnsFalseIfTheCursorPositionIsNotExecuteable() {
		when(action.getSpaceToExecuteFrom()).thenReturn(playingGrid.getSpaceAt(2, 3));
		
		setActionAbleToExecuteAt(4, 3);
		
		actionPlacementInterface.initialize(turn);
		actionPlacementInterface.moveCursorLeft();
		
		assertFalse(actionPlacementInterface.select());
	}

	private void setActionAbleToExecuteAt(int x, int y) {
		playingGrid.forEachSpace((space) -> {
			if(space.hasCoordinates(x, y))
				when(action.ableToExecuteAt(space)).thenReturn(true);
			else
				when(action.ableToExecuteAt(space)).thenReturn(false);
		}); 
	}

}
