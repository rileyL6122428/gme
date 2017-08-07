package l2kstudios.gme.swing.gameinterface;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;

public class ActionInstanceMenu extends TurnInterfaceBase { 

	private Unit actingUnit;
	private List<Action> actionInstances;

	@Override
	public void draw(Graphics drawingCtx) {
		for(int placementIdx = 0; placementIdx < actionInstances.size(); placementIdx++) {
			int decisionIdx = actionInstances.size() - (placementIdx + 1);
			Action decision = actionInstances.get(decisionIdx);
			Position unitPosition = getActingUnit().getPosition();
			
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
		// TODO Auto-generated method stub
		return null;
	}

	public Unit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}

	@Override
	public void initialize() {
		actionInstances = turn.getBufferedActionInstances();
		actingUnit = turn.getActingUnit();
		cursor = BoundedCursor.fromActionList(actionInstances);
	}
	
}
