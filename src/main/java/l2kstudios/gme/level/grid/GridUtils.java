package l2kstudios.gme.level.grid;

import l2kstudios.gme.level.Position;

public class GridUtils {
	public static int distanceBetween(Position posA, Position posB) {
		return  Math.abs(posA.getX() - posB.getX()) + Math.abs(posA.getY() - posB.getY());
	}
}
