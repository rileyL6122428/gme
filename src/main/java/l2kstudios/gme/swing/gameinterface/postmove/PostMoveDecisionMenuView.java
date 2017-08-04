package l2kstudios.gme.swing.gameinterface.postmove;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.Cursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class PostMoveDecisionMenuView implements View {
	
	private PostMoveDecisionMenu postMoveDecisionMenu;
	
	public PostMoveDecisionMenuView(Turn turn, PostMoveDecisionMenu postMoveDecisionMenu) {
		this.postMoveDecisionMenu = postMoveDecisionMenu;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		drawDecisionName(drawingCtx);
	}
	
	private void drawDecisionName(Graphics drawingCtx) {
		List<PostMoveDecision> decisions = postMoveDecisionMenu.getDecisons();
		Unit actingUnit = postMoveDecisionMenu.getActingUnit();
		
		for(int placementIdx = 0; placementIdx < decisions.size(); placementIdx++) {
			int decisionIdx = decisions.size() - (placementIdx + 1);
			PostMoveDecision decision = decisions.get(decisionIdx);
			Position unitPosition = actingUnit.getPosition();
			
			setDecisionColor(decisionIdx, drawingCtx);
			
			drawingCtx.drawString(
				decision.getName(), 
				SPACE_WIDTH * unitPosition.getX() + 50,
				SPACE_HEIGHT * unitPosition.getY() - 10 + decisionIdx * 25
			);
		}
		
	}
	
	private void setDecisionColor(int decisionIdx, Graphics drawingCtx) {
		if(decisionIdx == postMoveDecisionMenu.getCursorY()) {
			drawingCtx.setColor(Color.GREEN);
		} else {
			drawingCtx.setColor(Color.BLACK);
		}
	}

}
