package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;

public class AttackOptions extends SingleRowGrid {
	
	private ActingUnitTracker actingUnitTracker;
	
	public List<Attack> getAttacks() {
		return actingUnitTracker.getActingUnit().getAttacks();
	}
	
	public boolean select() {
		passSelectedAttackToPlacementGrid();
		actingUnitTracker.getActingUnit().registerPlacingAttack();
		return true;
	}
	
	private void passSelectedAttackToPlacementGrid() {
		AttackPlacement attackPlacement = GameModelService.getAttackPlacementGrid();
		Attack selectedAttack = (Attack)hoveredSpace().getOccupier();
		attackPlacement.setAttackToPlace(selectedAttack);
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
