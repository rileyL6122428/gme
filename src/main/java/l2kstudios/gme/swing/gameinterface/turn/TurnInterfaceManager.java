package l2kstudios.gme.swing.gameinterface.turn;

import java.awt.Graphics;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.TurnPhaseSequence;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.swing.view.BoardView;

public class TurnInterfaceManager implements Interface {
	
	private Level level;
	private TurnPhaseSequence currentPhaseSequence;
	private TurnInterfaceBase currentInterface;
	
	private BoardView boardView;

	@Override
	public void draw(Graphics drawingCtx) {
		boardView.draw(drawingCtx);
		currentInterface.draw(drawingCtx);
	}

	@Override
	public void receiveInput(Input input) {
		PhaseProgressionFlag phaseFlag = currentInterface.receiveInput(input);
		currentPhaseSequence.registerFlag(phaseFlag);
		
		if(level.turnIsFinished()) {
			level.commitTurn();
			finishComputerControlledTurns();
			currentPhaseSequence = level.getTurnPhases();
		}
		
		currentInterface = currentPhaseSequence.getPhaseInterface();
	}

	private void finishComputerControlledTurns() {
		while(level.currentTurnIsComputerControlled()) {			
			ComputerPlayer computerPlayer = ComputerPlayerFactory.newComputerPlayer(level);
			computerPlayer.completeTurn();
			level.commitTurn();
		}
	}

	public void setLevel(Level level) {
		this.level = level;
		currentPhaseSequence = level.getTurnPhases();
		currentInterface = currentPhaseSequence.getPhaseInterface();
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}
	
}
