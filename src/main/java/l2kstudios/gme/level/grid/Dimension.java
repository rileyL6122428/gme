package l2kstudios.gme.level.grid;

import l2kstudios.gme.level.Position;

public class Dimension {
	
	private int width;
	private int height;
	
	public Dimension() {}
	
	public Dimension(int width, int height) {
		this.width = width;
		this.height = height;
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
	
	public boolean isInBounds(Position position) {
		return position.getX() < width && position.getX() >= 0
				&& position.getY() < height && position.getY() >= 0;
	}
}
