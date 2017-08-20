package l2kstudios.gme.swing.view.unit;

import static java.awt.Color.BLACK;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static l2kstudios.gme.model.unit.Unit.StatType.HEALTH;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.swing.modelwrappers.SwingUnit;
import l2kstudios.gme.swing.view.View;

public class HealthChangeView implements View {

	private SwingUnit unit;
	
	private HealthChange healthChange;
	
	private long previousFrameHealth;
	
	public HealthChangeView(SwingUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public void draw(Graphics drawingCtx) {
		
		
		if(healthChange != null && healthChange.readyToDiscard()) {
			healthChange = null;
		} else if(healthChange != null && !healthChange.readyToDiscard()) {
			drawChange(drawingCtx);
			healthChange.incrementFramesDisplayedFor();
		} else if(previousFrameHealth != unit.get(HEALTH)) {
			healthChange = new HealthChange(unit.get(HEALTH) - previousFrameHealth);
			previousFrameHealth = unit.get(HEALTH);
		}
		
		previousFrameHealth = unit.get(HEALTH);
	}
	
	private void drawChange(Graphics drawingCtx) {
		drawingCtx.setColor(colorByHealthChange());
		
		drawingCtx.drawString(
			healthChange.getHealthDiff() + "", 
			(int) ((unit.getPosition().getX() + 0.12f) * SPACE_WIDTH), 
			(int)((unit.getPosition().getY() + 0.15f) * SPACE_HEIGHT)
		);
		
	}
	
	private Color colorByHealthChange() {
		if(healthChange.getHealthDiff() < 0) {
			return RED;
		} else if(healthChange.getHealthDiff() == 0) {
			return BLACK;
		} else {
			return GREEN;
		}
	}

	public SwingUnit getUnit() {
		return unit;
	}

	public void setUnit(SwingUnit unit) {
		this.unit = unit;
	}
	
	static class HealthChange {
		
		private static final int MAX_DISPLAY_FRAMES = 35;
		
		private long healthDiff;
		private long numberOfFramesDisplayedFor;
		
		public HealthChange(long healthDiff) {
			this.healthDiff = healthDiff;
			this.numberOfFramesDisplayedFor = 0;
		}

		public long getHealthDiff() {
			return healthDiff;
		}
		
		public void incrementFramesDisplayedFor() {
			numberOfFramesDisplayedFor++;
		}
		
		public boolean readyToDiscard() {
			return numberOfFramesDisplayedFor > MAX_DISPLAY_FRAMES;
		}
	}
}
