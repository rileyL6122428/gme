package l2kstudios.gme.view.actioninterface;

import java.util.List;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.view.constants.GridConstants;
import l2kstudios.gme.model.action.Action;

public class ActionInstanceMenuView extends ActionInterfaceView {
	
public static int HORIZONTAL_OFFSET = 75;
	
	@Override
	public void draw() {
		drawActionNames();
	}
	
	private void drawActionNames() {
		Position actingUnitPosition = model.getActingUnitPosition();
		List<Space> chooseableSpaces = model.getChooseableSpaces();
		
		for(int actionIdx = 0; actionIdx < chooseableSpaces.size(); actionIdx++) {
			Space space = chooseableSpaces.get(actionIdx);
			Action action = (Action) space.getOccupier(); 
			
			setFillColorForActionName(space);
			
			ctx.text(
				action.getName(), 
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
