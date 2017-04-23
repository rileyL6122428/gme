package l2kstudios.gme.model.grid;

public class GridUtils {
	public static int distanceBetween(Position posA, Position posB) {
		return  Math.abs(posA.getX() - posB.getX()) + Math.abs(posA.getY() - posB.getY());
	}
}
