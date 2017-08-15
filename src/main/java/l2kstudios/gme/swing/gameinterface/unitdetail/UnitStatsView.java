package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;

import l2kstudios.gme.swing.view.View;

public class UnitStatsView implements View {
	
	private UnitDetailInterface unitDetailInterface;
	
	public UnitStatsView(UnitDetailInterface unitDetailInterface) {
		this.unitDetailInterface = unitDetailInterface;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		drawingCtx.drawString("SELECTED UNIT: " + unitDetailInterface.getSelectedUnit(), 50, 50);
	}

}
