package l2kstudios.gme.swing.gameinterface.turn;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Cursor;
import l2kstudios.gme.model.grid.position.Position;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class ActionInstanceMenu extends TurnInterfaceBase implements TextMenu { 

	private Cursor cursor;
	
	private Unit actingUnit;
	private List<Action> actionInstances;
	private List<String> actionNames;
	
	private View view;

	@Override
	public void draw(Graphics drawingCtx) {
		view.draw(drawingCtx);
	}

	@Override
	public PhaseProgressionFlag select() {
		turn.takeAction(
			this::setBufferedAction, 
			this::unsetBufferedAction
		);
		return PhaseProgressionFlag.ADVANCE;
	}
	
	private void setBufferedAction() {
		turn.bufferAction(hoveredAction());
	}
	
	private Action hoveredAction() {
		return actionInstances.get(cursor.getY());
	}

	private void unsetBufferedAction() {
		turn.clearBufferedAction();
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
		actionNames = actionInstances.stream().map(action -> action.getName()).collect(Collectors.toList());
		actingUnit = turn.getActingUnit();
		cursor = BoundedCursor.fromActionList(actionInstances);
		
		view = new TextMenuView(this);
	}

	@Override
	public List<String> getSelectableItemNames() {
		return actionNames;
	}

	@Override
	public int size() {
		return this.actionInstances.size();
	}

	@Override
	public Position actingUnitPosition() {
		return actingUnit.getPosition();
	}

	@Override
	public int getCursorY() {
		return cursor.getY();
	}

	@Override
	public void moveCursorDown() {
		cursor.incrementPosition(0, 1);
	}

	@Override
	public void moveCursorUp() {
		cursor.incrementPosition(0, -1);
	}

	@Override
	public void moveCursorRight() {
		cursor.incrementPosition(1, 0);
	}

	@Override
	public void moveCursorLeft() {
		cursor.incrementPosition(-1, 0);
	}
	
}
