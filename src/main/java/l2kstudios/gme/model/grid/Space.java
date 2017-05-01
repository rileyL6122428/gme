package l2kstudios.gme.model.grid;

public class Space {
	
	private Placeable occupier;
	private PlayingGrid playingGrid;
	
	public Space(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
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
		return getPlayingGrid().positionOf(this);
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
}
