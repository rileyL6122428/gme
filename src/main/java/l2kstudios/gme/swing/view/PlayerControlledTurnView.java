package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.actioninterface.ActionPlacementInterface;
import l2kstudios.gme.model.turn.PlayerControlledTurn;

public class PlayerControlledTurnView {
	
	private PlayerControlledTurn turn;
	private ActionInterfaceView actionInterfaceView;
	private ActionInterface currentActionInterface;
	
	public void draw(Graphics drawingCtx) {
		if(currentActionInterface != getTurn().getCurrentActionInterface()) {
			currentActionInterface = getTurn().getCurrentActionInterface();
			setCurrentActionInterfaceView();
		}
		
		actionInterfaceView.draw(drawingCtx);
	}

	private void setCurrentActionInterfaceView() {
		ActionInterface actionInterface = getTurn().getCurrentActionInterface();
		
		if(actionInterface instanceof ActionPlacementInterface) {
			actionInterfaceView = new ActionPlacementView(){{
				setActionInterface((ActionPlacementInterface) actionInterface);
			}};
		}
	}

	public PlayerControlledTurn getTurn() {
		return turn;
	}

	public void setTurn(PlayerControlledTurn turn) {
		this.turn = turn;
	}
}
