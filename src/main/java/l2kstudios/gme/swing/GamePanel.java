package l2kstudios.gme.swing;

import java.awt.Graphics;

import javax.swing.JPanel;

import l2kstudios.gme.beandefs.demolevel.playinggrid.DemoPlayingGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.controller.GameController;
import l2kstudios.gme.swing.view.interfacemanagement.LevelInterface;

public class GamePanel extends JPanel implements Interface {
	
	private Level level;
	private LevelInterface levelInterface;
	
	public GamePanel() {
		new GameController().setKeyBindingsOn(this);
		
		level = new Level();
		level.setPlayingGrid(new DemoPlayingGrid());
		level.afterPropertiesSet();
		
		levelInterface = new LevelInterface();
		levelInterface.setLevel(level);
	}
	
	@Override
    public void paintComponent(Graphics drawingCtx) {
		draw(drawingCtx);
    }

	@Override
	public void draw(Graphics drawingCtx) {
		levelInterface.draw(drawingCtx);
	}

	@Override
	public void receiveInput(Input input) {
		levelInterface.receiveInput(input);
	}
	
}
