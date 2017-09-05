package l2kstudios.gme.swing;

import java.awt.Graphics;

import javax.swing.JPanel;

import l2kstudios.gme.beandefs.demo.DemoSequenceEngine;
import l2kstudios.gme.model.SequenceEngine;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.swing.controller.GameController;

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
		if(!sequenceEngine.isFinished())
			sequenceEngine.draw(drawingCtx);
		else
			drawingCtx.drawString("SEQUENCE ENGINE IS FINISHED", 200, 200);
    }

	@Override
	public void receiveInput(Input input) {
		if(!sequenceEngine.isFinished())
			sequenceEngine.receiveInput(input);
	}

	public void update() {
		if(!sequenceEngine.isFinished())
			sequenceEngine.update();
	}

}
