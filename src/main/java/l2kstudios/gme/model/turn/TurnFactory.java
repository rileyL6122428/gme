package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.ComputerControllableUnit;
import l2kstudios.gme.model.unit.Unit;

public class TurnFactory {
	
	public static Turn newTurn(Unit actingUnit, PlayingGrid playingGrid) {
		if(actingUnit.getTeam() == Unit.Team.ENEMY) {
			return new ComputerControlledTurn() {{
				setPlayingGrid(playingGrid);
				setActingUnit((ComputerControllableUnit) actingUnit);
				afterPropertiesSet();
			}};
		} else {
			return new PlayerControlledTurn(){{
				setPlayingGrid(playingGrid);
				setActingUnit(actingUnit);
				afterPropertiesSet();
			}};			
		}
		
	}
}
