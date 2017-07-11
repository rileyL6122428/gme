package l2kstudios.gme.model.movement;

import java.util.Comparator;

import l2kstudios.gme.model.unit.Unit;
import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class SlowestToFastestComparator implements Comparator<Unit> {
	
	static final private SlowestToFastestComparator slowestToFastestComparator;
	
	static {
		slowestToFastestComparator = new SlowestToFastestComparator();
	}
	
	static public SlowestToFastestComparator getInstance() {
		return slowestToFastestComparator;
	}

	@Override
	public int compare(Unit unit1, Unit unit2) {
		return (int) (unit1.get(SPEED) - unit2.get(SPEED));
	}

}
