package l2kstudios.gme.swing.gameinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;
import static l2kstudios.gme.swing.view.GridConstants.*;

public class PostMoveDecisionMenu extends TurnInterfaceBase {
	
	private Unit actingUnit;
	private List<PostMoveDecision> decisions;

	@Override
	public void draw(Graphics drawingCtx) {
		drawDecisionName(drawingCtx);
	}

	private void drawDecisionName(Graphics drawingCtx) {
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
		if(decisionIdx == cursor.getY()) {
			drawingCtx.setColor(Color.GREEN);
		} else {
			drawingCtx.setColor(Color.BLACK);
		}
	}

	@Override
	public PhaseProgressionFlag select() {
		turn.takeAction(
			this::bufferActionType, 
			this::removeBufferedActionType
		);
		
		return PhaseProgressionFlag.ADVANCE;
	}
	
	private void bufferActionType() {
		Class actionType = hoveredPostMoveDecision().getPostMoveActionType();
		turn.setBufferedActionType(actionType);
	}
	
	private void removeBufferedActionType() {
		turn.setBufferedActionType(null);
	}
	
	private PostMoveDecision hoveredPostMoveDecision() {
		int hoveredDecisionIdx = decisions.size() - (cursor.getY() + 1); 
		return decisions.get(hoveredDecisionIdx); 
	}

	public Unit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}
	
	public void afterPropertiesSet() {
		decisions = actingUnit.getPostMoveDecisions();
		cursor = new BoundedCursor(decisions);
	}
	
}
