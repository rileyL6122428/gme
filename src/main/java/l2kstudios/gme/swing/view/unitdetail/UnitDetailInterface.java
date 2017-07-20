package l2kstudios.gme.swing.view.unitdetail;

import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class UnitDetailInterface implements Interface {
	
	private boolean active;
	private int pageIdx;
	private List<View> pages;
	
	@Override
	public void draw(Graphics drawingCtx) {
		if(isActive()) 
			pages.get(pageIdx).draw(drawingCtx);	
		
		drawingCtx.drawString("UNIT DETAIL VIEW", 50, 50);
	}
	
	public void flipRight() {
		if(pageIdx++ >= pages.size()) pageIdx = 0;
	}
	
	public void flipLeft() {
		if(pageIdx-- < 0) pageIdx = pages.size() - 1;
	}
	
	@Override
	public void receiveInput(Input input) {
		switch(input) {
			case LEFT:
				flipLeft();
				break;
			case RIGHT:
				flipRight();
				break;
		}
	}
	
	public void setModel(Unit model) {
//		pages.forEach( (page)-> page.setModel(model) );
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getPageIdx() {
		return pageIdx;
	}
	public void setPageIdx(int pageIdx) {
		this.pageIdx = pageIdx;
	}
	public List<View> getPages() {
		return pages;
	}
	public void setPages(List<View> pages) {
		this.pages = pages;
	}

	public void setLevel(Level level) {
		// TODO Auto-generated method stub
		
	}

}