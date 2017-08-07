package l2kstudios.gme.swing.gameinterface;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.swing.view.View;

public class TextMenuView implements View {
	
	private TextMenu menu;
	
	public TextMenuView(TextMenu menu) {
		this.menu = menu;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		final List<String> itemNames = menu.getSelectableItemNames();
		
		for(int placementIdx = 0; placementIdx < menu.size(); placementIdx++) {
			int nameIdx = menu.size() - (placementIdx + 1);
			String name = itemNames.get(nameIdx);
			Position unitPosition = menu.actingUnitPosition();
			
			setDecisionColor(nameIdx, drawingCtx);
			
			drawingCtx.drawString(
				name, 
				SPACE_WIDTH * unitPosition.getX() + 50,
				SPACE_HEIGHT * unitPosition.getY() - 10 + nameIdx * 25
			);
		}
	}
	
	private void setDecisionColor(int decisionIdx, Graphics drawingCtx) {
		if(decisionIdx == menu.getCursorY()) 
			drawingCtx.setColor(Color.GREEN);
		else
			drawingCtx.setColor(Color.BLACK);
	}

}
