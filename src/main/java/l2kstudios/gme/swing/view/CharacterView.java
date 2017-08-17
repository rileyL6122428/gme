package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.modelwrappers.SwingUnit; 

import static l2kstudios.gme.model.unit.Unit.StatType.*;
import static l2kstudios.gme.swing.view.GridConstants.*;

public class CharacterView {
	
	private SwingUnit unit;
	
	public void draw(Graphics drawingCtx) {
		unit.runBoardAnimation(drawingCtx);
		drawHealthBar(drawingCtx);
	}

	private void drawHealthBar(Graphics drawingCtx) {
		Position position = unit.getPosition();
		
		drawingCtx.setColor(Color.GREEN);
		
		drawingCtx.drawLine(
			(position.getX() + 1) * SPACE_WIDTH, 
			(position.getY() + 1) * SPACE_HEIGHT, 
			(position.getX() + 1) * SPACE_WIDTH, 
			(int)((position.getY() + 1 - unitHealthRatio()) * SPACE_HEIGHT)
		);
	}
	
	private float unitHealthRatio() {
		return ((float)unit.get(HEALTH)) / ((float)unit.getMax(HEALTH));
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = (SwingUnit)unit;
	}
	
}
