package l2kstudios.gme.model.grid;

import java.util.List;

public interface RectangularGrid {
	
	public void initialize();
	
	public boolean select();
	
	public void moveCursorTo(Position position);
	
	public void moveCursorTo(Space space);
	
	public void moveCursorDown();
	
	public void moveCursorUp();
	
	public void moveCursorRight();
	
	public void moveCursorLeft();
	
	public void place(Placeable placeable, int x, int y);
	
	public int getWidth();

	public int getHeight();
	
	public Position getCursorPosition();
	
	public Space getSpaceAt(int x, int y);
	
	public Space getSpaceAt(Position position);
	
	public Space hoveredSpace();

	public Position positionOf(Space space);
	
	public boolean isInBounds(Position position);
	
	public List<List<Space>> getSpaces();
	
	public void setSpaces(List<List<Space>> spaces);
	
	
}
