package l2kstudios.gme.model.grid;

import static l2kstudios.gme.model.unit.Unit.BoardState.*;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu extends Grid {
	
	private Unit actingUnit;
	private List<Action> selectableActions;
	private int actionIdx;
	private boolean shouldDraw;
	
	private ActingUnitTracker actingUnitTracker;
	
	@Autowired
	public ActionMenu(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public void attachTo(Unit unit) {
		actingUnit = unit;
	}
	
	public void initialize() {
		selectableActions = actingUnitTracker.getActingUnit()
											.getActions()
											.stream()
											.filter(Action::ableToExecute)
											.collect(Collectors.toList());
		
		shouldDraw = true;
	}
	
	public boolean select() {
		getSelectableActions().get(actionIdx).execute();
		shouldDraw = false;
		actionIdx = 0;
		return true;
	}
	
	public void scrollUp() {
		actionIdx--;
	}
	
	public void scrollDown() {
		actionIdx++;
	}

	public boolean getShouldDraw() {
		return shouldDraw;
	}
	
	public Position getActiveUnitPosition() {
		return actingUnit.getPosition();
	}
	
	public List<Action> getSelectableActions() {
		return selectableActions;
	}
}
