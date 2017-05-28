package l2kstudios.gme.view;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.actioninterface.AttackPlacement;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Position;

public class AttackPlacementView extends View<AttackPlacement> {
	
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	private GridDrawingUtil gridDrawingUtil;
	
	public void draw() {
		if(model.shouldDraw()) {			
//			drawPlaceableRectangles();
//			drawCursorPosition();
//			drawAreaOfEffect();
		}
		
	}
	
	private void drawPlaceableRectangles() {
//		ctx.fill(255, 0, 0, 50);
//		ctx.stroke(0, 0);
//		Position unitPosition = model.getExecutingUnitPosition();
//		Range<Integer> executionRange = model.getExectuionRange();
//		
//		int rowIdxStart = unitPosition.getY() - executionRange.upperEndpoint();
//		int rowIdxEnd = unitPosition.getY() + executionRange.upperEndpoint();
//		
//		int colIdxStart = unitPosition.getX() - executionRange.upperEndpoint();
//		int colIdxEnd = unitPosition.getX() + executionRange.upperEndpoint();
//		
//		for(int rowIdx = rowIdxStart; rowIdx <= rowIdxEnd; rowIdx++) {
//			for(int colIdx = colIdxStart; colIdx <= colIdxEnd; colIdx++) {
//				int distanceFromUnit = GridUtils.distanceBetween(colIdx, rowIdx, unitPosition.getX(), unitPosition.getY());
//				if(model.isInBounds(colIdx, rowIdx) && executionRange.contains(distanceFromUnit))
//					gridDrawingUtil.drawRectAt(colIdx, rowIdx);
//			}
//		}
//		ctx.stroke(0, 255);
	}

	private void drawCursorPosition() {
		ctx.fill(255, 100, 100, 75);
		gridDrawingUtil.drawRectAt(model.getCursorPosition());					
	}


	

	private void drawAreaOfEffect() {
		RangeOfEffect rangeOfEffect = model.getRangeOfEffect();
		ctx.fill(100, 100, 255, 25);
		
		rangeOfEffect.affectedSpaces(model.getCursorPosition()).forEach((space) ->{
			gridDrawingUtil.drawRectAt(space.getPosition());
		});
	}
	
}
