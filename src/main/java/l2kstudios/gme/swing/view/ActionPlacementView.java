package l2kstudios.gme.swing.view;

import static l2kstudios.gme.swing.view.ColorConstants.ActionPlacement.*;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.swing.gameinterface.ActionPlacementInterface;

public class ActionPlacementView implements ActionInterfaceView {

	private ActionPlacementInterface actionInterface;
	
	@Override
	public void draw(Graphics drawingCtx) {
		drawChooseableSpaces(drawingCtx);
		drawRangeOfEffect(drawingCtx);
		drawCursorPosition(drawingCtx);
	}
	
	public void drawChooseableSpaces(Graphics drawingCtx) {
		drawingCtx.setColor(SELECTABLE_SPACE_COLOR);
		
		actionInterface.getChooseableSpaces().forEach((space) -> {
			Position position = space.getPosition();
			drawingCtx.fillRect(position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
		});
	}
	
	private void drawRangeOfEffect(Graphics drawingCtx) {
		if(actionInterface.canChooseHoveredSpace()) {
			Position cursorPosition = actionInterface.getCursorPosition();
			
			RangeOfEffect rangeOfEffect = actionInterface.getRangeOfEffect();
			List<Space> affectedSpaces = rangeOfEffect.affectedSpaces(cursorPosition);
			drawingCtx.setColor(RANGE_OF_EFFECT_COLOR);
			
			affectedSpaces.forEach((space) -> {
				drawRangeOfEffectSpace(drawingCtx, space);
			});			
		}
	}

	private void drawRangeOfEffectSpace(Graphics drawingCtx, Space space) {
		Position spacePosition = space.getPosition();
		
		drawingCtx.fillRect(
				spacePosition.getX() * SPACE_WIDTH, 
				spacePosition.getY() * SPACE_HEIGHT, 
				SPACE_WIDTH, 
				SPACE_HEIGHT
		);
	}

	public void drawCursorPosition(Graphics drawingCtx) {
		Position cursorPosition = actionInterface.getCursorPosition();
		drawingCtx.setColor(CURSOR_COLOR);
		drawingCtx.fillRect(cursorPosition.getX() * SPACE_WIDTH, cursorPosition.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
		
		if(actionInterface.canChooseHoveredSpace()) {
			drawOutline(drawingCtx);			
		}
	}

	private void drawOutline(Graphics drawingCtx) {
		Position cursorPosition = actionInterface.getCursorPosition();
		drawingCtx.setColor(Color.GREEN);
		
		drawingCtx.drawLine(
				cursorPosition.getX() * SPACE_WIDTH, 
				cursorPosition.getY() * SPACE_HEIGHT, 
				(cursorPosition.getX() + 1) * SPACE_WIDTH, 
				cursorPosition.getY() * SPACE_HEIGHT
		);
		
		drawingCtx.drawLine(
				cursorPosition.getX() * SPACE_WIDTH, 
				(cursorPosition.getY() + 1) * SPACE_HEIGHT, 
				(cursorPosition.getX() + 1) * SPACE_WIDTH, 
				(cursorPosition.getY() + 1) * SPACE_HEIGHT
		);
		
		drawingCtx.drawLine(
				cursorPosition.getX() * SPACE_WIDTH, 
				cursorPosition.getY() * SPACE_HEIGHT, 
				cursorPosition.getX() * SPACE_WIDTH, 
				(cursorPosition.getY() + 1) * SPACE_HEIGHT
		);
		
		drawingCtx.drawLine(
				(cursorPosition.getX() + 1) * SPACE_WIDTH, 
				cursorPosition.getY() * SPACE_HEIGHT, 
				(cursorPosition.getX() + 1) * SPACE_WIDTH, 
				(cursorPosition.getY() + 1) * SPACE_HEIGHT
		);
	}

	public ActionPlacementInterface getActionInterface() {
		return actionInterface;
	}

	public void setActionInterface(ActionPlacementInterface actionInterface) {
		this.actionInterface = actionInterface;
	}
	
}
