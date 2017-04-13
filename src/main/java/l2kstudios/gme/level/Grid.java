package l2kstudios.gme.level;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.InitializingBean;

public class Grid implements InitializingBean {
	
	private Cursor cursor;
	private int width, height;
	private List<Unit> units;
	private List<List<Unit>> spaces;
	
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
	
	public void addUnit(Unit unit) {
		Position position = unit.getPosition();
		int x = position.getX();
		int y = position.getY();
		
		spaces.get(y).set(x, unit);
		units.add(unit);
	}
	
	public List<Unit> getUnits() {
		return units;
	}

	public Unit getUnitAt(int x, int y) {
		return spaces.get(y).get(x);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		initializeSpaces();
		initializeUnits();
	}
	
	private void initializeUnits() {
		this.units = new ArrayList<Unit>();
	}
	
	private void initializeSpaces() {
		spaces = new ArrayList<List<Unit>>();
		
		for(int rowIdx = 0; rowIdx < height; rowIdx++) {
			List row = new ArrayList<Unit>();
			for(int colIdx = 0; colIdx < width; colIdx++) {
				row.add(null);
			}
			spaces.add(row);
		}
	}
}
