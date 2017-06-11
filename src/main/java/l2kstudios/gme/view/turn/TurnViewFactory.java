package l2kstudios.gme.view.turn;

import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.view.View;
import processing.core.PApplet;

public class TurnViewFactory {
	
	private PApplet ctx;
	
	public View newTurnView(Turn turn) {
		if(turn instanceof PlayerControlledTurn) 
			return newPlayerControlledTurnView(turn);
		
		return null;
	}
	
	private PlayerControlledTurnView newPlayerControlledTurnView(Turn turn) {
		PlayerControlledTurnView turnView = new PlayerControlledTurnView();
		
		turnView.setModel((PlayerControlledTurn) turn);
		turnView.setDrawingContext(ctx);
		turnView.afterPropertiesSet();
		
		return turnView;
	}

	public PApplet getDrawingContex() {
		return ctx;
	}

	public void setDrawingContext(PApplet ctx) {
		this.ctx = ctx;
	} 

}
