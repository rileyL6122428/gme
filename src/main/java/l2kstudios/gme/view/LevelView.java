package l2kstudios.gme.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import processing.core.PApplet;

public class LevelView {
	
	@Autowired
	private PApplet ctx;
	
	private List<View> subViews;
	
	public void draw() {
		ctx.background(255, 255, 255);
		getSubViews().forEach(View::draw);
	}

	public List<View> getSubViews() {
		return subViews;
	}

	public void setSubViews(List<View> subViews) {
		this.subViews = subViews;
	}

}
