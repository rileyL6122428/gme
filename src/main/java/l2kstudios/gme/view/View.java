package l2kstudios.gme.view;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.customerror.MethodNotImplementedException;
import processing.core.PApplet;

public class View {
	
	@Autowired
	protected PApplet ctx;
	
	public void draw() {
		throw new MethodNotImplementedException();
	}
	
	public void setDrawingContext(PApplet ctx) {
		this.ctx = ctx;
	}
}
