package l2kstudios.gme.model.grid;

import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public class BoundedCursor extends Cursor {
	
	private int maxX;
	private int maxY;
	
	public BoundedCursor() { }
	
	public BoundedCursor(PlayingGrid playingGrid, Unit actingUnit) {
		setXBound(playingGrid.getWidth());
		setYBound(playingGrid.getHeight());
		setPosition(actingUnit.getPosition());
	}
	
	public void incrementPosition(int deltaX, int deltaY) {
		super.incrementPosition(deltaX, deltaY);
		
		if(position.getX() < 0) position.setX(maxX - 1);
		if(position.getY() < 0) position.setY(maxY - 1);
		
		if(position.getX() >= maxX) position.setX(0);
		if(position.getY() >= maxY) position.setY(0);
	}
	
	public void setXBound(int maxX) {
		this.maxX = maxX;
	}
	
	public void setYBound(int maxY) {
		this.maxY = maxY;
	}
	
}
