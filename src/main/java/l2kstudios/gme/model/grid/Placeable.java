package l2kstudios.gme.model.grid;

public class Placeable {
	
	protected Space occupiedSpace;
	
	public void place(Space space) {
		occupiedSpace = space;
		occupiedSpace.setOccupier(this);
	}
	
	public Space getOccupiedSpace() {
		return occupiedSpace;
	}
}
