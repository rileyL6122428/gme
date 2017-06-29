package l2kstudios.gme.view.turn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import l2kstudios.gme.model.actioninterface.ActionInstanceMenu;
import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.actioninterface.ActionPlacementInterface;
import l2kstudios.gme.model.actioninterface.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.view.MoveOrderView;
import l2kstudios.gme.view.PlayingGridView;
import l2kstudios.gme.view.View;
import l2kstudios.gme.view.actioninterface.ActionInstanceMenuView;
import l2kstudios.gme.view.actioninterface.ActionPlacementView;
import l2kstudios.gme.view.actioninterface.PostMoveDecisionMenuView;
import l2kstudios.gme.view.unit.ActingUnitView;
import l2kstudios.gme.view.unit.UnitView;

public class PlayerControlledTurnView extends View<PlayerControlledTurn> {
	
	private View<ActionInterface> actionInterfaceView;

	public void draw() {
		drawActionInterface();
	}
	
	private void drawActionInterface() {
		if(model.getCurrentActionInterface() != actionInterfaceView.getModel()) {
			setNextActionInterfaceView();			
		} 
		actionInterfaceView.draw();
	}

	private void setNextActionInterfaceView() {
		ActionInterface actionInterface = model.getCurrentActionInterface();
		if(actionInterface instanceof ActionInstanceMenu) {
			actionInterfaceView = new ActionInstanceMenuView();
		} else if(actionInterface instanceof ActionPlacementInterface) {
			actionInterfaceView = new ActionPlacementView();			
		} else if(actionInterface instanceof PostMoveDecisionMenu) {
			actionInterfaceView = new PostMoveDecisionMenuView();
		}
		
		actionInterfaceView.setDrawingContext(ctx);
		actionInterfaceView.setModel(actionInterface);
	}
	
	public void afterPropertiesSet() {
		actionInterfaceView = new ActionPlacementView();
		actionInterfaceView.setModel(model.getCurrentActionInterface());
		actionInterfaceView.setDrawingContext(ctx);
	}

}
