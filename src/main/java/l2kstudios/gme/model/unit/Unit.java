package l2kstudios.gme.model.unit;

import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;

public class Unit implements Placeable {
	
	public enum Team {
		ALLY, ENEMY
	}

	private String name;
	private Position position;
	private Team team;
	
	private long speed;
	private ConsummableStat health;
	private ConsummableStat energy;
	
	
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


}
