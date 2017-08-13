package l2kstudios.gme.swing.gameinterface.turn;

import static l2kstudios.gme.swing.view.ColorConstants.ActionPlacement.CURSOR_COLOR;
import static l2kstudios.gme.swing.view.ColorConstants.ActionPlacement.SELECTABLE_SPACE_COLOR;

import java.awt.Graphics;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.swing.view.View;
import l2kstudios.gme.swing.view.ViewUtils;

public class ActionPlacementView implements View {
	
	private ActionPlacementInterface actionPlacementInterface;
	
	public ActionPlacementView(ActionPlacementInterface actionPlacementInterface) {
		this.actionPlacementInterface = actionPlacementInterface;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		drawMoveableSpaces(drawingCtx);
		drawCursor(drawingCtx);
		drawRangeOfEffect(drawingCtx);
	}

	private void drawMoveableSpaces(Graphics drawingCtx) {
		drawingCtx.setColor(SELECTABLE_SPACE_COLOR);
		
		actionPlacementInterface.getChooseableSpaces().forEach((space) -> {
			ViewUtils.drawFillRectAt(space, drawingCtx);
		});
	}

	private void drawCursor(Graphics drawingCtx) {
		drawingCtx.setColor(CURSOR_COLOR);
		ViewUtils.drawFillRectAt(actionPlacementInterface.getCursorPosition(), drawingCtx);
	}

	private void drawRangeOfEffect(Graphics drawingCtx) {
		RangeOfEffect rangeOfEffect = actionPlacementInterface.getRangeOfEffect();
		Position cursorPosition = actionPlacementInterface.getCursorPosition();
		
		
		if(actionPlacementInterface.canChoose(cursorPosition)) {
			drawingCtx.setColor(CURSOR_COLOR);
			rangeOfEffect.affectedSpaces(cursorPosition).forEach((space) -> {
				ViewUtils.drawFillRectAt(space.getPosition(), drawingCtx);
			});			
		}
	}

	public ActionPlacementInterface getActionPlacementInterface() {
		return actionPlacementInterface;
	}

	public void setActionPlacementInterface(ActionPlacementInterface actionPlacementInterface) {
		this.actionPlacementInterface = actionPlacementInterface;
	}

}
