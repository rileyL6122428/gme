package l2kstudios.gme.swing.gameinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

import static l2kstudios.gme.swing.view.GridConstants.*;

public class PostMoveDecisionMenu extends TurnInterfaceBase implements TextMenu {
	
	private Unit actingUnit;
	private List<PostMoveDecision> decisions;
	private List<String> decisionNames;
	
	private View view;

	@Override
	public void draw(Graphics drawingCtx) {
		drawDecisionName(drawingCtx);
	}

	private void drawDecisionName(Graphics drawingCtx) {
		view.draw(drawingCtx);
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
		turn.bufferActionType(actionType);
	}
	
	private void removeBufferedActionType() {
		turn.clearBufferedActionType();
	}
	
	private PostMoveDecision hoveredPostMoveDecision() {
		return decisions.get(cursor.getY()); 
	}

	public Unit getActingUnit() {
		return actingUnit;
	}

	public void setActingUnit(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}

	public int getCursorY() {
		return cursor.getY();
	}

	public List<PostMoveDecision> getDecisons() {
		return decisions;
	}
	
	public void initialize() {
		decisions = actingUnit.getPostMoveDecisions();
		decisionNames = decisions.stream().map(decision -> decision.getName()).collect(Collectors.toList());
		cursor = new BoundedCursor(decisions);
		view = new TextMenuView(this);
	}

	@Override
	public List<String> getSelectableItemNames() {
		return decisionNames;
	}

	@Override
	public int size() {
		return decisions.size();
	}

	@Override
	public Position actingUnitPosition() {
		return actingUnit.getPosition();
	}
}
