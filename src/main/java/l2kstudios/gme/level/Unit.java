package l2kstudios.gme.level;

public class Unit {
	
	enum Team {
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
