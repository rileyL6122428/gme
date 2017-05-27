package l2kstudios.gme.ctrl;

import static l2kstudios.gme.model.interaction.Input.BACK;
import static l2kstudios.gme.model.interaction.Input.DOWN;
import static l2kstudios.gme.model.interaction.Input.LEFT;
import static l2kstudios.gme.model.interaction.Input.RIGHT;
import static l2kstudios.gme.model.interaction.Input.SPACE;
import static l2kstudios.gme.model.interaction.Input.UP;

import l2kstudios.gme.model.customerror.MethodNotImplementedException;
import l2kstudios.gme.model.interaction.Interactable;
import processing.core.PApplet;
import processing.core.PConstants;

public class Controller {
	
	protected Interactable interactable;
	
	protected PApplet ctx;
	
	public void keyPressed() {
		if(ctx.key == 'a') interactable.receiveInput(LEFT);
		if(ctx.key =='s') interactable.receiveInput(DOWN);
		if(ctx.key == 'd') interactable.receiveInput(RIGHT);
		if(ctx.key =='w') interactable.receiveInput(UP);
		if(ctx.key == ' ') interactable.receiveInput(SPACE);
		
		if(ctx.key == PConstants.BACKSPACE) interactable.receiveInput(BACK);
	}
	
	public Interactable getInteractable() {
		return interactable;
	}

	public void setInteractable(Interactable interactable) {
		this.interactable = interactable;
	}
	
	public void setControlContext(PApplet ctx) {
		this.ctx = ctx;
	}
	
	public PApplet getControlContext() {
		return ctx;
	}
}
