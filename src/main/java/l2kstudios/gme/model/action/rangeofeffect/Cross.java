package l2kstudios.gme.model.action.rangeofeffect;

import java.util.ArrayList;

public class Cross extends RangeOfEffect {
	
	public Cross(int limbLength) {
		deltas = new ArrayList<Delta>();
		
		deltas.add(new Delta(0,0));
		
		for(int limbIdx = 1; limbIdx <= limbLength; limbIdx++) {
			deltas.add(new Delta(limbIdx, 0));
			deltas.add(new Delta(-limbIdx, 0));
			deltas.add(new Delta(0, limbIdx));
			deltas.add(new Delta(0, -limbIdx));
		}
	}
	
}
