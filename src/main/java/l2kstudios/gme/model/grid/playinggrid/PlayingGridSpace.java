package l2kstudios.gme.model.grid.playinggrid;

import java.util.List;
import java.util.stream.Collectors;

import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.model.unit.Unit.Team;

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
		return getAdjacentSpaces()
				.stream()
				.map(space -> (PlayingGridSpace) space)
				.collect(Collectors.toList());
	}

	public boolean isOccupiedByMemberOfOppositeTeam(Team team) {
		return isOccupied() && 
				getOccupier() instanceof Unit &&
				((Unit) getOccupier()).getTeam() != team;
	}
	
	public boolean canBeTraversedBy(Unit unit) {
		return occupiable && (!isOccupied() || !isOccupiedByMemberOfOppositeTeam(unit.getTeam()));
	}
	
}
