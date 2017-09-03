package l2kstudios.gme.model.action.rangeofeffect;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import l2kstudios.gme.model.grid.position.Position;

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
	
	public Position getRelativePositionFrom(Position position) {
		return Position.fromCached(position.getX() - x, position.getY() - y);
	}

	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	
	public int getRotatedX(double rotationDegrees) {
		return (int) round(cos(rotationTheta(rotationDegrees)) * length()) ;
	}
	
	public int getRotatedY(double rotationDegrees) {
		return (int) round(sin(rotationTheta(rotationDegrees)) * length());
	}
	
	private double rotationTheta(double rotationDegrees) {
		return toRadians(rotationDegrees) + atan2(y, x);
	}
	
	private double length() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public boolean isZeroDelta() {
		return y == 0 && x == 0;
	}
}
