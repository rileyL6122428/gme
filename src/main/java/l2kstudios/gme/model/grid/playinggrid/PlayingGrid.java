package l2kstudios.gme.model.grid.playinggrid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.RectangularGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGrid extends RectangularGrid {
	
	public List<Unit> getUnits() {
		List<Unit> units = new ArrayList<Unit>();
		
		forEachSpace((space) -> {
			if(space.isOccupied() && space.getOccupier() instanceof Unit) 
				units.add((Unit) space.getOccupier());
		});
		
		return units;
	}
	
	public List<Unit> getEnemyUnits() {
		return getUnits().stream()
						 .filter(Unit::isEnemyUnit)
						 .collect(Collectors.toList());
	}
	
	public List<Unit> getAlliedUnits() {
		return getUnits().stream()
						 .filter(Unit::isAlliedUnit)
						 .collect(Collectors.toList());
	}
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)getSpaces().get(y).get(x).getOccupier();
	}
	
	public PlayingGridSpace getSpaceAt(int x, int y) {
		return (PlayingGridSpace)getSpaces().get(y).get(x);
	}
	
	public void forEachSpace(Consumer<PlayingGridSpace> consumer) {
		for(List<Space> row : spaces) {
			for(Space space : row) {
				consumer.accept((PlayingGridSpace)space);
			}
		}
	}
	
	public void clearSpace(Position position) {
		getSpaceAt(position).setOccupier(null);
	}
	
	public void setSpaces(List<List<Space>> spaces) {
		validateSpacesArePlayingGridSpaces(spaces);
		super.setSpaces(spaces);
	}

	private void validateSpacesArePlayingGridSpaces(List<List<Space>> spaces) {
		spaces.forEach(this::validateRowContainsPlayingGridSpaces);
	}
	
	private void validateRowContainsPlayingGridSpaces(List<Space> row) {
		row.forEach((space) -> {
			if(!(space instanceof PlayingGridSpace)) 
				throw new RuntimeException("ONLY PLAYING GRID SPACES CAN BE PLUGGED INTO A PLAYING GRID");
		});
	}
}
