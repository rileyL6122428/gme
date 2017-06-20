package l2kstudios.gme.beandefs.demolevel;

import l2kstudios.gme.model.grid.SpacesFactory;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;

public class DemoPlayingGrid extends PlayingGrid {
	
	{
		setSpaces(SpacesFactory.emptyPlayingGridSpaces(7, 8));
		
		getSpaceAt(1, 1).setOccupiable(false);
		getSpaceAt(4, 0).setOccupiable(false);
		
		new Asbel().place(getSpaceAt(4, 4));
		new Richard().place(getSpaceAt(6, 6));
	}
}
