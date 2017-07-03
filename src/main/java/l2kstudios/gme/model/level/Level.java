package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.turn.ComputerControlledTurn;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnFactory;
import l2kstudios.gme.model.unit.Unit;

public class Level implements Interactable, InitializingBean {
	
	private PlayingGrid playingGrid;
	
	private Turn currentTurn;
	
	private MovementCycle movementCycle;
	
	public void update() {
		currentTurn.update();
		if(currentTurn.readyToCommit()) {
			commitTurn();			
		}
	}

	@Override
	public void receiveInput(Input input) {
		currentTurn.receiveInput(input);
		
		if(currentTurn.readyToCommit()) {
			commitTurn();			
		}
		
		while(currentTurn instanceof ComputerControlledTurn) {
			finishComputerControlledTurn();
		}
		
	}
	
	private void finishComputerControlledTurn() {
		while(!currentTurn.readyToCommit()) {
			currentTurn.update();			
		}
		
		commitTurn();
	}

	private void commitTurn() {	
		currentTurn.commit();
		clearOutDefeatedUnits();
		movementCycle.shift();
		currentTurn = TurnFactory.newTurn(movementCycle.getActingUnit(), playingGrid);			
	}

	private boolean finished() {
		return playingGrid.getAlliedUnits().size() == 0 ||
				playingGrid.getEnemyUnits().size() == 0;
	}

	private void clearOutDefeatedUnits() {
		for(Unit unit : playingGrid.getUnits()) {
			if(unit.isDefeated()) {
				playingGrid.clearSpace(unit.getPosition());
				movementCycle.rebase(playingGrid.getUnits());
				System.out.println("Defeated unit" + unit.toString());
			}
		}	
	}
	
	public boolean turnIsOver(Turn turn) {
		return currentTurn != turn;
	}

	@Override
	public void afterPropertiesSet() {
		
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
	
	public Turn getCurrentTurn() {
		return currentTurn;
	}

}
