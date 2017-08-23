package l2kstudios.gme.model.level;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.turn.TurnPhaseSequence;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.gameinterface.turn.TurnFactory;

public class Level implements InitializingBean {
	
	private PlayingGrid playingGrid;
	
	private Turn currentTurn;
	
	private MovementCycle movementCycle;
	
	private BooleanSupplier victoryCondition;
	private BooleanSupplier loseCondition;

	public void commitTurn() {	
		currentTurn.commitActions();
		clearOutDefeatedUnits();
		movementCycle.shift();
		playingGrid.setCursorPosition(movementCycle.getActingUnit().getPosition());
		currentTurn = TurnFactory.newTurn(this);			
	}

	private void clearOutDefeatedUnits() {
		for(Unit unit : playingGrid.getUnits()) {
			if(unit.isDefeated()) {
				playingGrid.clearSpace(unit.getPosition());
				movementCycle.rebase(playingGrid.getUnits());
				System.out.println("Defeated unit: " + unit.toString());
			}
		}	
	}
	
	public boolean turnIsFinished() {
		return currentTurn.isFinished();
	}

	public boolean currentTurnIsComputerControlled() {
		return getActingUnit().isEnemyUnit();
	}
	
	public boolean isFinished() {
		return victoryCondition.getAsBoolean() || loseCondition.getAsBoolean();
	}
	
	public boolean isWon() {
		return victoryCondition.getAsBoolean();
	}
	
	public boolean isLost() {
		return loseCondition.getAsBoolean();
	}
	
	@Override
	public void afterPropertiesSet() {
		movementCycle = new MovementCycle(playingGrid.getUnits());
		playingGrid.setCursorPosition(movementCycle.getActingUnit().getPosition());
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
	
	public List<Unit> getUnits() {
		return playingGrid.getUnits();
	}

	public BooleanSupplier getVictoryCondition() {
		return victoryCondition;
	}

	public void setVictoryCondition(BooleanSupplier victoryCondition) {
		this.victoryCondition = victoryCondition;
	}

	public BooleanSupplier getLoseCondition() {
		return loseCondition;
	}

	public void setLoseCondition(BooleanSupplier loseCondition) {
		this.loseCondition = loseCondition;
	}

}
