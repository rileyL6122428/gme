package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.Cursor;
import l2kstudios.gme.model.grid.position.Position;

import static l2kstudios.gme.swing.view.GridConstants.*;

import l2kstudios.gme.swing.view.ColorConstants;
import l2kstudios.gme.swing.view.View;

public class CursorView implements View {
	
	private UnitDetailInterface unitDetailInterface;
	
	public CursorView(UnitDetailInterface unitDetailInterface) {
		this.unitDetailInterface = unitDetailInterface;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		Position cursorPosition = unitDetailInterface.getCursorPosition();
		
		drawingCtx.setColor(ColorConstants.UnitDetail.CURSOR_BLUE);
		
		drawingCtx.fillRect(
			cursorPosition.getX() * SPACE_WIDTH, 
			cursorPosition.getY() * SPACE_HEIGHT, 
			SPACE_WIDTH, 
			SPACE_HEIGHT
		);
	}

}
