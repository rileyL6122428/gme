package l2kstudios.gme.view.actioninterface;

import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.view.constants.GridConstants;

public class PostMoveDecisionMenuView extends ActionInterfaceView {
	
	public static int HORIZONTAL_OFFSET = 75;
	
	@Override
	public void draw() {
		drawActionNames();
	}
	
	private void drawActionNames() {
		Position activeUnitPosition = getModel().getActingUnitPosition();
		List<Action> actions = getModel().getDecisions();
		
		for(int actionIdx = 0; actionIdx < actions.size(); actionIdx++) {
			Action action = actions.get(actionIdx);
			
			setFillColorForActionName(action);
			
			ctx.text(
				action.getName(), 
				activeUnitPosition.getX() * GridConstants.SPACE_HEIGHT + HORIZONTAL_OFFSET, 
				activeUnitPosition.getY() * GridConstants.SPACE_WIDTH + actionIdx * 15
			);
		}
	}
	
	private void setFillColorForActionName(Action action) {
		if(model.getCursorPosition() == action.getPosition())
			ctx.fill(0, 255, 255);
		else
			ctx.fill(0);
	}
	
	public PostMoveDecisionMenu getModel() {
		return (PostMoveDecisionMenu) model;
	}
}
