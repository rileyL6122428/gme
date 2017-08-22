package l2kstudios.gme.beandefs.demo.richard;

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
import static l2kstudios.gme.model.unit.Unit.Team.ENEMY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.action.postmove.WaitDecision;
import l2kstudios.gme.model.action.wait.BasicWait;
import l2kstudios.gme.model.action.wait.Wait;
import l2kstudios.gme.model.unit.BasicConciousness;
import l2kstudios.gme.model.unit.Stat;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.animation.BoardAnimation;
import l2kstudios.gme.swing.animation.Frame;
import l2kstudios.gme.swing.animation.ImageLoader;
import l2kstudios.gme.swing.modelwrappers.SwingUnit;

public class Richard extends SwingUnit {
	
	
	{
		name = "Richard";
		team = ENEMY;
		
		
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
			setMaxCap(2);
			setCap(2);
			setVal(2);
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
		
		
		postMoveDecisions = new ArrayList<PostMoveDecision>();
		postMoveDecisions.add(new RapierAssaultArtesDecision());
		postMoveDecisions.add(new CoercionBurstArtesDecision());
		postMoveDecisions.add(new WaitDecision());
		
		actionClasses = new HashMap<Class, List<Class>>();
		
		actionClasses.put(RapierAssaultArtes.class, new ArrayList<Class>(){{
			add(PoorForm.class);
		}});
		
		actionClasses.put(CoercionBurstArtes.class, new ArrayList<Class>(){{
			add(SwordReaper.class);
		}});
		
		actionClasses.put(Wait.class, new ArrayList<Class>(){{
			add(BasicWait.class);
		}});
		
		Unit richardInstance = this;
		conciousness = new BasicConciousness(){{
			setUnit(richardInstance);
		}};
		
		
		
		boardAnimation = new BoardAnimation(){{
			setUnit(richardInstance);
			
			setIdleFrames(new ArrayList<Frame>(){{
				add(new Frame(){{
					setImage(ImageLoader.getBoardSprite("Asbel-Frame-1.png", 0, 0));
					setDuration(15);
				}});
				
				add(new Frame(){{
					setImage(ImageLoader.getBoardSprite("Asbel-Frame-2.png", 0, 0));
					setDuration(15);
				}});
				
				add(new Frame(){{
					setImage(ImageLoader.getBoardSprite("Asbel-Frame-3.png", 0, 0));
					setDuration(15);
				}});
				
				add(new Frame(){{
					setImage(ImageLoader.getBoardSprite("Asbel-Frame-2.png", 0, 0));
					setDuration(15);
				}});
			}});
		}};
	}

}
