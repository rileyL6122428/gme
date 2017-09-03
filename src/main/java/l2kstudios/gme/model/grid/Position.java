package l2kstudios.gme.model.grid;

public class Position {
	
	static private final PositionCache POSITION_CACHE;
	
	static {
		POSITION_CACHE = new PositionCache();
	}
	
	public static Position fromCached(int x, int y) {
		Position position = POSITION_CACHE.get(x, y);
		return POSITION_CACHE.get(x, y);
	}
	
	private int x, y;
	
	public Position() { }
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean hasCoordinates(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
