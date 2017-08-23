package l2kstudios.gme.beandefs.demo;

import java.awt.Graphics;

import l2kstudios.gme.model.Interaction;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.gameinterface.level.LevelInterface;

public class DemoLevelInteraction implements Interaction {
	
	private LevelInterface levelInterface;
	
	{
		Level level = new DemoLevel();
		
		levelInterface = new LevelInterface();
		levelInterface.setLevel(level);
		levelInterface.afterPropertiesSet();
	}

	@Override
	public void draw(Graphics drawingCtx) {
		levelInterface.draw(drawingCtx);
		
	}

	@Override
	public void receiveInput(Input input) {
		levelInterface.receiveInput(input);
	}

	@Override
	public boolean isFinished() {
		return levelInterface.isFinished();
	}

}
