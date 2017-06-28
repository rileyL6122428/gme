package l2kstudios.gme.swing.view;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;

public class CharacterView {
	
	private Unit unit;
	
	public void draw(Graphics drawingCtx) {
		Position position = unit.getPosition();
		drawingCtx.drawOval(position.getX() * 80, position.getY() * 80, 80, 80);
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
