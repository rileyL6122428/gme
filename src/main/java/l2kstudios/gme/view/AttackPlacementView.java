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
		
		
		drawOuterOutline();
		drawInnerOutline();
	}
	
	private void drawOuterOutline() {
		ctx.stroke(0, 255, 0);
		drawTopRightOuterOutline();
		ctx.stroke(0);
	}

	private void drawTopRightOuterOutline() {
		Position executingUnitPosition = model.getExecutingUnitPosition();
		Range<Integer> executionRange = model.getExectuionRange();
		for(int idx = 0; idx <= executionRange.upperEndpoint(); idx++) {
			int x = executingUnitPosition.getX() + idx;
			int y = executingUnitPosition.getY() + idx - executionRange.upperEndpoint();
			
			gridDrawingUtil.drawRectOutlineTop(x, y);
			gridDrawingUtil.drawRectOutlineRight(x, y);
		}
	}

	private void drawInnerOutline() {
		// TODO Auto-generated method stub
		
	}

	private void drawAreaOfEffect() {
		// TODO Auto-generated method stub
		
	}
	
}
