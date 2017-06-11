package l2kstudios.gme.model.action.postmove;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.actioninterface.SingleRowActionInterface;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.PlayerControlledTurn;
import l2kstudios.gme.model.unit.Unit;

public class PostMoveDecisionMenu extends SingleRowActionInterface {
	
	private PlayerControlledTurn turn;
	
	public boolean select() {
		PostMoveDecision decision = (PostMoveDecision) hoveredSpace().getOccupier();
		turn.setPostMoveActionType(decision.getPostMoveActionType());
		return true;
	}
	
	public void initialize(PlayerControlledTurn turn) {
		super.initialize(turn);
		this.turn = turn;
		Unit actingUnit = turn.getActingUnit();
		setSpacesToDecisions(actingUnit);
		setChooseableSpaces();
		cursor.setPosition(getSpaceAt(0).getPosition());
	}
	
	private void setSpacesToDecisions(Unit unit) {
		List<Space> row = new ArrayList<Space>();
		
		for(Class decisionType: unit.getPostMoveDecisions()) {
			try {
				PostMoveDecision decision = (PostMoveDecision) decisionType.newInstance();
				Space space = new Space();
				decision.place(space);
				row.add(space);				
				
			} catch (Exception e) { e.printStackTrace(); }
		}
		
		setRow(row);
	}
	
	private void setChooseableSpaces() {
		chooseableSpaces = new ArrayList<Space>();
		
		for(Space space : getRow()) {
			chooseableSpaces.add(space);
		}
	}
	
}
