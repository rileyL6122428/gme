package l2kstudios.gme.swing.gameinterface.level;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.gameinterface.turn.TurnInterfaceManager;
import l2kstudios.gme.swing.gameinterface.unitdetail.UnitDetailInterface;
import l2kstudios.gme.swing.view.BoardView;
import l2kstudios.gme.swing.view.LevelViewFactory;

public class LevelInterfaceFactory {
	
	public static LevelInterface newLevelInterface(Level level) {
		LevelInterface levelInterface = new LevelInterface();
		
		levelInterface.setLevel(level);
		levelInterface.setBoardView(LevelViewFactory.newLevelView(level));
		levelInterface.setTurnInterfaceManager(new TurnInterfaceManager());
		levelInterface.setUnitDetailInterface(new UnitDetailInterface());
		
		levelInterface.afterPropertiesSet();
		
		return levelInterface;
	}
	
}
