package l2kstudios.gme.model.action.rangeofeffect;

import java.util.ArrayList;

public class Line extends RangeOfEffect {
	
	public Line(int lineLength) {
		deltas = new ArrayList<Delta>();
		
		for(int lineIdx = 1; lineIdx <= lineLength; lineIdx++) {
			deltas.add(new Delta(lineIdx, 0));
		}
	}
	
}
