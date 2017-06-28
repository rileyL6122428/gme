package l2kstudios.gme.swing;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import l2kstudios.gme.beandefs.demolevel.DemoPlayingGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.controller.GameController;
import l2kstudios.gme.swing.view.LevelView;

public class GamePanel extends JPanel implements Interactable {
	
	private Level level;
	private LevelView levelView;
	
	public GamePanel() {
		new GameController().setKeyBindingsOn(this);
		
		level = new Level();
		level.setPlayingGrid(new DemoPlayingGrid());
		level.afterPropertiesSet();
		
		levelView = new LevelView();
		levelView.setLevel(level);
	}
	
	
	
	@Override
    public void paintComponent(Graphics drawingCtx) {
//        g.drawRect(10, 10, 240, 240);    
//        g.fillRoundRect(50, 50, 100, 100, 80, 80);
        levelView.draw(drawingCtx);
        
    }



	@Override
	public void receiveInput(Input input) {
		System.out.println(input);
	}


}
