package l2kstudios.gme.view;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import processing.core.PApplet;

public class UnitView implements View {
	
	private UnitOverView unitOverView;
	private UnitMovementGrid unitMovementGrid;
	private UnitGridAvatar gridAvatar;
	
	public UnitView(PApplet ctx, Unit unit, PlayingGrid playingGrid) {
		unitOverView = new UnitOverView(unit, ctx, playingGrid);
		unitMovementGrid = new UnitMovementGrid(unit, ctx, playingGrid);
		gridAvatar = new UnitGridAvatar(unit, ctx, playingGrid);
	}
	
	public void draw() {
		unitMovementGrid.draw();
		unitOverView.draw();
		gridAvatar.draw();
	}
}
