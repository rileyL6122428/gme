package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.level.Level;

public class TurnFactory {
	
	public static Turn newTurn(Level level) {
		return new Turn(){{
			setActingUnitTracker(level.getActingUnitTracker());
			setActionMenu(level.getActionMenu());
			setAttackOptions(level.getAttackOptions());
			setAttackPlacement(level.getAttackPlacement());
			setPlayingGrid(level.getPlayingGrid());
			
			selectedGrid = level.getPlayingGrid();
			selectedGrid.initialize();
		}};
	}
}
