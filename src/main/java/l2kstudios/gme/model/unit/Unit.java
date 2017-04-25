package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;

import static l2kstudios.gme.model.unit.Unit.BoardState.*; 

public class Unit implements Placeable {
	
	public enum BoardState {
		STAND_BY, ACTING, AWAINTING_NEXT_TURN
	}
	
	public enum Team {
		ALLY, ENEMY
	}
	
	public Unit() {
		actions = new ArrayList<Action>();
		actions.add(new WaitAction(this));	
	}

	private String name;
	private Position position;
	private Team team;
	
	private long speed;
	private ConsummableStat health;
	private ConsummableStat energy;
	
	private List<Action> actions;
	
	private BoardState boardState = STAND_BY;
	
	
	public boolean canMoveTo(Position position) {
		return GridUtils.distanceBetween(position, this.position) <= getEnergy().getVal();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
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
		this.boardState = ACTING;
	}
	
	public void registerTurnEnd() {
		this.boardState = STAND_BY;
	}
	
	public boolean stillMoving() {
		return boardState != STAND_BY;
	}

	public List<Action> getActions() {
		return actions;
	}
	
}
