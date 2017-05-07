package l2kstudios.gme.model.grid.beandefinition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;

public class DemoPlayingGrid extends PlayingGrid {
	
	static int GRID_WIDTH = 10;
	static int GRID_HEIGHT = 10;

	{
		List<List<Space>> spaces = new ArrayList<List<Space>>();
		
		for(int heightIdx = 0; heightIdx < GRID_HEIGHT; heightIdx++) {
			List<Space> row = new ArrayList<Space>();
			for(int widthIdx = 0; widthIdx < GRID_WIDTH; widthIdx++) {
				row.add(new Space());
			}
			spaces.add(row);
		}
		
		setSpaces(spaces);
		
		
		
		Unit unit1 = new Unit() {{
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
		}};
		unit1.place(spaces.get(1).get(1));
		
		Unit unit2 = new Unit() {{
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
		}};
		unit2.place(spaces.get(3).get(5));
		
	}
}
