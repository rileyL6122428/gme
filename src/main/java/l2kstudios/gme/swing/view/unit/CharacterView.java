package l2kstudios.gme.swing.view.unit;

import static l2kstudios.gme.model.unit.Unit.StatType.HEALTH;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.modelwrappers.SwingUnit;

public class CharacterView {
	
	private SwingUnit unit;
	private long previousFrameHealth;
	private HealthChangeView healthChangeView;
	private HealthBarView healthBarView;
	
	public void draw(Graphics drawingCtx) {
		unit.runBoardAnimation(drawingCtx);
		healthBarView.draw(drawingCtx);
		drawHealthChange(drawingCtx);
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

	public void afterPropertiesSet() {
		this.healthBarView = new HealthBarView(unit);
	}
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = (SwingUnit)unit;
	}
	
}
