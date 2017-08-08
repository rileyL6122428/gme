package l2kstudios.gme.model.action;

import java.util.HashSet;
import java.util.Set;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;

public class ActionUtil {
	
	public static Set<PlayingGridSpace> chooseableSpaces(Action action, PlayingGrid playingGrid) {
		final Set<PlayingGridSpace> chooseableSpaces = new HashSet<PlayingGridSpace>();
		
		playingGrid.forEachSpace((space) -> {
			if(action.ableToExecuteAt(space))
				chooseableSpaces.add(space);
		});
		
		return chooseableSpaces;
	}
	
}
