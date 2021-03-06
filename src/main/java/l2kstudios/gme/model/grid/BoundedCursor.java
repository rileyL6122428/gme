package l2kstudios.gme.model.grid;

import java.util.List;

import l2kstudios.gme.model.action.Action;
import l2kstudios.gme.model.action.postmove.PostMoveDecision;
import l2kstudios.gme.model.grid.playinggrid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;

public class BoundedCursor extends Cursor {
	
	public static BoundedCursor fromActionList(List<Action> actions) {
		BoundedCursor cursor = new BoundedCursor();
		
		cursor.setXBound(0);
		cursor.setYBound(actions.size());
		cursor.setPosition(Position.fromCached(0, 0));
		
		return cursor;
	}
	
	public static BoundedCursor fromPlayingGrid(PlayingGrid playingGrid) {
		BoundedCursor boundedCursor = new BoundedCursor();
		
		boundedCursor.setXBound(playingGrid.getWidth());
		boundedCursor.setYBound(playingGrid.getHeight());
		boundedCursor.setPosition(Position.fromCached(0, 0));
		
		return boundedCursor;
	}
	
	private int maxX;
	private int maxY;
	
	public BoundedCursor() { }
	
	public BoundedCursor(PlayingGrid playingGrid, Unit actingUnit) {
		setXBound(playingGrid.getWidth());
		setYBound(playingGrid.getHeight());
		setPosition(actingUnit.getPosition());
	}
	
	public BoundedCursor(List<PostMoveDecision> decisions) {
		setXBound(0);
		setYBound(decisions.size());
		setPosition(Position.fromCached(0, 0));
	}

	public BoundedCursor(int width, int height) {
		setXBound(width);
		setYBound(height);
	}

	public void incrementPosition(int deltaX, int deltaY) {
		super.incrementPosition(deltaX, deltaY);
		
		if(position.getX() < 0) 
			position = Position.fromCached(maxX - 1, position.getY());
		
		if(position.getY() < 0)
			position = Position.fromCached(position.getX(), maxY - 1);
		
		if(position.getX() >= maxX)
			position = Position.fromCached(0, position.getY());
		
		if(position.getY() >= maxY)
			position = Position.fromCached(position.getX(), 0);
	}
	
	public void setXBound(int maxX) {
		this.maxX = maxX;
	}
	
	public void setYBound(int maxY) {
		this.maxY = maxY;
	}
	
}
