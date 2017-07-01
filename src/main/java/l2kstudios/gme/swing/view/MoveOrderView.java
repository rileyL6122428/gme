package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;

import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.movement.MovementCycle;

import static l2kstudios.gme.SwingApp.*;

public class MoveOrderView {
	
	private Level level;
	
	public void draw(Graphics drawingCtx) {
		MovementCycle movementCycle = level.getMovementCycle();
		drawingCtx.setColor(Color.RED);
		movementCycle.iterateOrder((unit, orderIdx) -> {
			drawingCtx.drawString(
					unit.getName(), 
					SCREEN_STARTING_WIDTH - 60, 
					20 * orderIdx + 20
			);
		});
	}
	
	
	public void setLevel(Level level) {
		this.level = level;
	}
}
