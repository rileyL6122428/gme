package l2kstudios.gme.model.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import l2kstudios.gme.model.unit.Unit;

public class PlayingGrid extends RectangularGrid {
	
	public List<Unit> getUnits() {
		List<Unit> units = new ArrayList<Unit>();
		
		//TODO DELTE COMMENTED CODE BELOW
//		for(List<Space> row : spaces) {
//			for(Space space : row) {
//				if(space.isOccupied()) units.add((Unit) space.getOccupier());
//			}
//		}
		
		forEachSpace((Space space) -> {
			if(space.isOccupied()) units.add((Unit) space.getOccupier());
		});
		
		return units;
	}
	
	public Unit getUnitAt(int x, int y) {
		return (Unit)getSpaces().get(y).get(x).getOccupier();
	}
	
	public Space getSpaceAt(int x, int y) {
		return getSpaces().get(y).get(x);
	}
	
	public void forEachSpace(Consumer<Space> consumer) {
		for(List<Space> row : spaces) {
			for(Space space : row) {
				consumer.accept(space);
			}
		}
	}
}
