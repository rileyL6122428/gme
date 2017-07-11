package l2kstudios.gme.beandefs.demolevel.sophie;

import static l2kstudios.gme.model.unit.Unit.StatType.HEALTH;
import static l2kstudios.gme.model.unit.Unit.StatType.INTELLIGENCE;
import static l2kstudios.gme.model.unit.Unit.StatType.MAGIC;
import static l2kstudios.gme.model.unit.Unit.StatType.MAGICAL_DEFENSE;
import static l2kstudios.gme.model.unit.Unit.StatType.MOMENTUM;
import static l2kstudios.gme.model.unit.Unit.StatType.MOVEMENT;
import static l2kstudios.gme.model.unit.Unit.StatType.PHYSICAL_DEFENSE;
import static l2kstudios.gme.model.unit.Unit.StatType.SKILL;
import static l2kstudios.gme.model.unit.Unit.StatType.SPEED;
import static l2kstudios.gme.model.unit.Unit.StatType.STRENGTH;
import static l2kstudios.gme.model.unit.Unit.Team.ALLY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import l2kstudios.gme.model.action.postmove.WaitDecision;
import l2kstudios.gme.model.action.wait.BasicWait;
import l2kstudios.gme.model.action.wait.Wait;
import l2kstudios.gme.model.unit.Stat;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.animation.BoardAnimation;
import l2kstudios.gme.swing.animation.Frame;
import l2kstudios.gme.swing.animation.ImageLoader;
import l2kstudios.gme.swing.model.SwingUnit;

public class Sophie extends SwingUnit {
	
	{
		name = "Sophie";
		team = ALLY;
		
		setStat(HEALTH, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		setStat(MOMENTUM, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		setStat(STRENGTH, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		setStat(PHYSICAL_DEFENSE, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		setStat(MAGIC, new Stat(){{
			setMaxCap(2);
			setCap(2);
			setVal(2);
		}});
		
		setStat(MAGICAL_DEFENSE, new Stat(){{
			setMaxCap(2);
			setCap(2);
			setVal(2);
		}});
		
		setStat(MOVEMENT, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		setStat(SPEED, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});

		setStat(INTELLIGENCE, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		setStat(SKILL, new Stat(){{
			setMaxCap(3);
			setCap(3);
			setVal(3);
		}});
		
		postMoveDecisions = new ArrayList<Class>();
		postMoveDecisions.add(MartialAssaultArtesDecision.class);
		postMoveDecisions.add(RegenerativeBurstArtesDecision.class);
		postMoveDecisions.add(WaitDecision.class);
		
		actionClasses = new HashMap<Class, List<Class>>();
		
		actionClasses.put(MartialAssaultArtes.class, new ArrayList<Class>(){{
			add(TripleStrike.class);
		}});
		
		actionClasses.put(RegenerativeBurstArtes.class, new ArrayList<Class>(){{
			add(FirstAid.class);
		}});
		
		actionClasses.put(Wait.class, new ArrayList<Class>(){{
			add(BasicWait.class);
		}});
		
		Unit sophieInstance = this;
		boardAnimation = new BoardAnimation(){{
			setUnit(sophieInstance);
			
			setIdleFrames(new ArrayList<Frame>(){{
				add(new Frame(){{
					setImage(ImageLoader.getBoardSprite("Sophie-Frame-1.png", 0, 0));
					setDuration(60);
				}});				
			}});
		}};
	}
	
}
