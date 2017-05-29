package l2kstudios.gme.view.actioninterface;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.view.GridDrawingUtil;

public class ActionPlacementView extends ActionInterfaceView {
	
	protected int RED_FILL = 255;
	protected int GREEN_FILL;
	protected int BLUE_FILL;
	protected int OPACITY_FILL = 75;
	
	private GridDrawingUtil gridDrawingUtil;
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	public void draw() {			
		drawPlaceableRectangles();
		drawCursorPosition();
		drawAreaOfEffect();
	}
	
	private void drawPlaceableRectangles() {
		ctx.fill(RED_FILL, GREEN_FILL, BLUE_FILL, OPACITY_FILL);
		ctx.stroke(0, 0);
		
		getModel().getChooseableSpaces().forEach((space) -> {
			gridDrawingUtil.drawRectAt(space.getPosition());
		});
		
		ctx.stroke(0, 255);
	}

	private void drawCursorPosition() {
		ctx.fill(0, 0, 255, 75);
		gridDrawingUtil.drawRectAt(model.getCursorPosition());					
	}


	

	private void drawAreaOfEffect() {
		RangeOfEffect rangeOfEffect = getModel().getRangeOfEffect();
		
		if(rangeOfEffect == null) return;
		
		ctx.fill(100, 100, 255, 25);
		
		rangeOfEffect.affectedSpaces(model.getCursorPosition()).forEach((space) ->{
			gridDrawingUtil.drawRectAt(space.getPosition());
		});
	}
	
}
