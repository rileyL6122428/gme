package l2kstudios.gme.model.action;

import java.util.List;

import com.google.common.collect.Range;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Delta;
import l2kstudios.gme.model.unit.Unit;

public class Attack extends Action {
	
	protected Unit executingUnit;
	
	protected PlayingGrid playingGrid;
	
	protected List<Delta> affectedSpaces;
	
	protected Range<Integer> range;
	
	protected int baseDamage;
	
	public Attack(Unit executingUnit, PlayingGrid playingGrid) {
		this.executingUnit = executingUnit;
		this.playingGrid = playingGrid;
	}
	
	//INTERFACE
	
	public boolean executeAt(Position position) {
		return false;
	}
	
	
}
