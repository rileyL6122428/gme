package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnFactory;

public class Level implements Interactable, InitializingBean {
	
	private PlayingGrid playingGrid;
	
	private Turn currentTurn;
	
	private MovementCycle movementCycle;

	@Override
	public void receiveInput(Input input) {
		currentTurn.receiveInput(input);
		
		if(currentTurn.isFinished()) {
			currentTurn.commit();
			movementCycle.shift();
			currentTurn = TurnFactory.newTurn(movementCycle.getActingUnit(), playingGrid);			
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		movementCycle = new MovementCycle(playingGrid.getUnits());		
		currentTurn = TurnFactory.newTurn(movementCycle.getActingUnit(), playingGrid);
	}
	
	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}
	
	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}
	
	public MovementCycle getMovementCycle() {
		return movementCycle;
	}
	
	public ActionInterface getCurrentActionInterface() {
		return currentTurn.getCurrentActionInterface();
	}
	
	public Turn getCurrentTurn() {
		return currentTurn;
	}

	public Space getActingUnitMoveToSpace() {
		Space targetSpace = currentTurn.getTransaction().getTargetSpace();
		return (targetSpace == null) ? movementCycle.getActingUnit().getOccupiedSpace() : targetSpace;
	}
}
