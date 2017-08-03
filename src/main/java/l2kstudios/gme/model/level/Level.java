package l2kstudios.gme.model.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.gameinterface.TurnFactory;

public class Level implements InitializingBean {
	
	private PlayingGrid playingGrid;
	
	private Turn currentTurn;
	
	private MovementCycle movementCycle;
	
	public void update() {
//		currentTurn.update();
//		if(currentTurn.readyToCommit()) {
//			commitTurn();			
//		}
	}

//	@Override
//	public void receiveInput(Input input) {
//		currentTurn.receiveInput(input);
//		
//		if(currentTurn.readyToCommit()) {
//			commitTurn();			
//		}
//		
//		while(currentTurn instanceof ComputerControlledTurn) {
//			finishComputerControlledTurn();
//		}
//		
//	}
	
//	private void finishComputerControlledTurn() {
//		while(!currentTurn.readyToCommit()) {
//			currentTurn.update();			
//		}
//		
//		commitTurn();
//	}

	public void commitTurn() {	
		currentTurn.commitActions();
		clearOutDefeatedUnits();
		movementCycle.shift();
		currentTurn = TurnFactory.newTurn(this);			
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
	
	public boolean turnIsFinished() {
		return currentTurn.isFinished();
	}

	@Override
	public void afterPropertiesSet() {
		movementCycle = new MovementCycle(playingGrid.getUnits());
		currentTurn = TurnFactory.newTurn(this);
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

	public TurnPhaseSequence getTurnPhases() {
		return currentTurn.getPhases();
	}

	public Unit getActingUnit() {
		return movementCycle.getActingUnit();
	}
}
