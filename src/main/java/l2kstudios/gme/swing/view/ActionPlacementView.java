package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.actioninterface.ActionPlacementInterface;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;

import static l2kstudios.gme.swing.view.GridConstants.*;

public class ActionPlacementView implements ActionInterfaceView {

	private ActionPlacementInterface actionInterface;
	
	@Override
	public void draw(Graphics drawingCtx) {
		List<Space> playingGridSpaces = getActionInterface().getChooseableSpaces();
		playingGridSpaces.forEach((space) -> {
			Position position = space.getPosition();
			drawingCtx.setColor(Color.CYAN);
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
