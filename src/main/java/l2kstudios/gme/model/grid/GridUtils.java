package l2kstudios.gme.model.grid;

import l2kstudios.gme.model.unit.Unit;

public class GridUtils {
	public static int distanceBetween(Position posA, Position posB) {
		return  Math.abs(posA.getX() - posB.getX()) + Math.abs(posA.getY() - posB.getY());
	}
	
	public static int distanceBetween(int x1, int y1, int x2, int y2) {
		return  Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
