package l2kstudios.gme.model.grid.playinggrid;

import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.position.Position;

public class PlayingGridPlaceable extends Placeable {
	
	public void place(PlayingGridSpace space) {
		occupiedSpace = space;
		occupiedSpace.setOccupier(this);
	}
	
	public void setOccupiedSpace(PlayingGridSpace occupiedSpace) {
		this.occupiedSpace = occupiedSpace;
	}
	
	public PlayingGridSpace getOccupiedSpace() {
		return (PlayingGridSpace)occupiedSpace;
	}
	
	public Position getPosition() {
		return occupiedSpace.getPosition();
	}
	
}
