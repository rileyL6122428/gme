package l2kstudios.gme.swing.view;

import java.awt.Graphics;

public interface View<Model> {
	
	public void draw(Graphics drawingCtx);
	
	public void setModel(Model model);
	
}
