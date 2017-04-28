package l2kstudios.gme.model.grid;

import static l2kstudios.gme.model.unit.Unit.BoardState.*;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu {
	
	private Unit actingUnit;
	private List<Action> selectableActions;
	
	public void attachTo(Unit unit) {
		selectableActions = unit.getActions().stream()
											.filter(Action::ableToExecute)
											.collect(Collectors.toList());
		actingUnit = unit;
	}
	
	private void chooseAction(int actionIdx) {
		selectableActions.get(actionIdx).execute();
	}

	public boolean shouldDraw() {
		return actingUnit.isInBoardState(CHOOSING_ACTION);
	}
	
	public Position getActiveUnitPosition() {
		return actingUnit.getPosition();
	}
}
