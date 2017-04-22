package l2kstudios.gme.level;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.level.grid.GridUtils;
import l2kstudios.gme.level.grid.Placeable;

public class Unit implements Placeable, InitializingBean {
	
	public enum Team {
		ALLY, ENEMY
	}

	private long speed;
	
	private long healthCap;
	private long health;
	
	private long energyCap;
	private long energy;
	
	private String name;
	private Position position;
	private Team team;
	
	public boolean canMoveTo(Position position) {
		return GridUtils.distanceBetween(position, this.position) <= energy;
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

	public long getEnergy() {
		return energy;
	}

	public void setEnergy(long energy) {
		this.energy = energy;
	}

	public long getEnergyCap() {
		return energyCap;
	}

	public void setEnergyCap(long energyCap) {
		this.energyCap = energyCap;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		energy = energyCap;
		health = healthCap;
		
	}

	public long getHealthCap() {
		return healthCap;
	}

	public void setHealthCap(long healthPointsCap) {
		this.healthCap = healthPointsCap;
	}

	public long getHealth() {
		return health;
	}

	public void setHealth(long healthPoints) {
		this.health = healthPoints;
	}
}
