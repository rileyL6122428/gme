package l2kstudios.gme.model.grid;

import java.util.List;

public interface TwoDimensionalGrid {
	
	public void place(Placeable placeable, int x, int y);
	
	public int getWidth();

	public int getHeight();
	
	public Space getSpaceAt(int x, int y);
	
	public Space getSpaceAt(Position position);

	public Position positionOf(Space space);
	
	public boolean isInBounds(Position position);
	
	public List<List<Space>> getSpaces();
	
	public void setSpaces(List<List<Space>> spaces);
	
}
