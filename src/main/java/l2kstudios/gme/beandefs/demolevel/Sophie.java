package l2kstudios.gme.beandefs.demolevel;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.view.image.SampleUnitImage;
import processing.core.PImage;

import static l2kstudios.gme.model.unit.Unit.Team.ALLY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import l2kstudios.gme.model.action.postmove.AttackDecision;
import l2kstudios.gme.model.action.postmove.WaitDecision;
import l2kstudios.gme.model.action.postmove.attack.Attack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttack;
import l2kstudios.gme.model.action.postmove.attack.BasicAttackWithRange;
import l2kstudios.gme.model.action.wait.BasicWait;
import l2kstudios.gme.model.action.wait.Wait;
import l2kstudios.gme.model.unit.ConsummableStat;

public class Sophie extends Unit {
	
	{
		name = "Sophie";
		team = ALLY;
		
		health = new ConsummableStat(){{
			setCap(3);
			setVal(3);
		}};
		
		energy = new ConsummableStat(){{
			setCap(2);
			setVal(2);
		}};
		
		speed = 3;
		
		postMoveDecisions = new ArrayList<Class>();
		postMoveDecisions.add(AttackDecision.class);
		postMoveDecisions.add(WaitDecision.class);
		
		actionClasses = new HashMap<Class, List<Class>>();
		
		actionClasses.put(Attack.class, new ArrayList<Class>(){{
			add(BasicAttack.class);
			add(BasicAttackWithRange.class);
		}});
		
		actionClasses.put(Wait.class, new ArrayList<Class>(){{
			add(BasicWait.class);
		}});
	}
	
	public PImage getImage() {
		return SampleUnitImage.getSophieImage();
	}
	
	public float getScale() {
		return .33f;
	}
	
}
