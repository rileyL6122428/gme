package l2kstudios.gme.model.action;

import java.util.ArrayList;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Delta;
import l2kstudios.gme.model.unit.Unit;

public class BasicAttack extends AttackAction {
	
	{
		name = "Basic Attack";
		
		rangeDeltas = new ArrayList<Delta>() {{
			add(new Delta(0, 1));
			add(new Delta(1, 0));
			add(new Delta(-1, 0));
			add(new Delta(0, -1));
		}};
	}
	
	public BasicAttack(Unit unit, PlayingGrid playingGrid) {
		executingUnit = unit;
		this.playingGrid = playingGrid;
	}
	
//	public boolean ableToExecute() {
//		return getAttackSpaces().size() != 0;
//	}
	
//	public void execute(Unit target) {
//		long damage = executingUnit.getAttack() - executingUnit.getDefense();
//		ConsummableStat targetHealth = target.getHealth();
//		targetHealth.setVal(targetHealth.getVal() - damage);
//	}
	
}
