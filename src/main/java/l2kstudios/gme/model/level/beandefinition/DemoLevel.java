package l2kstudios.gme.model.level.beandefinition;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.beandefinition.DemoPlayingGrid;
import l2kstudios.gme.model.level.factory.InputDispatcher;
import l2kstudios.gme.model.level.factory.Level;
import l2kstudios.gme.model.movement.MovementCycle;

public class DemoLevel extends Level {
	{
		setPlayingGrid(new DemoPlayingGrid());
		MovementCycle movementCycle = new MovementCycle(getPlayingGrid().getUnits()); 
		actingUnitTracker = new ActingUnitTracker(movementCycle);
		getPlayingGrid().setActingUnitTracker(actingUnitTracker);
		getPlayingGrid().afterPropertiesSet();
		
		setActionMenu(new ActionMenu());
		getActionMenu().setActingUnitTracker(actingUnitTracker);
		
		setInputDispatcher(new InputDispatcher());
		getInputDispatcher().setActionMenu(getActionMenu());
		getInputDispatcher().setPlayingGrid(getPlayingGrid());
		getInputDispatcher().afterPropertiesSet();
	}
}
