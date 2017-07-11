package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridPlaceable;
import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class Unit extends PlayingGridPlaceable implements InitializingBean {
	
	public enum Team {
		ALLY, ENEMY
	}
	
	public enum StatType {
		HEALTH,
		MOMENTUM,
		STRENGTH,
		PHYSICAL_DEFENSE,
		MAGIC,
		MAGICAL_DEFENSE,
		MOVEMENT,
		SPEED,
		INTELLIGENCE,
		SKILL
	}
	
	static final public List<StatType> UNIT_STAT_TYPES;
	
	static {
		UNIT_STAT_TYPES = new ArrayList<StatType>(){{
			add(HEALTH);
			add(MOMENTUM);
			add(STRENGTH);
			add(PHYSICAL_DEFENSE);
			add(MAGIC);
			add(MAGICAL_DEFENSE);
			add(MOVEMENT);
			add(SPEED);
			add(INTELLIGENCE);
			add(SKILL);
		}};
	}

	protected String name;
	protected Team team;
	
	protected Map<StatType, Stat> stats;
	
	protected List<Class> postMoveDecisions;
	
	protected Map<Class, List<Class>> actionClasses;

	public Unit() {
		stats = new HashMap<StatType, Stat>(){{
			UNIT_STAT_TYPES.forEach( (statType)->put(statType, new Stat()) );
		}};
	}
	
	public void moveTo(Space space) {
		occupiedSpace.setOccupier(null);
		place(space);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isDefeated() {
		return get(HEALTH) <= 0;
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

	public List<Class> getPostMoveDecisions() {
		return postMoveDecisions;
	}

	public List<Class> getActionTypes(Class actionType) {
		return actionClasses.get(actionType);
	}
	
	public long get(StatType statType) {
		return this.stats.get(statType).getVal();
	}
	
	public void increaseStat(StatType statType, long amount) {
		this.stats.get(statType).increaseVal(amount);
	}
	
	public void decreaseStat(StatType statType, long amount) {
		this.stats.get(statType).decreaseVal(amount);
	}
	
	public Stat getStat(StatType statType) {
		return this.stats.get(statType);
	}
	
	public void setStat(StatType statType, Stat stat) {
		this.stats.put(statType, stat);
	}

	@Override
	public void afterPropertiesSet() { }

	public String toString() {
		return "Unit \n" + 
				"name = " + name + "\n" +
				"speed = " + get(SPEED) + "\n";
	}
}
