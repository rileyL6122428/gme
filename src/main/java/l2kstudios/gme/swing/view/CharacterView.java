package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import static l2kstudios.gme.swing.view.GridConstants.*; 

public class CharacterView {
	
	private Unit unit;
	
	public void draw(Graphics drawingCtx) {
		Position position = unit.getPosition();
		
		Color unitColor = unit.getTeam() == Unit.Team.ALLY ? Color.blue : Color.red;
		
		drawingCtx.setColor(unitColor);
		drawingCtx.fillOval(position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
		
		drawingCtx.setColor(Color.green);
		drawingCtx.drawString(unit.getName(), position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT + SPACE_HEIGHT / 2);
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
