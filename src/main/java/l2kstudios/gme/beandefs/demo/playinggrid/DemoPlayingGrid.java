package l2kstudios.gme.beandefs.demo.playinggrid;

import l2kstudios.gme.beandefs.demo.asbel.Asbel;
import l2kstudios.gme.beandefs.demo.richard.Richard;
import l2kstudios.gme.beandefs.demo.sophie.Sophie;
import l2kstudios.gme.model.grid.BoundedCursor;
import l2kstudios.gme.model.grid.SpacesFactory;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;

public class DemoPlayingGrid extends PlayingGrid {
	
	{
		cursor = new BoundedCursor(15, 7);
		
		setSpaces(SpacesFactory.emptyPlayingGridSpaces(15, 7));
		
		getSpaceAt(0, 4).setOccupiable(false);
		getSpaceAt(0, 5).setOccupiable(false);
		
		getSpaceAt(3, 4).setOccupiable(false);
		
		getSpaceAt(4, 0).setOccupiable(false);
		getSpaceAt(4, 4).setOccupiable(false);
		
		getSpaceAt(5, 4).setOccupiable(false);
		
		getSpaceAt(6, 0).setOccupiable(false);
		getSpaceAt(6, 4).setOccupiable(false);
		
		getSpaceAt(7, 0).setOccupiable(false);
		getSpaceAt(7, 4).setOccupiable(false);
		
		getSpaceAt(8, 0).setOccupiable(false);
		getSpaceAt(8, 4).setOccupiable(false);
		
		getSpaceAt(9, 4).setOccupiable(false);
		
		getSpaceAt(10, 0).setOccupiable(false);

		getSpaceAt(11, 0).setOccupiable(false);
		
		getSpaceAt(12, 0).setOccupiable(false);
		getSpaceAt(12, 1).setOccupiable(false);
		
		getSpaceAt(13, 0).setOccupiable(false);
		
		getSpaceAt(14, 0).setOccupiable(false);
		getSpaceAt(14, 1).setOccupiable(false);
		
		
		
		new Sophie().place(getSpaceAt(14, 4));
		new Asbel().place(getSpaceAt(13, 4));
		
		new Richard().place(getSpaceAt(0, 0));
		
	}
}
