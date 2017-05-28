package l2kstudios.gme.model.actioninterface;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.unit.Unit;

public class AttackOptions extends SingleRowActionInterface {
	
	private Unit actingUnit;
	private Turn turn;
	
	public AttackOptions() {}
	
	public AttackOptions(Unit actingUnit) {
		this.actingUnit = actingUnit;
	}
	
	
	public boolean select() {
		return true;
	}
	
	public void initialize(Turn turn) {
		actingUnit = turn.getActingUnit();
		this.turn = turn;
		initialize();
	}

	public void initialize() {
		final List<Space> row = new ArrayList<Space>();
		getAttacks().forEach((attack) -> {
			Space space = new Space();
			attack.place(space);
			row.add(space);
		});
		setRow(row);
		
		Space firstSpaceInList = getSpaceAt(0);
		cursor.setPosition(firstSpaceInList.getPosition());
	}
	
	public List<Attack> getAttacks() {
		return actingUnit.getAttacks();
	}

	public Position getActingUnitPosition() {
		return turn.getTargetSpace().getPosition();
	}
}
