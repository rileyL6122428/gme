package l2kstudios.gme.model.grid;

import l2kstudios.gme.model.level.Position;

public class GridUtils {
	public static int distanceBetween(Position posA, Position posB) {
		return  Math.abs(posA.getX() - posB.getX()) + Math.abs(posA.getY() - posB.getY());
	}
}
