package l2kstudios.gme.swing;

import java.awt.Graphics;

import javax.swing.JPanel;

import l2kstudios.gme.beandefs.demo.DemoSequenceEngine;
import l2kstudios.gme.model.SequenceEngine;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.controller.GameController;
import l2kstudios.gme.swing.gameinterface.level.LevelInterface;

public class GamePanel extends JPanel implements Interactable {
	
	private GameController controller;
	private SequenceEngine sequenceEngine;
	
	public GamePanel() {
		controller = new GameController();
		controller.setKeyBindingsOn(this);
		
		sequenceEngine = new DemoSequenceEngine();
	}
	
	@Override
    public void paintComponent(Graphics drawingCtx) {
		sequenceEngine.draw(drawingCtx);
    }

	@Override
	public void receiveInput(Input input) {
		sequenceEngine.receiveInput(input);
	}

	public void update() {
		sequenceEngine.update();
	}
	
}
