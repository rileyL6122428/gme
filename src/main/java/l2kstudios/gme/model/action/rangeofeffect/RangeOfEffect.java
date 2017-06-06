package l2kstudios.gme.model.action.rangeofeffect;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;

public class RangeOfEffect {
	
	protected List<Delta> deltas;
	private PlayingGrid playingGrid;
	
	public RangeOfEffect(){}
	
	public RangeOfEffect(PlayingGrid playingGrid) {
		this.setPlayingGrid(playingGrid);
	}
	
	public List<Space> affectedSpaces(Position positionOfExecution) {
		final List<Space> affectedSpaces = new ArrayList<Space>();
		
		deltas.forEach((delta) -> {
			int x = positionOfExecution.getX() - delta.getX(); 
			int y = positionOfExecution.getY() - delta.getY();
			
			
			if(playingGrid.isInBounds(x, y)) 
				affectedSpaces.add(playingGrid.getSpaceAt(x, y));
		});
		
		return affectedSpaces;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
}
