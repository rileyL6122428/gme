package l2kstudios.gme.swing.gameinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.turn.TurnPhaseSequence.PhaseProgressionFlag;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class ActionInstanceMenu extends TurnInterfaceBase implements TextMenu { 

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
	
}
