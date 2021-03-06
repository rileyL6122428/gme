package l2kstudios.gme.model.grid;

public class Cursor {
	
	protected Position position;

	public Position getPosition() {
		return position;
	}
	
	public int getY() {
		return position.getY();
	}
	
	public int getX() {
		return position.getX();
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void setPosition(Space space) {
		this.position = space.getPosition();
	}
	
	public void incrementPosition(int deltaX, int deltaY) {
		position = Position.fromCached(position.getX() + deltaX, position.getY() + deltaY);
	}
	
}
