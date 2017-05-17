package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.attack.Attack;
import l2kstudios.gme.model.action.attack.BasicAttack;
import l2kstudios.gme.model.action.postmove.AttackAction;
import l2kstudios.gme.model.action.postmove.WaitAction;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Placeable;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;

import static l2kstudios.gme.model.unit.Unit.BoardState.*; 

public class Unit extends Placeable implements InitializingBean {
	
	public enum BoardState {
		STAND_BY, MOVING, CHOOSING_ACTION, ACTING, CHOOSING_ATTACK, AWAINTING_NEXT_TURN
	}
	
	public enum Team {
		ALLY, ENEMY
	}
	
	public Unit() {
		postMoveActions = new ArrayList<Action>();
		postMoveActions.add(new AttackAction(this));
		postMoveActions.add(new WaitAction(this));	
		
		attacks = new ArrayList<Attack>();
		attacks.add(new BasicAttack(this));
	}

	private String name;
	private Team team;
	
	private long speed;
	private ConsummableStat health;
	private ConsummableStat energy;
	
	private List<Action> postMoveActions;
	
	private List<Attack> attacks;
	
	private BoardState boardState = STAND_BY;
	
	public boolean canMoveTo(Space space) {
		Position position = space.getPosition();
		return !space.isOccupied() && GridUtils.distanceBetween(position, getPosition()) <= getEnergy().getVal();
	}
	
	public void endTurn() {
		postMoveActions.get(postMoveActions.size() - 1).execute();
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
		boardState = CHOOSING_ACTION;
	}
	
	public void registerTurnStart() {
		this.boardState = MOVING;
	}
	
	public void registerTurnEnd() {
		this.boardState = STAND_BY;
	}
	
	public void registerChoosingAttack() {
		this.boardState = CHOOSING_ATTACK;
	}
	
	public boolean isInBoardState(BoardState state) {
		return this.boardState == state;
	}
	
	public boolean turnOver() {
		return boardState == STAND_BY;
	}

	public List<Action> getPostMoveActions() {
		return postMoveActions;
	}

	public void setPostMoveActions(List<Action> actions) {
		this.postMoveActions = actions;
	}

	public int getAttack() {
		return 1;
	}

	public int getDefence() {
		return 1;
	}

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
