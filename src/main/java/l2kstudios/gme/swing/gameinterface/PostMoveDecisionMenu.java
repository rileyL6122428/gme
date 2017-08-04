package l2kstudios.gme.swing.gameinterface;

import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;

public class PostMoveDecisionMenu extends TurnInterfaceBase {
	
	private Unit actingUnit;
	private List<PostMoveDecision> decisions;

	@Override
	public void draw(Graphics drawingCtx) {
		drawingCtx.drawString("TESTING", 200, 200);
		
	}

	@Override
	public PhaseProgressionFlag select() {
		// TODO Auto-generated method stub
		return null;
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
