package l2kstudios.gme.swing.gameinterface;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.Phase;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence;

public class TurnFactory {
	
	public static Turn newTurn(Level level) {
		Turn turn = new Turn();
		
		turn.setActingUnit(level.getActingUnit());
		turn.setPlayingGrid(level.getPlayingGrid());
		
		turn.setPhaseSequence(new TurnPhaseSequence(){{
			add(newMovePhase(turn));			
		}});
		
		return turn;
	}
	
	private static Phase newMovePhase(Turn turn) {
		
		MovePlacementInterface movePlacementInterface = new MovePlacementInterface();
		movePlacementInterface.setTurn(turn);
		movePlacementInterface.afterPropertiesSet();
		
		return new Phase(){{
			setPhaseInterface(movePlacementInterface);
		}};
	}
	
}
