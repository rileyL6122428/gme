package l2kstudios.gme.testutils;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;

public class SpacesFactory {
	
	static public List<List<Space>> emptyPlayingGridSpaces(int width, int height) {
		List<List<Space>> spaces = new ArrayList<List<Space>>();
		
		for(int heightIdx = 0; heightIdx < height; heightIdx++)
			spaces.add(newPlayingGridRow(width));
		
		return spaces;
	}
	
	static public List<Space> newPlayingGridRow(int width) {
		List<Space> row = new ArrayList<Space>();
		
		for(int widthIdx = 0; widthIdx < width; widthIdx++) {
			row.add(new PlayingGridSpace(){{
				setOccupiable(true);
			}});
		}
		
		return row;
	}
}
