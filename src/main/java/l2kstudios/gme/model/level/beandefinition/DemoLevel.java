package l2kstudios.gme.model.level.beandefinition;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.beandefinition.DemoPlayingGrid;
import l2kstudios.gme.model.level.InputDispatcher;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.movement.MovementCycle;

public class DemoLevel extends Level {
	{
		playingGrid = new DemoPlayingGrid();
		MovementCycle movementCycle = new MovementCycle(playingGrid.getUnits()); 
		ActingUnitTracker actingUnitTracker = new ActingUnitTracker(movementCycle);
		playingGrid.setActingUnitTracker(actingUnitTracker);
		playingGrid.afterPropertiesSet();
		
		actionMenu = new ActionMenu();
		actionMenu.setActingUnitTracker(actingUnitTracker);
		
		inputDispatcher = new InputDispatcher();
		inputDispatcher.setActionMenu(actionMenu);
		inputDispatcher.setPlayingGrid(playingGrid);
		inputDispatcher.afterPropertiesSet();
	}
}
