package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.modelwrappers.SwingUnit; 

public class CharacterView {
	
	private SwingUnit unit;
	
	public void draw(Graphics drawingCtx) {
		unit.runBoardAnimation(drawingCtx);
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = (SwingUnit)unit;
	}
	
}
