package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu extends SingleRowGrid {

	private boolean shouldDraw;
	
	private ActingUnitTracker actingUnitTracker;
	
	private List<Action> executableActions;
	
	public void initialize() {
		setSpacesToExecutableActions(actingUnitTracker.getActingUnit());
		cacheExecutableActions();
		Space firstSpaceInList = getSpaceAt(0);
		cursor.setPosition(firstSpaceInList.getPosition());
		shouldDraw = true;
	}
	
	private void setSpacesToExecutableActions(Unit unit) {
		List<Space> row = new ArrayList<Space>();
		
		for(Action action: unit.getPostMoveActions()) {
			if(action.ableToExecute()) {
				Space space = new Space();
				action.place(space);
				row.add(space);				
			}
		}
		
		setRow(row);
	}
	
	private void cacheExecutableActions() {
		executableActions = new ArrayList<Action>();
		
		for(Space space : getRow()) {
			executableActions.add((Action)space.getOccupier());
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
		return actingUnitTracker.getActingUnit().getPosition();
	}
	
	public List<Action> getExecutableActions() {
		return executableActions;
	}
	
	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}

}
