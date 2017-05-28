package l2kstudios.gme.model.action.postmove;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.actioninterface.SingleRowActionInterface;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.unit.Unit;

public class PostMoveDecisionMenu extends SingleRowActionInterface {
	
	private Unit actingUnit;
	
	private Turn turn;
	
	private List<Action> decisions;
	
	public PostMoveDecisionMenu() {}
	
	public PostMoveDecisionMenu(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}
	
	public void initialize(Turn turn) {
		this.turn = turn;
		actingUnit = turn.getActingUnit();
		setSpacesToDecisions(actingUnit);
		cacheExecutableActions();
		Space firstSpaceInList = getSpaceAt(0);
		cursor.setPosition(firstSpaceInList.getPosition());
	}
	
	public void initialize() {
		setSpacesToDecisions(actingUnit);
		cacheExecutableActions();
		Space firstSpaceInList = getSpaceAt(0);
		cursor.setPosition(firstSpaceInList.getPosition());
	}
	
	private void setSpacesToDecisions(Unit unit) {
		List<Space> row = new ArrayList<Space>();
		
		for(PostMoveDecision decision: unit.getPostMoveDecisions()) {
			if(decision.ableToExecute()) {
				Space space = new Space();
				decision.place(space);
				row.add(space);				
			}
		}
		
		setRow(row);
	}
	
	private void cacheExecutableActions() {
		decisions = new ArrayList<Action>();
		
		for(Space space : getRow()) {
			decisions.add((Action)space.getOccupier());
		}
	}
	
	public boolean select() {
//		executeHoveredAction();
		turn.addAction((Action) hoveredSpace().getOccupier());
		return true;
	}
	
	private void executeHoveredAction() {
		PostMoveDecision action = (PostMoveDecision)hoveredSpace().getOccupier();
		action.execute();		
	}
	
	public List<Action> getDecisions() {
		return decisions;
	}
	
	public Position getActingUnitPosition() {
		return actingUnit.getPosition();
	}
}
