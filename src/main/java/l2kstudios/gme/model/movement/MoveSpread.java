package l2kstudios.gme.model.movement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import l2kstudios.gme.model.level.Unit;

public class MoveSpread {
	private List<List<Unit>> uncondensedSpread;
	private UnitMovementData unitMovementData;
	
	public MoveSpread(UnitMovementData unitMovementData) {
		this.unitMovementData = unitMovementData;
		layUncondensedSpread();
		populateUncondensedSpread();
		sortUncondesedSpread();
	}
	
	public List<Unit> getCondensed() {
		List<Unit> moveOrder = new ArrayList<Unit>();
		
		for(List<Unit> moveSpreadNode : uncondensedSpread) {
			moveOrder.addAll(moveSpreadNode);
		}
		
		return moveOrder;
	}
	
	private void layUncondensedSpread() {
		uncondensedSpread = new ArrayList<List<Unit>>();
		for(int idx = 0; idx < unitMovementData.getSpeedLCM(); idx++) {
			uncondensedSpread.add(new ArrayList<Unit>());
		}
	}
	
	private void populateUncondensedSpread() {
		for(Unit unit : unitMovementData.getUnitInterator()) {
			long invertedSpeed = unitMovementData.getInvertedSpeed(unit);
			for(long speedMultiple = invertedSpeed; speedMultiple <= unitMovementData.getSpeedLCM(); speedMultiple += invertedSpeed) {
				List<Unit> moveSpreadNode = uncondensedSpread.get((int)speedMultiple - 1);
				moveSpreadNode.add(unit);
			}
		}
	}
	
	private void sortUncondesedSpread() {
		uncondensedSpread.forEach((moveSpreadNode) -> {
			moveSpreadNode.sort(new Comparator<Unit>(){
				@Override
				public int compare(Unit unit1, Unit unit2) {
					return (int)(unit1.getSpeed() - unit2.getSpeed());
				}
			});
		});	
	}
}
