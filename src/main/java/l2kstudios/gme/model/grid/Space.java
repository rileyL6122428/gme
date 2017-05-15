package l2kstudios.gme.model.grid;

public class Space {
	
	private Placeable occupier;
	private TwoDimensionalGrid grid;
	
	public boolean isOccupied() {
		return occupier != null;
	}

	public Placeable getOccupier() {
		return occupier;
	}

	public void setOccupier(Placeable occupier) {
		this.occupier = occupier;
		
		if(occupier != null)
			occupier.setOccupiedSpace(this);
	}
	
	public Position getPosition() {
		return getGrid().positionOf(this);
	}

	public TwoDimensionalGrid getGrid() {
		return grid;
	}

	public void setGrid(TwoDimensionalGrid grid) {
		this.grid = grid;
	}
	
}
