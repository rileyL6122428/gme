package l2kstudios.gme.model.grid;

import l2kstudios.gme.model.grid.position.Position;

public class Placeable {
	
	protected Space occupiedSpace;
	
	public void place(Space space) {
		occupiedSpace = space;
		occupiedSpace.setOccupier(this);
	}
	
	public void setOccupiedSpace(Space occupiedSpace) {
		this.occupiedSpace = occupiedSpace;
	}
	
	public Space getOccupiedSpace() {
		return occupiedSpace;
	}
	
	public Position getPosition() {
		return occupiedSpace.getPosition();
	}
}
