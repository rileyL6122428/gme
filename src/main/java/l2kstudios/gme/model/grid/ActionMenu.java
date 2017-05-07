package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.unit.Action;
import l2kstudios.gme.model.unit.Unit;

public class ActionMenu extends Grid {
	
	private static int SINGLE_ROW_IDX = 0;

	private boolean shouldDraw;
	
	private ActingUnitTracker actingUnitTracker;
	
	private List<Action> executableActions;
	
	public ActionMenu() { }
	
	public ActionMenu(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public void moveCursorRight() { }
	
	public void moveCursorLeft() { }
	
	public void moveCursorDown() {
		super.moveCursorRight();
	}
	
	public void moveCursorUp() {
		super.moveCursorLeft();
	}
	
	public void initialize() {
		setSpacesToExecutableActions(actingUnitTracker.getActingUnit());
		cacheExecutableActions();
		Space firstSpaceInList = spaces.get(SINGLE_ROW_IDX).get(0);
		cursor.setPosition(firstSpaceInList.getPosition());
		shouldDraw = true;
	}
	
	private void setSpacesToExecutableActions(Unit unit) {
		List<List<Space>> spaces = new ArrayList<List<Space>>();
		
		spaces.add(new ArrayList<Space>());
		for(Action action: unit.getActions()) {
			if(action.ableToExecute()) {
				Space space = new Space();
				action.place(space);
				spaces.get(SINGLE_ROW_IDX).add(space);				
			}
		}
		
		setSpaces(spaces);
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
	
	private void cacheExecutableActions() {
		executableActions = new ArrayList<Action>();
		
		for(Space space : spaces.get(SINGLE_ROW_IDX)) {
			executableActions.add((Action)space.getOccupier());
		}
	}
}
