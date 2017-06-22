package l2kstudios.gme.model.grid.playinggrid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;
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
	
	public List<PlayingGridSpace> getAdjacentPlayingGridSpaces() {
//		List<PlayingGridSpace> castedList;
		
		
//		return castedList;
		return getAdjacentSpaces()
				.stream()
				.map(space -> (PlayingGridSpace) space)
				.collect(Collectors.toList());
	}
	
}
