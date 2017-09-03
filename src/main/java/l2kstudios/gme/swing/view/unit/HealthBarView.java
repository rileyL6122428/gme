package l2kstudios.gme.swing.view.unit;

import static l2kstudios.gme.model.unit.Unit.StatType.HEALTH;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.grid.position.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.modelwrappers.SwingUnit;
import l2kstudios.gme.swing.view.View;

public class HealthBarView implements View {
	
	private static final int THICKNESS = 4;
	
	private SwingUnit unit;
	
	public HealthBarView(SwingUnit unit) {
		this.unit = unit;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		drawingCtx.setColor(Color.GREEN);
		
		drawingCtx.fillRect(
			healthBarX(unit), 
			healthBarY(unit), 
			THICKNESS,
			healthBarHeight()
		);
	}
	
	private int healthBarX(Unit unit) {
		Position unitPosition = unit.getPosition();
		return (unitPosition.getX() + 1) * SPACE_WIDTH - THICKNESS;
	}
	
	private int healthBarY(Unit unit) {
		Position unitPosition = unit.getPosition();
		return (int)((unitPosition.getY() + 1 - unitHealthRatio()) * SPACE_HEIGHT);
	}
	
	private int healthBarHeight() {
		return (int)((unitHealthRatio()) * SPACE_HEIGHT);
	}
	
	private float unitHealthRatio() {
		return ((float)unit.get(HEALTH)) / ((float)unit.getMax(HEALTH));
	}

	public SwingUnit getUnit() {
		return unit;
	}

	public void setUnit(SwingUnit unit) {
		this.unit = unit;
	}

}
