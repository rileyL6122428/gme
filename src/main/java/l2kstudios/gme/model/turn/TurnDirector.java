package l2kstudios.gme.model.turn;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.swing.view.View;

public interface TurnDirector extends View {
	
	public PhaseProgressionFlag receiveInput(Input input);
	
}
