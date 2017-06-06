package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public class TurnFactory {
	
	public static Turn newTurn(Unit actingUnit, PlayingGrid playingGrid) {
		return new Turn(){{
			setPlayingGrid(playingGrid);
			setActingUnit(actingUnit);
			afterPropertiesSet();
		}};
	}
}
