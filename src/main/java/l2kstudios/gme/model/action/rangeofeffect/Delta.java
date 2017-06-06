package l2kstudios.gme.model.action.rangeofeffect;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;

public class Delta {
	
	private int x;
	private int y;
	
	public Delta(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Delta(Position positionA, Position positionB) {
		x = positionB.getX() - positionA.getX();
		y = positionB.getY() - positionA.getY();
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isZeroDelta() {
		return y == 0 && x == 0;
	}
}
