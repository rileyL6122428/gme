package l2kstudios.gme.view;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.customerror.MethodNotImplementedException;
import processing.core.PApplet;

public class View<Model> {
	
	@Autowired
	protected PApplet ctx;
	
	protected Model model;
	
	public void draw() {
		throw new MethodNotImplementedException();
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public void setDrawingContext(PApplet ctx) {
		this.ctx = ctx;
	}
	
}
