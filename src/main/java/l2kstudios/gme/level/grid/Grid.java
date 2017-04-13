package l2kstudios.gme.level.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.level.Cursor;
import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;

public class Grid implements InitializingBean {
	
	protected Cursor cursor;
	protected int width, height;
	protected List<List<Placeable>> spaces;
	
	public Grid() {
		this.cursor = new Cursor();
	}
	
	public void moveCursorBy(int deltaX, int deltaY) {
		moveCursorField(cursor::setX, cursor.getX() + deltaX, width);
		moveCursorField(cursor::setY, cursor.getY() + deltaY, height);
	}
	
	private void moveCursorField(Consumer<Integer> setter, int nextCursorVal, int gridDimension) {
		if(nextCursorVal < 0) {
			setter.accept(height + nextCursorVal);
		} else if(nextCursorVal >= gridDimension){
			setter.accept(nextCursorVal % gridDimension);
		} else {
			setter.accept(nextCursorVal);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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
	
	private void initializeSpaces() {
		spaces = new ArrayList<List<Placeable>>();
		
		for(int rowIdx = 0; rowIdx < height; rowIdx++) {
			List row = new ArrayList<Unit>();
			for(int colIdx = 0; colIdx < width; colIdx++) {
				row.add(null);
			}
			spaces.add(row);
		}
	}
}
