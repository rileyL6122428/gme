package l2kstudios.gme.model.grid;

public class Cursor {
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position getPosition() {
		return new Position(x, y);
	}
	
	
}
