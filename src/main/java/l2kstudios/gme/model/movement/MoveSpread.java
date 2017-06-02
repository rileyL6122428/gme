package l2kstudios.gme.model.movement;

import java.util.LinkedList;
import java.util.List;

import l2kstudios.gme.model.unit.Unit;

public class MoveSpread {
	
	private List<MoveSpreadNode> uncondensedSpread;
	private UnitMovementData unitMovementData;
	
	private MoveSpreadNode currentNode;
	
	public MoveSpread(UnitMovementData unitMovementData) {
		this.unitMovementData = unitMovementData;
		layUncondensedSpread();
		populateUncondensedSpread();
		sortUncondesedSpread();
	}
	
	public List<Unit> getCondensed() {
		List<Unit> moveOrder = new LinkedList<Unit>();
		
		for(MoveSpreadNode moveSpreadNode : uncondensedSpread) {
			moveOrder.addAll(moveSpreadNode.getUnits());
		}
		
		return moveOrder;
	}
	
	private void layUncondensedSpread() {
		uncondensedSpread = new LinkedList<MoveSpreadNode>();
		for(int idx = 0; idx < unitMovementData.getSpeedLCM(); idx++) {
			uncondensedSpread.add(new MoveSpreadNode(SlowestToFastestComparator.getInstance()));
		}
	}
	
	private void populateUncondensedSpread() {
		for(Unit unit : unitMovementData.getUnitInterator()) {
			long invertedSpeed = unitMovementData.getInvertedSpeed(unit);
			for(long speedMultiple = invertedSpeed; speedMultiple <= unitMovementData.getSpeedLCM(); speedMultiple += invertedSpeed) {
				MoveSpreadNode moveSpreadNode = uncondensedSpread.get((int)speedMultiple - 1);
				moveSpreadNode.addUnit(unit);
			}
		}
	}
	
	private void sortUncondesedSpread() {
		uncondensedSpread.forEach(MoveSpreadNode::sort);	
	}
}
