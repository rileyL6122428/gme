package l2kstudios.gme.level.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.Cursor;
import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;

public class Grid implements InitializingBean {

	private Dimension dimensions;
	
	protected Cursor cursor;
	protected List<List<Placeable>> spaces;
	
	public Grid() {
		this.cursor = new Cursor();
	}
	
	public void moveCursorBy(int deltaX, int deltaY) {
		moveCursorField(cursor::setX, cursor.getX() + deltaX, getDimensions().getWidth());
		moveCursorField(cursor::setY, cursor.getY() + deltaY, getDimensions().getHeight());
	}
	
	private void moveCursorField(Consumer<Integer> setter, int nextCursorVal, int gridDimension) {
		if(nextCursorVal < 0) {
			setter.accept(gridDimension + nextCursorVal);
		} else if(nextCursorVal >= gridDimension){
			setter.accept(nextCursorVal % gridDimension);
		} else {
			setter.accept(nextCursorVal);
		}
	}
	
	
	
	public int getWidth() {
		return getDimensions().getWidth();
	}

	public int getHeight() {
		return getDimensions().getHeight();
	}
	
	public Position getCursorPosition() {
		return cursor.getPosition();
	}
	
	public void addElement(Placeable placeable) {
		Position position = placeable.getPosition();
		int x = position.getX();
		int y = position.getY();
		
		spaces.get(y).set(x, placeable);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		initializeSpaces();
	}
	
	protected void initializeSpaces() {
		spaces = new ArrayList<List<Placeable>>();
		
		for(int rowIdx = 0; rowIdx < getDimensions().getHeight(); rowIdx++) {
			List<Placeable> row = new ArrayList<Placeable>();
			for(int colIdx = 0; colIdx < getDimensions().getWidth(); colIdx++) {
				row.add(null);
			}
			spaces.add(row);
		}
	}

	public Dimension getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimension dimensions) {
		this.dimensions = dimensions;
	}
}
