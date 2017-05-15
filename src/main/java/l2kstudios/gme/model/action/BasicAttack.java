package l2kstudios.gme.model.action;

import java.util.ArrayList;

import com.google.common.collect.Range;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Delta;
import l2kstudios.gme.model.unit.Unit;

public class BasicAttack extends Attack {
	
	{
		name = "Basic Attack";
		
		range = Range.closed(1, 1);
		
		affectedSpaces = new ArrayList<Delta>(){{
			add(new Delta(0, 0));
		}};
		
		baseDamage = 1;
	}
	
	public BasicAttack(Unit executingUnit, PlayingGrid playingGrid) {
		super(executingUnit, playingGrid);
	}
	
}
