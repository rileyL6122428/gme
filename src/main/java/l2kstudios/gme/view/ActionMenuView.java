package l2kstudios.gme.view;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.ActionMenu;
import processing.core.PApplet;

public class ActionMenuView implements View {

	@Autowired
	private PApplet ctx;
	
	@Autowired
	private ActionMenu actionMenu;
	
	@Override
	public void draw() {
		if(actionMenu.isActive()) {
			System.out.println("ACTION MENU IS ACTIVE");
		}
	}

}
