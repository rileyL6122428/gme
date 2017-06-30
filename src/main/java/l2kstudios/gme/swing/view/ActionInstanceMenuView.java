package l2kstudios.gme.swing.view;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.actioninterface.ActionInstanceMenu;
import l2kstudios.gme.model.grid.Position;

public class ActionInstanceMenuView implements ActionInterfaceView {

	private ActionInstanceMenu menu; 
	
	public void draw(Graphics drawingCtx) {
		Position actingUnitPosition  = menu.getActingUnitPosition();
		Position cursorPosition = menu.getCursorPosition();
		menu.forEachActionInstance((postMoveDecision) -> {
			
			if(postMoveDecision.getPosition() == cursorPosition)
				drawingCtx.setColor(Color.GREEN);
			else
				drawingCtx.setColor(Color.BLACK);
			
			drawingCtx.drawString(
					postMoveDecision.getName(), 
					actingUnitPosition.getX() * SPACE_WIDTH  + 20, 
					actingUnitPosition.getY() * SPACE_HEIGHT + postMoveDecision.getIndex() * 20
			);
		});
	}

	public ActionInstanceMenu getActionInterface() {
		return menu;
	}

	public void setActionInterface(ActionInstanceMenu actionInterface) {
		this.menu = actionInterface;
	}

}
