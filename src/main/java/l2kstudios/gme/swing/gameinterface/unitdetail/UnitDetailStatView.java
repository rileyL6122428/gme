package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class UnitDetailStatView implements View {

	private Unit unit;
	
	@Override
	public void draw(Graphics drawingCtx) {
		drawingCtx.drawString("THIS IS THE UNIT DETAIL STAT VIEW", 100, 100);
	}	

}
