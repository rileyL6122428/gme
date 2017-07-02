package l2kstudios.gme.beandefs.demolevel;

import static l2kstudios.gme.model.unit.Unit.Team.ENEMY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import l2kstudios.gme.model.action.postmove.AttackDecision;
import l2kstudios.gme.model.action.postmove.WaitDecision;
import l2kstudios.gme.model.action.postmove.attack.Attack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttack;
import l2kstudios.gme.model.action.wait.BasicWait;
import l2kstudios.gme.model.action.wait.Wait;
import l2kstudios.gme.model.unit.BasicConciousness;
import l2kstudios.gme.model.unit.ComputerControlledUnit;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;

public class StockPhysicalBaddy extends ComputerControlledUnit {

	{
		
		name = "Phys Fighter";
		team = ENEMY;
		
		
		speed = 2;
		
		health = new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}};
		
		energy = new ConsummableStat(){{
			setCap(2);
			setVal(2);
		}};
		
		postMoveDecisions = new ArrayList<Class>();
		postMoveDecisions.add(AttackDecision.class);
		postMoveDecisions.add(WaitDecision.class);
		
		actionClasses = new HashMap<Class, List<Class>>();
		
		actionClasses.put(Attack.class, new ArrayList<Class>(){{
			add(BasicAttack.class);
		}});
		
		actionClasses.put(Wait.class, new ArrayList<Class>(){{
			add(BasicWait.class);
		}});
		
		Unit self = this;
		conciousness = new BasicConciousness(){{
			setUnit(self);
		}};
	}
	
}
