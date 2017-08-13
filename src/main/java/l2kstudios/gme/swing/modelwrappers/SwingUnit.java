package l2kstudios.gme.swing.modelwrappers;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.animation.BoardAnimation;

public class SwingUnit extends Unit {
	
	protected BoardAnimation boardAnimation;
	
	public void runBoardAnimation(Graphics drawingCtx) {
		boardAnimation.run(drawingCtx);
	}
	
}
