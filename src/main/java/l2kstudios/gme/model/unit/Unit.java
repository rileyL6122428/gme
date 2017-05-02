package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;

import static l2kstudios.gme.model.unit.Unit.BoardState.*; 

public class Unit implements Placeable {
	
	public enum BoardState {
		STAND_BY, MOVING, CHOOSING_ACTION, ACTING, AWAINTING_NEXT_TURN
	}
	
	public enum Team {
		ALLY, ENEMY
	}
	
	public Unit() {
		actions = new ArrayList<Action>();
		actions.add(new WaitAction(this));	
	}

	private String name;
	private Team team;
	
	private long speed;
	private ConsummableStat health;
	private ConsummableStat energy;
	
	private List<Action> actions;
	
	private BoardState boardState = STAND_BY;
	private Space occupiedSpace;
	
	
	public boolean canMoveTo(Space space) {
		Position position = space.getPosition();
		return !space.isOccupied() && GridUtils.distanceBetween(position, getPosition()) <= getEnergy().getVal();
	}

	public Position getPosition() {
		return occupiedSpace.getPosition();
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Unit: " + name;
	}

	public ConsummableStat getHealth() {
		return health;
	}

	public void setHealth(ConsummableStat health) {
		this.health = health;
	}

	public ConsummableStat getEnergy() {
		return energy;
	}

	public void setEnergy(ConsummableStat energy) {
		this.energy = energy;
	}
	
	public void registerTurnStart() {
		this.boardState = MOVING;
	}
	
	public void moveTo(Space space) {
		occupiedSpace.setOccupier(null);
		place(space);
		boardState = CHOOSING_ACTION;
	}
	
	public void registerTurnEnd() {
		this.boardState = STAND_BY;
	}
	
	public boolean isInBoardState(BoardState state) {
		return this.boardState == state;
	}
	
	public boolean turnOver() {
		return boardState != STAND_BY;
	}

	public List<Action> getActions() {
		return actions;
	}

	@Override
	public void place(Space space) {
		occupiedSpace = space;
		occupiedSpace.setOccupier(this);
	}
	
}
