package l2kstudios.gme.swing.view.unitdetail;

import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class UnitDetailView implements View<Unit> {
	
	private boolean active;
	private int pageIdx;
	private List<View<Unit>> pages;
	
	@Override
	public void draw(Graphics drawingCtx) {
		if(isActive()) 
			pages.get(pageIdx).draw(drawingCtx);					
	}
	
	public void flipRight() {
		if(pageIdx++ >= pages.size()) pageIdx = 0;
	}
	
	public void flipLeft() {
		if(pageIdx-- < 0) pageIdx = pages.size() - 1;
	}
	
	@Override
	public void setModel(Unit model) {
		pages.forEach( (page)-> page.setModel(model) );
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
	public List<View<Unit>> getPages() {
		return pages;
	}
	public void setPages(List<View<Unit>> pages) {
		this.pages = pages;
	}
	
}
