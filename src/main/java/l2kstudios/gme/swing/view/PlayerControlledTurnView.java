package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.swing.gameinterface.ActionInstanceMenu;
import l2kstudios.gme.swing.gameinterface.ActionInterface;
import l2kstudios.gme.swing.gameinterface.ActionPlacementInterface;
import l2kstudios.gme.swing.gameinterface.PostMoveDecisionMenu;

public class PlayerControlledTurnView extends CurrentTurnView {
	
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
		} else if(actionInterface instanceof PostMoveDecisionMenu) {
			actionInterfaceView = new PostMoveDecisionMenuView(){{
				setActionInterface((PostMoveDecisionMenu) actionInterface);
			}};
		} else if(actionInterface instanceof ActionInstanceMenu) {
			actionInterfaceView = new ActionInstanceMenuView(){{
				setActionInterface((ActionInstanceMenu) actionInterface);
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
