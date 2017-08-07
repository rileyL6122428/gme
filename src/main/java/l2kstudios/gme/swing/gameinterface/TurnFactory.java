package l2kstudios.gme.swing.gameinterface;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.Phase;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence;
import l2kstudios.gme.swing.gameinterface.moveplacement.MovePlacementInterface;

public class TurnFactory {
	
	public static Turn newTurn(Level level) {
		Turn turn = new Turn();
		
		turn.setActingUnit(level.getActingUnit());
		turn.setPlayingGrid(level.getPlayingGrid());
		
		turn.setPhaseSequence(new TurnPhaseSequence(){{
			add(newMovePhase(turn));	
			add(newSelectActionTypePhase(turn));
			add(newSelecActionInstancePhase(turn));
		}});
		
		return turn;
	}
	
	private static Phase newMovePhase(Turn turn) {
		
		MovePlacementInterface movePlacementInterface = new MovePlacementInterface();
		movePlacementInterface.setTurn(turn);
//		movePlacementInterface.afterPropertiesSet();
		
		return new Phase(){{
			setPhaseInterface(movePlacementInterface);
		}};
	}
	
	private static Phase newSelectActionTypePhase(Turn turn) {
		PostMoveDecisionMenu menu = new PostMoveDecisionMenu();
		menu.setTurn(turn);
		menu.setActingUnit(turn.getActingUnit());
//		menu.afterPropertiesSet();
		
		return new Phase(){{
			setPhaseInterface(menu);
		}};
	}
	
	private static Phase newSelecActionInstancePhase(Turn turn) {
		ActionInstanceMenu menu = new ActionInstanceMenu();
		menu.setTurn(turn);
		
		return new Phase(){{
			setPhaseInterface(menu);
		}};
	}
	
}
