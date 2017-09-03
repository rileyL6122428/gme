package l2kstudios.gme.model.action.rangeofeffect;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.grid.position.Position;

public class RelativeLine extends RangeOfEffect {
	
	public RelativeLine(int length) {
		deltas = new ArrayList<Delta>();
		
		for(int lineIdx = 0; lineIdx < length; lineIdx++) {
			deltas.add(new Delta(lineIdx, 0));
		}
	}
	
	public List<Space> affectedSpaces(Position positionOfExecution) {
		final List<Space> affectedSpaces = new ArrayList<Space>();
		
		double rotationDegrees = getRotationDegrees(positionOfExecution);
		
		deltas.forEach((delta) -> {
			int x = positionOfExecution.getX() + delta.getRotatedX(rotationDegrees); 
			int y = positionOfExecution.getY() + delta.getRotatedY(rotationDegrees);
			
			
			if(playingGrid.isInBounds(x, y)) 
				affectedSpaces.add(playingGrid.getSpaceAt(x, y));
		});
		
		return affectedSpaces;
	}
	
	
	
	private double getRotationDegrees(Position positionOfExecution) {
		if(positionIsEastOfUnit(positionOfExecution))
			return 0;
		else if(positionIsSouthOfUnit(positionOfExecution))
			return 90;
		else if(positionIsWestOfUnit(positionOfExecution))
			return 180;
		else 
			return 270;
	}

	public boolean positionIsNorthOfUnit(Position position) {
		Position unitPosition = executingUnit.getPosition();
		
		return position.getX() == unitPosition.getX() &&
				position.getY() < unitPosition.getY();
				
	}
	
	public boolean positionIsSouthOfUnit(Position position) {
		Position unitPosition = executingUnit.getPosition();
		
		return position.getX() == unitPosition.getX() &&
				position.getY() > unitPosition.getY();
				
	}
	
	public boolean positionIsEastOfUnit(Position position) {
		Position unitPosition = executingUnit.getPosition();
		
		return position.getX() > unitPosition.getX() &&
				position.getY() == unitPosition.getY();
				
	}
	
	public boolean positionIsWestOfUnit(Position position) {
		Position unitPosition = executingUnit.getPosition();
		
		return position.getX() < unitPosition.getX() &&
				position.getY() == unitPosition.getY();
				
	}
	
}
