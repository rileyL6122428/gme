package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.unit.Unit;

public class AttackOptions extends SingleRowGrid {
	
	private ActingUnitTracker actingUnitTracker;
	
	private List<Attack> attacks;
	
	public List<Attack> getAttacks() {
		return actingUnitTracker.getActingUnit().getAttacks();
	}


	public void initialize() {
		final List<Space> row = new ArrayList<Space>();
		actingUnitTracker.getActingUnit().getAttacks().forEach((attack) -> {
			Space space = new Space();
			attack.place(space);
			row.add(space);
		});
		setRow(row);
		
		Space firstSpaceInList = getSpaceAt(0);
		cursor.setPosition(firstSpaceInList.getPosition());
	}


	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
	
	public boolean shouldRender() {
		return actingUnitTracker.getActingUnit().isChoosingAttack();
	}


	public Position getActiveUnitPosition() {
		return actingUnitTracker.getActingUnit().getPosition();
	}
	
}
