package l2kstudios.gme.model.grid.beandefinition;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;

public class DemoPlayingGrid extends PlayingGrid {
	{
		List<List<Space>> spaces = new ArrayList<List<Space>>();
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		spaces.add(new ArrayList<Space>(){{
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
			add(new Space());
		}});
		
		new Unit() {{
			setName("slower");
			setSpeed(2);
			setEnergy(new ConsummableStat() {{
				setCap(1);
				setVal(1);
			}});
			setHealth(new ConsummableStat() {{
				setCap(5);
				setVal(5);
			}});
		}}.place(spaces.get(1).get(1));
		
		new Unit() {{
			setName("faster");
			setSpeed(3);
			setEnergy(new ConsummableStat(){{
				setCap(2);
				setVal(2);
			}});
			setHealth(new ConsummableStat(){{
				setCap(10);
				setVal(10);
			}});
		}}.place(spaces.get(3).get(5));
		
		setSpaces(spaces);
	}
}
