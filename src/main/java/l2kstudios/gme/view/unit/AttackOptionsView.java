package l2kstudios.gme.view.unit;

import static l2kstudios.gme.view.constants.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.view.constants.GridConstants.SPACE_WIDTH;

import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.actioninterface.AttackOptions;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.view.View;

public class AttackOptionsView extends View<AttackOptions> {
	
	public static int HORIZONTAL_OFFSET = 75;
	
	public void draw() {
//		if(model.shouldRender()) {
//			Position activeUnitPosition = model.getActiveUnitPosition();
//			List<Attack> actions = model.getAttacks();
//			
//			for(int actionIdx = 0; actionIdx < actions.size(); actionIdx++) {
//				Attack attack = actions.get(actionIdx);
//				
//				setFillColorForActionName(attack);
//				
//				ctx.text(
//					attack.getName(), 
//					activeUnitPosition.getX() * SPACE_HEIGHT + HORIZONTAL_OFFSET, 
//					activeUnitPosition.getY() * SPACE_WIDTH + actionIdx * 15
//				);
//			}
			
//		}
	}
	
	private void setFillColorForActionName(Action action) {
		if(model.getCursorPosition() == action.getPosition())
			ctx.fill(0, 255, 255);
		else
			ctx.fill(0);
	}
	
}
