package l2kstudios.gme.view;

import com.google.common.collect.Range;

import l2kstudios.gme.model.grid.AttackPlacement;
import l2kstudios.gme.model.grid.Position;

public class AttackPlacementView extends View<AttackPlacement> {
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	private GridDrawingUtil gridDrawingUtil;
	
	public void draw() {
		if(model.shouldDraw()) {			
			drawCursorPosition();
			drawAreaOfEffect();
			drawPlaceableOutline();
		}
		
	}
	
	private void drawCursorPosition() {
		ctx.fill(255, 100, 100);
		gridDrawingUtil.drawRectAt(model.getCursorPosition());					
	}
	
	private void drawPlaceableOutline() {
		ctx.stroke(0, 255, 0);
		drawOuterOutlineCorners();
		drawOuterOutlineEdges();
		drawInnerOutlineCorners();
		drawInnerOutlineEdges();
		ctx.stroke(0);
		
		
	}



	private void drawOuterOutlineCorners() {
		Position unitPosition = model.getExecutingUnitPosition();
		Range<Integer> executionRange = model.getExectuionRange();
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX(), 
				unitPosition.getY() - executionRange.upperEndpoint(), 
				true, true, false, true
		);
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX() + executionRange.upperEndpoint(), 
				unitPosition.getY(), 
				true, true, true, false
		);
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX(), 
				unitPosition.getY() + executionRange.upperEndpoint(), 
				false, true, true, true
		);
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX() - executionRange.upperEndpoint(), 
				unitPosition.getY(), 
				true, false, true, true
		);
	}
	
	private void drawOuterOutlineEdges() {
		Position unitPosition = model.getExecutingUnitPosition();
		Range<Integer> executionRange = model.getExectuionRange();
		
		for(int edgeIdx = 1; edgeIdx < executionRange.upperEndpoint(); edgeIdx++) {
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() + edgeIdx, 
					unitPosition.getY() - executionRange.upperEndpoint() + edgeIdx, 
					true, true, false, false
			);
			
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() + executionRange.upperEndpoint() - edgeIdx, 
					unitPosition.getY() + edgeIdx, 
					false, true, true, false
			);
			
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() - edgeIdx, 
					unitPosition.getY() + executionRange.upperEndpoint() - edgeIdx, 
					false, false, true, true
			);
			
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() - executionRange.upperEndpoint() + edgeIdx, 
					unitPosition.getY() - edgeIdx, 
					true, false, false, true
			);
		}
		
	}

	private void drawInnerOutlineCorners() {
		Position unitPosition = model.getExecutingUnitPosition();
		Range<Integer> executionRange = model.getExectuionRange();
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX(), 
				unitPosition.getY() - executionRange.lowerEndpoint(), 
				false, false, true, false
		);
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX() + executionRange.lowerEndpoint(), 
				unitPosition.getY(), 
				false, false, false, true
		);
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX(), 
				unitPosition.getY() + executionRange.lowerEndpoint(), 
				true, false, false, false
		);
		
		gridDrawingUtil.drawRectOutline(
				unitPosition.getX() - executionRange.lowerEndpoint(), 
				unitPosition.getY(), 
				false, true, false, false
		);
	}
	
	private void drawInnerOutlineEdges() {
		Position unitPosition = model.getExecutingUnitPosition();
		Range<Integer> executionRange = model.getExectuionRange();
		
		for(int edgeIdx = 1; edgeIdx < executionRange.lowerEndpoint(); edgeIdx++) {
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() + edgeIdx, 
					unitPosition.getY() - executionRange.lowerEndpoint() + edgeIdx, 
					false, false, true, true
			);
			
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() + executionRange.lowerEndpoint() - edgeIdx, 
					unitPosition.getY() + edgeIdx, 
					true, false, false, true
			);
			
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() - edgeIdx, 
					unitPosition.getY() + executionRange.lowerEndpoint() - edgeIdx, 
					true, true, false, false
			);
			
			gridDrawingUtil.drawRectOutline(
					unitPosition.getX() - executionRange.lowerEndpoint() + edgeIdx, 
					unitPosition.getY() - edgeIdx, 
					false, true, true, false
			);
		}
	}

	private void drawAreaOfEffect() {
		// TODO Auto-generated method stub
		
	}
	
}
