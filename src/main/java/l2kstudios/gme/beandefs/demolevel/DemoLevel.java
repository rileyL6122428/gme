package l2kstudios.gme.beandefs.demolevel;

import l2kstudios.gme.beandefs.demolevel.playinggrid.DemoPlayingGrid;
import l2kstudios.gme.model.level.AlliedUnitsDefeatedCondition;
import l2kstudios.gme.model.level.EnemiesUnitsDefeatedCondition;
import l2kstudios.gme.model.level.Level;

public class DemoLevel extends Level {
	
	{
		setPlayingGrid(new DemoPlayingGrid());
		
		setVictoryCondition(new EnemiesUnitsDefeatedCondition(this));
		setLoseCondition(new AlliedUnitsDefeatedCondition(this));
		
		afterPropertiesSet();
	}
	
}
