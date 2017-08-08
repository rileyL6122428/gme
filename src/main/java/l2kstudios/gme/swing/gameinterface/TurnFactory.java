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
			add(newMovePlacementPhase(turn));	
			add(newSelectActionTypePhase(turn));
			add(newSelecActionInstancePhase(turn));
			add(newPostMoveActionPlacementPhase(turn));
		}});
		
		return turn;
	}
	
	private static Phase newMovePlacementPhase(Turn turn) {
		MovePlacementInterface movePlacementInterface = new MovePlacementInterface();
		movePlacementInterface.setTurn(turn);
		
		return new Phase(){{
			setPhaseInterface(movePlacementInterface);
		}};
	}
	
	private static Phase newSelectActionTypePhase(Turn turn) {
		PostMoveDecisionMenu menu = new PostMoveDecisionMenu();
		menu.setTurn(turn);
		menu.setActingUnit(turn.getActingUnit());
		
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
	
	private static Phase newPostMoveActionPlacementPhase(Turn turn) {
		PostMoveActionPlacementInterface placementInterface = new PostMoveActionPlacementInterface();
		placementInterface.setTurn(turn);
		
		return new Phase(){{
			setPhaseInterface(placementInterface);
		}};
	}
	
}
