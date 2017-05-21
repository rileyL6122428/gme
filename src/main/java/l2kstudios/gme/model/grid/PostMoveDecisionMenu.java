package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.unit.Unit;

public class PostMoveDecisionMenu extends SingleRowGrid {

	private boolean shouldDraw;
	
	private ActingUnitTracker actingUnitTracker;
	
	private List<PostMoveDecision> decisions;
	
	public void initialize() {
		setSpacesToDecisions(actingUnitTracker.getActingUnit());
		cacheExecutableActions();
		Space firstSpaceInList = getSpaceAt(0);
		cursor.setPosition(firstSpaceInList.getPosition());
		shouldDraw = true;
	}
	
	private void setSpacesToDecisions(Unit unit) {
		List<Space> row = new ArrayList<Space>();
		
		for(PostMoveDecision action: unit.getPostMoveDecisions()) {
			if(action.ableToExecute()) {
				Space space = new Space();
				action.place(space);
				row.add(space);				
			}
		}
		
		setRow(row);
	}
	
	private void cacheExecutableActions() {
		decisions = new ArrayList<PostMoveDecision>();
		
		for(Space space : getRow()) {
			decisions.add((PostMoveDecision)space.getOccupier());
		}
	}
	
	public boolean select() {
		executeHoveredAction();
		shouldDraw = false;
		return true;
	}
	
	private void executeHoveredAction() {
		PostMoveDecision action = (PostMoveDecision)hoveredSpace().getOccupier();
		action.execute();		
	}

	public boolean getShouldDraw() {
		return shouldDraw;
	}
	
	public Position getActiveUnitPosition() {
		return actingUnitTracker.getActingUnit().getPosition();
	}
	
	public List<PostMoveDecision> getDecisions() {
		return decisions;
	}
	
	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public ActingUnitTracker getActingUnitTracker() {
		return actingUnitTracker;
	}

}
