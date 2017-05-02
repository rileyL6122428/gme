package l2kstudios.gme.model.grid;

public class SelectionManager {
	
	private Grid playingGrid;
	private Grid actionMenu;
	private Grid selectedGrid;
	
	public SelectionManager(PlayingGrid playingGrid, ActionMenu actionMenu) {
		this.playingGrid = playingGrid;
		this.actionMenu = actionMenu;
		this.selectedGrid = playingGrid;
	}
	
	public void makeSelection() {
		selectedGrid.select();
	}
}
