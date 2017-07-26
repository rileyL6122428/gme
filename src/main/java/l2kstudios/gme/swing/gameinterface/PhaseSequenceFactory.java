package l2kstudios.gme.swing.gameinterface;

import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence;
import l2kstudios.gme.model.turn.Phase;

public class PhaseSequenceFactory {
	
	public static TurnPhaseSequence PhaseSequence(Turn turn) {
		return new TurnPhaseSequence() {{
			add(newMovementPhase(turn));
		}};
	}
	
	private static Phase newMovementPhase(Turn turn) {
		return new Phase(){{
			setPhaseInterface(new MovePlacementInterface() {{
				setTurn(turn);
				afterPropertiesSet();
			}});
		}};
	}
	
}
