package l2kstudios.gme.model.grid;

import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu {
	
	private boolean active;
	private Unit actingUnit;
	private List<Action> selectableActions;
	
	public void showFor(Unit unit) {
		active = true;
		selectableActions = unit.getActions().stream()
											.filter(Action::ableToExecute)
											.collect(Collectors.toList());
		actingUnit = unit;
	}
	
	private void chooseAction(int actionIdx) {
		selectableActions.get(actionIdx).execute();
		active = false;
	}

	public boolean isActive() {
		return active;
	}
	
	public Position getActiveUnitPosition() {
		return actingUnit.getPosition();
	}
}
