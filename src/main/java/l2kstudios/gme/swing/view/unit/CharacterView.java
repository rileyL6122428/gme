package l2kstudios.gme.swing.view.unit;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.modelwrappers.SwingUnit;

public class CharacterView {
	
	private SwingUnit unit;
	private HealthChangeView healthChangeView;
	private HealthBarView healthBarView;
	
	public void draw(Graphics drawingCtx) {
		unit.runBoardAnimation(drawingCtx);
		healthBarView.draw(drawingCtx);
		healthChangeView.draw(drawingCtx);
	}
	public void afterPropertiesSet() {
		this.healthBarView = new HealthBarView(unit);
		this.healthChangeView = new HealthChangeView(unit);
	}
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = (SwingUnit)unit;
	}
	
}
