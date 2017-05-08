package l2kstudios.gme.ctrl;

import l2kstudios.gme.model.customerror.MethodNotImplementedException;
import processing.core.PApplet;

public class Controller<Model> {
	
	protected Model model;
	
	protected PApplet ctx;
	
	public void keyPressed() {
		throw new MethodNotImplementedException();
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}	
	
	public void setControlContext(PApplet ctx) {
		this.ctx = ctx;
	}
	
	public PApplet getControlContext() {
		return ctx;
	}
}
