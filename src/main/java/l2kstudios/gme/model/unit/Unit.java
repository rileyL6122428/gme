package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.action.postmove.AttackDecision;
import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.action.postmove.WaitDecision;
import l2kstudios.gme.model.action.postmove.attack.Attack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttackWithRange;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;

public class Unit extends Placeable implements InitializingBean {
	
	public enum Team {
		ALLY, ENEMY
	}
	
	public Unit() {
		actionClasses = new HashMap<Class, List<Class>>();
		
		postMoveDecisions = new ArrayList<Class>();
		postMoveDecisions.add(AttackDecision.class);
		postMoveDecisions.add(WaitDecision.class);	
		
		List<Class> attackTypes = new ArrayList<Class>();
		attackTypes.add(BasicAttack.class);
		attackTypes.add(BasicAttackWithRange.class);
		actionClasses.put(Attack.class, attackTypes);
	}

	private String name;
	private Team team;
	
	private long speed;
	private ConsummableStat health;
	private ConsummableStat energy;
	
	private List<Class> postMoveDecisions;
	
	private Map<Class, List<Class>> actionClasses;
	
	public boolean canMoveTo(Space space) {
		Position position = space.getPosition();
		return (!space.isOccupied() || space.getOccupier() == this) && 
				GridUtils.distanceBetween(position, getPosition()) <= getEnergy().getVal();
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
	
	public void setRemainingHealth(long remainingHealth) {
		health.setVal(remainingHealth);
	}
	
	public long getRemainingHealth() {
		return health.getVal();
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

	public int getAttack() {
		return 1;
	}

	public int getDefence() {
		return 1;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Class> getActionTypes(Class actionType) {
		return actionClasses.get(actionType);
	}
	
}
