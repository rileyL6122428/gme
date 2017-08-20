package l2kstudios.gme.swing.view.unit;

import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Graphics;

import static l2kstudios.gme.swing.view.GridConstants.*;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.swing.view.View;

public class HealthChangeView implements View {
	
	private float opacity;
	private long healthChange;
	private Color displayColor;
	private Position position;
	
	public HealthChangeView(long healthChange, Position position) {
		this.healthChange = healthChange;
		this.displayColor = colorByHealthChange(healthChange);
		this.opacity = 1f;
		this.position = position;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		drawingCtx.setColor(displayColor);
		
		drawingCtx.drawString(
			healthChange + "", 
			(int) ((position.getX() + 0.12f) * SPACE_WIDTH), 
			(int)((position.getY() + 0.15f) * SPACE_HEIGHT)
		);
		
		opacity -= 0.015f;
	}
	
	private Color colorByHealthChange(long healthChange) {
		if(healthChange < 0) {
			return RED;
		} else if(healthChange == 0) {
			return BLACK;
		} else {
			return GREEN;
		}
	}
	
	public boolean isStillVisible() {
		return opacity > 0;
	}
}
