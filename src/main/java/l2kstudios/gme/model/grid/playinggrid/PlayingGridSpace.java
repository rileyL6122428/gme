package l2kstudios.gme.model.grid.playinggrid;

import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Space;

public class PlayingGridSpace extends Space {
	
	private boolean occupiable = true;
	
	public void setOccupier(Placeable placeable) {
		if(occupiable) 
			super.setOccupier(placeable);
	}

	public boolean isOccupiable() {
		return occupiable;
	}

	public void setOccupiable(boolean occupiable) {
		this.occupiable = occupiable;
	}
	
}
