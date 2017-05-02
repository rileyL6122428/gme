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
			add(new Space(){{
				setOccupier(new Unit() {{
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
				}});
			}});
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
			add(new Space(){{
				setOccupier(new Unit() {{
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
				}});
			}});
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
		
		setSpaces(spaces);
	}
}
