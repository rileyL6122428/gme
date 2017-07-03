package l2kstudios.gme.swing.model;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.ComputerControllableUnit;
import l2kstudios.gme.swing.animation.BoardAnimation;

public class SwingUnit extends ComputerControllableUnit {
	
	protected BoardAnimation boardAnimation;
	
	public void runBoardAnimation(Graphics drawingCtx) {
		boardAnimation.run(drawingCtx);
	}
	
}
