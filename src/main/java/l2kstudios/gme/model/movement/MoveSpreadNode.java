package l2kstudios.gme.model.movement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import l2kstudios.gme.model.unit.Unit;

public class MoveSpreadNode {

	private List<Unit> units;
	private Comparator<Unit> comparator;
	
	private MoveSpreadNode nextNode;
	private MoveSpreadNode prevNode;
	
	public MoveSpreadNode(Comparator<Unit> comparator) {
		units = new ArrayList<Unit>();
		this.comparator = comparator;
	}
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}
	
	public void sort() {
		units.sort(comparator);
	}
	
	public List<Unit> getUnits() {
		return units;
	}
	
}
