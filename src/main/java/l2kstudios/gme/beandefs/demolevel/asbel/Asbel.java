package l2kstudios.gme.beandefs.demolevel.asbel;

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
import l2kstudios.gme.swing.modelwrappers.SwingUnit;
import l2kstudios.gme.model.action.postmove.PostMoveDecision;

import static l2kstudios.gme.model.unit.Unit.StatType.*;

public class Asbel extends SwingUnit {
	
	{
		name = "Asbel";
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
		
		postMoveDecisions = new ArrayList<PostMoveDecision>();
		postMoveDecisions.add(new SheathedSwordArtesDecision());
		postMoveDecisions.add(new DrawnSwordArtesDecision());
		postMoveDecisions.add(new WaitDecision());
		
		actionClasses = new HashMap<Class, List<Class>>();
		
		actionClasses.put(SheathedSwordArtes.class, new ArrayList<Class>(){{
			add(NimbleFang.class);
		}});
		
		actionClasses.put(DrawnSwordArtes.class, new ArrayList<Class>(){{
			add(DemonFang.class);
		}});
		
		actionClasses.put(Wait.class, new ArrayList<Class>(){{
			add(BasicWait.class);
		}});
		
		
		Unit asbelInstance = this;
		boardAnimation = new BoardAnimation(){{
			setUnit(asbelInstance);
			
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
