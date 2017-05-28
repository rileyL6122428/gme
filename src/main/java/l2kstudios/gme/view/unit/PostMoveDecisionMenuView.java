package l2kstudios.gme.view.unit;

import static l2kstudios.gme.view.constants.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.view.constants.GridConstants.SPACE_WIDTH;

import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.view.View;

public class PostMoveDecisionMenuView extends View<PostMoveDecisionMenu> {

	public static int HORIZONTAL_OFFSET = 75;
	
	@Override
	public void draw() {
//		if(model.getShouldDraw()) drawActionNames();
	}
	
	private void drawActionNames() {
//		Position activeUnitPosition = model.getActiveUnitPosition();
//		List<PostMoveDecision> actions = model.getDecisions();
//		
//		for(int actionIdx = 0; actionIdx < actions.size(); actionIdx++) {
//			Action action = actions.get(actionIdx);
//			
//			setFillColorForActionName(action);
//			
//			ctx.text(
//				action.getName(), 
//				activeUnitPosition.getX() * SPACE_HEIGHT + HORIZONTAL_OFFSET, 
//				activeUnitPosition.getY() * SPACE_WIDTH + actionIdx * 15
//			);
//		}
	}
	
	private void setFillColorForActionName(Action action) {
		if(model.getCursorPosition() == action.getPosition())
			ctx.fill(0, 255, 255);
		else
			ctx.fill(0);
	}
	
}
