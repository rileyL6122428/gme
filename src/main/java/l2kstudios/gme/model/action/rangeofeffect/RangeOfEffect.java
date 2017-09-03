package l2kstudios.gme.model.action.rangeofeffect;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.position.Position;
import l2kstudios.gme.model.unit.Unit;

public class RangeOfEffect {
	
	protected List<Delta> deltas;
	protected Unit executingUnit; 
	protected PlayingGrid playingGrid;
	
	public RangeOfEffect(){}
	
	public RangeOfEffect(PlayingGrid playingGrid) {
		this.setPlayingGrid(playingGrid);
	}
	
	public List<Space> affectedSpaces(Position positionOfExecution) {
		final List<Space> affectedSpaces = new ArrayList<Space>();
		
		deltas.forEach((delta) -> {
			int x = positionOfExecution.getX() + delta.getX(); 
			int y = positionOfExecution.getY() + delta.getY();
			
			
			if(playingGrid.isInBounds(x, y)) 
				affectedSpaces.add(playingGrid.getSpaceAt(x, y));
		});
		
		return affectedSpaces;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public Unit getExecutingUnit() {
		return executingUnit;
	}

	public void setExecutingUnit(Unit executingUnit) {
		this.executingUnit = executingUnit;
	}
	
}
