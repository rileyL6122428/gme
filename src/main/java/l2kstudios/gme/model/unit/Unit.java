package l2kstudios.gme.model.unit;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridPlaceable;

public class Unit extends PlayingGridPlaceable implements InitializingBean {
	
	public enum Team {
		ALLY, ENEMY
	}

	protected String name;
	protected Team team;
	
	protected long speed;
	
	protected long strength;
	protected long defense;
	
	private long magic;
	private long magicDefense;
	
	protected ConsummableStat health;
	protected ConsummableStat energy;
	
	protected List<Class> postMoveDecisions;
	
	protected Map<Class, List<Class>> actionClasses;
	
	public boolean isDefeated() {
		return getRemainingHealth() <= 0;
	}
	
	public boolean isAlliedUnit() {
		return team == Team.ALLY;
	}
	
	public boolean isEnemyUnit() {
		return team == Team.ENEMY;
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
	

	public ConsummableStat getHealth() {
		return health;
	}

	public void setHealth(ConsummableStat health) {
		this.health = health;
	}
	
	public void setRemainingHealth(long remainingHealth) {
		health.setVal(remainingHealth);
	}
	
	public long getRemainingHealth() {
		return health.getVal();
	}

	public long getRemainingEnergy() {
		return energy.getVal();
	}
	
	public ConsummableStat getEnergy() {
		return energy;
	}

	public void setEnergy(ConsummableStat energy) {
		this.energy = energy;
	}
	
	public void moveTo(Space space) {
		occupiedSpace.setOccupier(null);
		place(space);
	}

	public List<Class> getPostMoveDecisions() {
		return postMoveDecisions;
	}

	public long getStrength() {
		return strength;
	}
	
	public void setStrength(long strength) {
		this.strength = strength;
	}

	public long getDefense() {
		return defense;
	}
	
	public void setDefense(long defense) {
		this.defense = defense;
	}

	public long getMagic() {
		return magic;
	}

	public void setMagic(long magic) {
		this.magic = magic;
	}

	public long getMagicDefense() {
		return magicDefense;
	}

	public void setMagicDefense(long magicDefense) {
		this.magicDefense = magicDefense;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Class> getActionTypes(Class actionType) {
		return actionClasses.get(actionType);
	}

	public String toString() {
		return "Unit \n" + 
				"name = " + name + "\n" +
				"speed = " + speed + "\n";
	}
}
