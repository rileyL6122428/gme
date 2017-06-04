package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.action.postmove.AttackDecision;
import l2kstudios.gme.model.action.postmove.WaitDecision;
import l2kstudios.gme.model.action.postmove.attack.Attack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttackWithRange;
import l2kstudios.gme.model.action.wait.BasicWait;
import l2kstudios.gme.model.action.wait.Wait;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import processing.core.PImage;

public class Unit extends Placeable implements InitializingBean {
	
	public enum Team {
		ALLY, ENEMY
	}

	protected String name;
	protected Team team;
	
	protected long speed;
	protected long defense;
	protected long strength;
	protected ConsummableStat health;
	protected ConsummableStat energy;
	
	protected PImage image;
	
	protected List<Class> postMoveDecisions;
	
	protected Map<Class, List<Class>> actionClasses;
	
	public boolean canMoveTo(Space space) {
		Position position = space.getPosition();
		return (!space.isOccupied() || space.getOccupier() == this) && 
				GridUtils.distanceBetween(position, getPosition()) <= getEnergy().getVal();
	}
	
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

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Class> getActionTypes(Class actionType) {
		return actionClasses.get(actionType);
	}
	
	//FOR DEMO ONLY
	public PImage getImage() {
		return image;
	}

	public void setImage(PImage image) {
		this.image = image;
	}
	
	public float getScale() {
		return 1;
	}
	//END DEMO
	

	public String toString() {
		return "Unit \n" + 
				"name = " + name + "\n" +
				"speed = " + speed + "\n";
		
	}
}
