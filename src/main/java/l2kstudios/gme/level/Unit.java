package l2kstudios.gme.level;

import l2kstudios.gme.level.grid.Placeable;

public class Unit implements Placeable {
	
	public enum Team {
		ALLY, ENEMY
	}
	
	private Position position;
	private Team team;

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
}