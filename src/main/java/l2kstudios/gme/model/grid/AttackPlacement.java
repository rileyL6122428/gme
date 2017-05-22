package l2kstudios.gme.model.grid;

import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.services.GameModelService;

public class AttackPlacement extends TwoDimensionalGrid {
		
	private Attack attack;
	private ActingUnitTracker actingUnitTracker;
	
	public void setAttackToPlace(Attack attack) {
		this.attack = attack;
		
		PlayingGrid playingGrid = GameModelService.getCurrentPlayingGrid();
		setSpaces(playingGrid.getSpaces());
	}
	
	public boolean select() {
		return attack.executeAt(hoveredSpace());
	}
	
	public void initialize() {
		Unit actingUnit = actingUnitTracker.getActingUnit();
		moveCursorTo(actingUnit.getPosition());
	}
	
	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
}
