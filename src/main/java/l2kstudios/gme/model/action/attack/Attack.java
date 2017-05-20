package l2kstudios.gme.model.action.attack;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.rangeofeffect.Delta;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;

public class Attack extends Action {
	
	protected List<Delta> rangeOfEffect;
	
	protected Range<Integer> executionRange;
	
	protected int baseDamage;
	
	public Attack(Unit executingUnit) {
		super(executingUnit);
	}
	
	public Range<Integer> getRange() {
		return executionRange;
	}
	
	public boolean executeAt(Position position) {
		if(outOfRange(position)) return false;
		
		affectedSpaces(position).forEach((space) -> {
			if(space.isOccupied()){
				Unit occupier = (Unit)space.getOccupier();
				occupier.setRemainingHealth(occupier.getRemainingHealth() - inflictedDamage(occupier));
			}
		});
		
		return true;
	}
	
	private boolean outOfRange(Position position) {
		int distanceToExecution = GridUtils.distanceBetween(position, executingUnit.getPosition());
		return !executionRange.contains(distanceToExecution);
	}
	
	private long inflictedDamage(Unit occupier) {
		return baseDamage + executingUnit.getAttack() - occupier.getDefence();
	}
	
	
	private List<Space> affectedSpaces(Position positionOfExecution) {
		final List<Space> affectedSpaces = new ArrayList<Space>();
		final PlayingGrid playingGrid = GameModelService.getCurrentPlayingGrid(); 
		
		rangeOfEffect.forEach((delta) -> {
			int x = positionOfExecution.getX() - delta.getX(); 
			int y = positionOfExecution.getY() - delta.getY();
			
			
			if(playingGrid.isInBounds(x, y)) 
				affectedSpaces.add(playingGrid.getSpaceAt(x, y));
		});
		
		return affectedSpaces;
	}
	
	
}
