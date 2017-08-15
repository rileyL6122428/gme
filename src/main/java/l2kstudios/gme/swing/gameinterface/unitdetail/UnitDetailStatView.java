package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.view.View;

public class UnitDetailStatView implements View {

	private UnitDetailInterface unitDetailInterface;
	
	@Override
	public void draw(Graphics drawingCtx) {
		Unit focusedUnit = unitDetailInterface.getFocusedUnit();
		drawingCtx.drawString("Focused on: " + focusedUnit.getName(), 100, 100);
	}	

}
