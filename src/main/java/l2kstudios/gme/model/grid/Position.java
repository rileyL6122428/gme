package l2kstudios.gme.model.grid;

public class Position {
	private int x, y;
	
	public Position() {
		
	}
	
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
