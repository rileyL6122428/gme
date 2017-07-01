package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.ComputerControlledTurn;
import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.swing.view.ComputerControlledTurnView;

public class TurnView {
	
	private Level level;
	private Turn currentTurn;
	private CurrentTurnView currentTurnView;
	
	public void draw(Graphics drawingCtx) {
		if(level.turnIsOver(currentTurn)) {
			setupNewCurrentTurnView();			
		}
		
		currentTurnView.draw(drawingCtx);
	}

	private void setupNewCurrentTurnView() {
		currentTurn = level.getCurrentTurn();
		
		if(currentTurn instanceof PlayerControlledTurn) {
			currentTurnView = new PlayerControlledTurnView(){{ 
				setTurn((PlayerControlledTurn) currentTurn); 
			}};
		} else if(currentTurn instanceof ComputerControlledTurn) {
			currentTurnView = new ComputerControlledTurnView();
		}
			
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	
	
}
