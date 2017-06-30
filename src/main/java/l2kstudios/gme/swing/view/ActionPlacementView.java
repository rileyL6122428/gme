package l2kstudios.gme.swing.view;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Graphics;

import l2kstudios.gme.model.actioninterface.ActionPlacementInterface;
import l2kstudios.gme.model.grid.Position;

public class ActionPlacementView implements ActionInterfaceView {

	private ActionPlacementInterface actionInterface;
	
	@Override
	public void draw(Graphics drawingCtx) {
		drawChooseableSpaces(drawingCtx);
		
		Position cursorPosition = actionInterface.getCursorPosition();
		drawingCtx.setColor(ColorConstants.ACTION_PLACEMENT_CURSOR_COLOR);
		drawingCtx.fillRect(cursorPosition.getX() * SPACE_WIDTH, cursorPosition.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
	}
	
	public void drawChooseableSpaces(Graphics drawingCtx) {
		drawingCtx.setColor(ColorConstants.ACTION_PLACEMENT_SPACE_COLOR);
		
		actionInterface.getChooseableSpaces().forEach((space) -> {
			Position position = space.getPosition();
			drawingCtx.fillRect(position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
		});
	}

	public ActionPlacementInterface getActionInterface() {
		return actionInterface;
	}

	public void setActionInterface(ActionPlacementInterface actionInterface) {
		this.actionInterface = actionInterface;
	}
	
}
