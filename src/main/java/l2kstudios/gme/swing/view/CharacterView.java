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
	private long previousFrameHealth;
	private HealthChangeView healthChangeView;
	
	public void draw(Graphics drawingCtx) {
		unit.runBoardAnimation(drawingCtx);
		drawHealthBar(drawingCtx);
		drawHealthChange(drawingCtx);
	}


	private void drawHealthBar(Graphics drawingCtx) {
		Position position = unit.getPosition();
		
		drawingCtx.setColor(Color.GREEN);
		
		drawingCtx.fillRect(
			(position.getX() + 1) * SPACE_WIDTH - 3, 
			(int)((position.getY() + 1 - unitHealthRatio()) * SPACE_HEIGHT), 
			3,
			(int)((unitHealthRatio()) * SPACE_HEIGHT)
		);
	}
	
	
	private float unitHealthRatio() {
		return ((float)unit.get(HEALTH)) / ((float)unit.getMax(HEALTH));
	}

	private void drawHealthChange(Graphics drawingCtx) {
		
		if(healthChangeView != null && !healthChangeView.isStillVisible()) {
			healthChangeView = null;
		} else if(healthChangeView != null && healthChangeView.isStillVisible()) {
			healthChangeView.draw(drawingCtx);
		} else if(previousFrameHealth != unit.get(HEALTH)) {
			long healthDiff = unit.get(HEALTH) - previousFrameHealth;
			healthChangeView = new HealthChangeView(healthDiff, unit.getPosition());
		}
		
		previousFrameHealth = unit.get(HEALTH);
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = (SwingUnit)unit;
	}
	
}
