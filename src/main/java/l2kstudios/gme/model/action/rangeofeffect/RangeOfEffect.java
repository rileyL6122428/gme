package l2kstudios.gme.model.action.rangeofeffect;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.services.GameModelService;

public class RangeOfEffect {
	
	protected List<Delta> deltas;
	
	public List<Space> affectedSpaces(Position positionOfExecution) {
		final List<Space> affectedSpaces = new ArrayList<Space>();
		final PlayingGrid playingGrid = GameModelService.getCurrentPlayingGrid(); 
		
		deltas.forEach((delta) -> {
			int x = positionOfExecution.getX() - delta.getX(); 
			int y = positionOfExecution.getY() - delta.getY();
			
			
			if(playingGrid.isInBounds(x, y)) 
				affectedSpaces.add(playingGrid.getSpaceAt(x, y));
		});
		
		return affectedSpaces;
	}
	
}
