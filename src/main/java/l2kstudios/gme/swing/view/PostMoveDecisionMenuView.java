package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.swing.gameinterface.PostMoveDecisionMenu;

import static l2kstudios.gme.swing.view.GridConstants.*;

public class PostMoveDecisionMenuView implements ActionInterfaceView {
	
	private PostMoveDecisionMenu menu; 
	
	public void draw(Graphics drawingCtx) {
		Position actingUnitPosition  = menu.getActingUnitPosition();
		Position cursorPosition = menu.getCursorPosition();
		menu.forEachPostMoveDecision((postMoveDecision) -> {
			
			if(postMoveDecision.getPosition() == cursorPosition)
				drawingCtx.setColor(Color.GREEN);
			else
				drawingCtx.setColor(Color.BLACK);
			
			drawingCtx.drawString(
					postMoveDecision.getName(), 
					actingUnitPosition.getX() * SPACE_WIDTH  + 20, 
					actingUnitPosition.getY() * SPACE_HEIGHT + postMoveDecision.getDecisionNumber() * 20
			);
		});
	}

	public PostMoveDecisionMenu getActionInterface() {
		return menu;
	}

	public void setActionInterface(PostMoveDecisionMenu actionInterface) {
		this.menu = actionInterface;
	}
	
}
