package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.BoardView;
import l2kstudios.gme.swing.view.View;

public class UnitDetailInterface implements Interface {
	
	
	private Unit focusedUnit;
	private PlayingGrid playingGrid;
	
	private View cursorView;
	
	private BoardView boardView;
	
	@Override
	public void draw(Graphics drawingCtx) { 	
		boardView.draw(drawingCtx);
		cursorView.draw(drawingCtx);
		drawingCtx.drawString("UNIT DETAIL VIEW", 50, 50);
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public void receiveInput(Input input) {
		switch(input) {
			case UP:
				playingGrid.moveCursorUp();
				break;
			case DOWN:
				playingGrid.moveCursorDown();
				break;
			case RIGHT:
				playingGrid.moveCursorRight();
				break;
			case LEFT:
				playingGrid.moveCursorLeft();
				break;
		}
	}
	
	public void afterPropertiesSet() {
		cursorView = new CursorView(this);
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

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public Position getCursorPosition() {
		return playingGrid.getCursorPosition();
	}

}
