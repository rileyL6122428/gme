package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.BoardView;
import l2kstudios.gme.swing.view.View;

public class UnitDetailInterface implements Interface {
	
	private int pageIdx;
	private List<View> pages;
	private Unit focusedUnit;
	
	private BoardView boardView;
	
	{
		pages = new ArrayList<View>();
		pages.add(new UnitDetailStatView());
	}
	
	@Override
	public void draw(Graphics drawingCtx) { 	
		boardView.draw(drawingCtx);
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

	public Unit getFocusedUnit() {
		return focusedUnit;
	}

	public void setFocusedUnit(Unit focusedUnit) {
		this.focusedUnit = focusedUnit;
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

}
