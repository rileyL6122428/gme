package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu extends Grid {
	
	private static int SINGLE_ROW_IDX = 0;
	
	private Unit actingUnit;
	private boolean shouldDraw;
	
	private ActingUnitTracker actingUnitTracker;
	
	@Autowired
	public ActionMenu(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public void initialize() {
		setSpacesToExecutableActions(actingUnitTracker.getActingUnit());
		shouldDraw = true;
	}
	
	private void setSpacesToExecutableActions(Unit unit) {
		spaces = new ArrayList<List<Space>>();
		spaces.add(new ArrayList<Space>());
		for(Action action: unit.getActions()) {
			if(action.ableToExecute()) {
				Space space = new Space();
				action.place(space);
				spaces.get(SINGLE_ROW_IDX).add(space);				
			}
		}
	}
	
	public boolean select() {
		executeHoveredAction();
		shouldDraw = false;
		return true;
	}
	
	private void executeHoveredAction() {
		Action action = (Action)hoveredSpace().getOccupier();
		action.execute();		
	}

	public boolean getShouldDraw() {
		return shouldDraw;
	}
	
	public Position getActiveUnitPosition() {
		return actingUnit.getPosition();
	}
	
	public List<Action> getSelectableActions() {
		List<Action> selectableActions = new ArrayList<Action>();
		
		for(Space space : spaces.get(SINGLE_ROW_IDX)) {
			selectableActions.add((Action)space.getOccupier());
		}
		
		return selectableActions;
	}
}
