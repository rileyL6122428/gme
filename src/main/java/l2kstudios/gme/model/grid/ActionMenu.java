package l2kstudios.gme.model.grid;

import static l2kstudios.gme.model.unit.Unit.BoardState.*;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu extends Grid {
	
	private Unit actingUnit;
	private List<Action> selectableActions;
	private int actionIdx;
	
	public void attachTo(Unit unit) {
		selectableActions = unit.getActions().stream()
											.filter(Action::ableToExecute)
											.collect(Collectors.toList());
		actingUnit = unit;
	}
	
	public void chooseAction() {
		selectableActions.get(actionIdx).execute();
		actionIdx = 0;
	}
	
	public void scrollUp() {
		actionIdx--;
	}
	
	public void scrollDown() {
		actionIdx++;
	}

	public boolean shouldDraw() {
		return actingUnit.isInBoardState(CHOOSING_ACTION);
	}
	
	public Position getActiveUnitPosition() {
		return actingUnit.getPosition();
	}
}
