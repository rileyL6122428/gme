package l2kstudios.gme.level;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovementCycle {
	
	private List<List<Unit>> moveSpread;
	private List<Unit> moveOrder;
	private UnitMovementData unitMovementData;
	
	public void setUnits(List<Unit> units) {
		unitMovementData = new UnitMovementData(units);
		configureMoveSpread(units);
		setMoveOrder();
	}
	
	private void setMoveOrder() {
		moveOrder = new ArrayList<Unit>();
		
		for(List<Unit> moveSpreadNode : moveSpread) {
			moveOrder.addAll(moveSpreadNode);
		}
	}

	private void configureMoveSpread(List<Unit> units) {
		initializeMoveSpread(units);
		populateMoveSpread();
		sortMoveSpreadNodes();
	}
	
	private void sortMoveSpreadNodes() {
		moveSpread.forEach((moveSpreadNode) -> {
			moveSpreadNode.sort(new Comparator<Unit>(){
				@Override
				public int compare(Unit unit1, Unit unit2) {
					return (int)(unit1.getSpeed() - unit2.getSpeed());
				}
			});
		});
		
	}

	private void initializeMoveSpread(List<Unit> units) {
		moveSpread = new ArrayList<List<Unit>>();
		for(int idx = 0; idx < unitMovementData.getSpeedLCM(); idx++) {
			moveSpread.add(new ArrayList<Unit>());
		}
	}
	
	private void populateMoveSpread() {
		for(Unit unit : unitMovementData.getUnitInterator()) {
			long invertedSpeed = unitMovementData.getInvertedSpeed(unit);
			for(long speedMultiple = invertedSpeed; speedMultiple <= unitMovementData.getSpeedLCM(); speedMultiple += invertedSpeed) {
				List<Unit> moveSpreadNode = moveSpread.get((int)speedMultiple - 1);
				moveSpreadNode.add(unit);
			}
		}
	}
	
	public List<Unit> getOrder() {
		return moveOrder;
	}
}
