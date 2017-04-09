package l2kstudios.gme.level;

public class Grid {
	private Cursor cursor;
	private int width, height;
	
	public Grid() {
		this.cursor = new Cursor();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Position getCursorPosition() {
		return cursor.getPosition();
	}
}
