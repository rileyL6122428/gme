package l2kstudios.gme.level;

import l2kstudios.gme.level.grid.Placeable;

public class Unit implements Placeable {
	
	public enum Team {
		ALLY, ENEMY
	}

	private long speed;
	private long endurance;
	private String name;
	private Position position;
	private Team team;
	
	public boolean canMoveTo(Position position) {
		int distance = Math.abs(position.getX() - this.position.getX()) + Math.abs(position.getY() - this.position.getY());
		return distance <= endurance;
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

	public long getEndurance() {
		return endurance;
	}

	public void setEndurance(long endurance) {
		this.endurance = endurance;
	}
}
