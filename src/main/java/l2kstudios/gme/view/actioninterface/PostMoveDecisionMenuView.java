package l2kstudios.gme.view.actioninterface;

import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.actioninterface.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.view.constants.GridConstants;

public class PostMoveDecisionMenuView extends ActionInterfaceView {
	
	public static int HORIZONTAL_OFFSET = 75;
	
	@Override
	public void draw() {
		drawDecisionNames();
	}
	
	private void drawDecisionNames() {
		Position actingUnitPosition = model.getActingUnitPosition();
		List<Space> chooseableSpaces = model.getChooseableSpaces();
		
		for(int actionIdx = 0; actionIdx < chooseableSpaces.size(); actionIdx++) {
			Space space = chooseableSpaces.get(actionIdx);
			PostMoveDecision decision = (PostMoveDecision) space.getOccupier(); 
			
			setFillColorForActionName(space);
			
			ctx.text(
				decision.getName(), 
				actingUnitPosition.getX() * GridConstants.SPACE_HEIGHT + HORIZONTAL_OFFSET, 
				actingUnitPosition.getY() * GridConstants.SPACE_WIDTH + actionIdx * 15
			);
		}
	}
	
	private void setFillColorForActionName(Space space) {
		if(model.getCursorPosition() == space.getPosition())
			ctx.fill(0, 255, 255);
		else
			ctx.fill(0);
	}

}
