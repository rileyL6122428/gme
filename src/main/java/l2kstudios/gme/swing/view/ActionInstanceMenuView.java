package l2kstudios.gme.swing.view;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.swing.gameinterface.ActionInstanceMenu;

public class ActionInstanceMenuView implements ActionInterfaceView {

	private ActionInstanceMenu menu; 
	
	public void draw(Graphics drawingCtx) {
		Position actingUnitPosition  = menu.getActingUnitPosition();
		
		menu.forEachActionInstance((actionInstance) -> {
			setNameColor(drawingCtx, actionInstance);
			
			drawingCtx.drawString(
					actionInstance.getName(), 
					actingUnitPosition.getX() * SPACE_WIDTH  + 20, 
					actingUnitPosition.getY() * SPACE_HEIGHT + actionInstance.getIndex() * 20
			);
		});
	}
	
	private void setNameColor(Graphics drawingCtx, Action actionInstance) {
		Position cursorPosition = menu.getCursorPosition();
		
		if(actionInstance.getPosition() == cursorPosition)
			drawingCtx.setColor(Color.GREEN);
		else
			drawingCtx.setColor(Color.BLACK);
	}

	public ActionInstanceMenu getActionInterface() {
		return menu;
	}

	public void setActionInterface(ActionInstanceMenu actionInterface) {
		this.menu = actionInterface;
	}

}
