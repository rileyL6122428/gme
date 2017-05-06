package l2kstudios.gme.testutils;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.Space;

public class RowFactory {
	
	static public List<List<Space>> emptyGridSpaces(int width, int height) {
		List<List<Space>> spaces = new ArrayList<List<Space>>();
		
		for(int widthIdx = 0; widthIdx < width; widthIdx++) {
			spaces.add(new ArrayList<Space>());
			
			for(int heightIdx = 0; heightIdx < height; heightIdx++) {
				spaces.get(spaces.size() - 1).add(new Space());
			}
		}
		
		return spaces;
	}
}
