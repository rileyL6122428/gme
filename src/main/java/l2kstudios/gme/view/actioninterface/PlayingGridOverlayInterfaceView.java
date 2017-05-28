package l2kstudios.gme.view.actioninterface;

import com.google.common.collect.Range;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.GridUtils;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.view.GridDrawingUtil;
import l2kstudios.gme.model.actioninterface.PlayingGridOverlayInterface;

public class PlayingGridOverlayInterfaceView extends ActionInterfaceView {
	
	
	protected int RED_FILL;
	protected int GREEN_FILL;
	protected int BLUE_FILL;
	protected int OPACITY_FILL;
	
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
	
	public PlayingGridOverlayInterface getModel() {
		return (PlayingGridOverlayInterface) model;
	}
}
