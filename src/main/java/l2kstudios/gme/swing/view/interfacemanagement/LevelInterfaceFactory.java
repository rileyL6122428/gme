package l2kstudios.gme.swing.view.interfacemanagement;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.view.LevelView;
import l2kstudios.gme.swing.view.LevelViewFactory;
import l2kstudios.gme.swing.view.unitdetail.UnitDetailInterface;

public class LevelInterfaceFactory {
	
	public static LevelInterface newLevelInterface(Level level) {
		LevelInterface levelInterface = new LevelInterface();
		
		levelInterface.setLevel(level);
		levelInterface.setLevelView(LevelViewFactory.newLevelView(level));
		levelInterface.setTurnInterfaceManager(new TurnInterfaceManager());
		levelInterface.setUnitDetailInterface(new UnitDetailInterface());
		
		levelInterface.afterPropertiesSet();
		
		return levelInterface;
	}
	
}
