package l2kstudios.gme.model.grid;

public class Space {
	
	private Placeable occupier;
	private Grid grid;
	
	public boolean isOccupied() {
		return occupier != null;
	}

	public Placeable getOccupier() {
		return occupier;
	}

	public void setOccupier(Placeable occupier) {
		this.occupier = occupier;
		occupier.place(this);
	}
	
	public Position getPosition() {
		return getGrid().positionOf(this);
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
}
