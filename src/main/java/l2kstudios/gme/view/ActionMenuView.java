package l2kstudios.gme.view;

import org.springframework.beans.factory.annotation.Autowired;

import static l2kstudios.gme.view.GridConstants.*;

import l2kstudios.gme.model.grid.ActionMenu;
import l2kstudios.gme.model.grid.Position;
import processing.core.PApplet;

public class ActionMenuView implements View {

	public static int HORIZONTAL_OFFSET = 75;
	
	@Autowired
	private PApplet ctx;
	
	@Autowired
	private ActionMenu actionMenu;
	
	@Override
	public void draw() {
		if(actionMenu.shouldDraw()) {
			Position position = actionMenu.getActiveUnitPosition();
			
			ctx.fill(0);
			ctx.text("THIS IS THE ACTION_MENU_VIEW", position.getX() * SPACE_HEIGHT + HORIZONTAL_OFFSET, position.getY() * SPACE_WIDTH);
		}
	}

}
