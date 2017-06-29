package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.actioninterface.PostMoveDecisionMenu;
import l2kstudios.gme.model.grid.Position;

import static l2kstudios.gme.swing.view.GridConstants.*;

public class PostMoveDecisionMenuView implements ActionInterfaceView {
	
	private PostMoveDecisionMenu actionInterface; 
	
	public void draw(Graphics drawingCtx) {
		Position actingUnitPosition  = actionInterface.getActingUnitPosition();
		actionInterface.forEachPostMoveDecision((postMoveDecision) -> {
			drawingCtx.drawString(
					postMoveDecision.getName(), 
					actingUnitPosition.getX() * SPACE_WIDTH  + 20, 
					actingUnitPosition.getY() * SPACE_HEIGHT + postMoveDecision.getDecisionNumber() * 20
			);
		});
	}

	public PostMoveDecisionMenu getActionInterface() {
		return actionInterface;
	}

	public void setActionInterface(PostMoveDecisionMenu actionInterface) {
		this.actionInterface = actionInterface;
	}
	
}
