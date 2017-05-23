package l2kstudios.gme.view;

import l2kstudios.gme.model.grid.AttackPlacement;

public class AttackPlacementView extends View<AttackPlacement> {
	
	{
		gridDrawingUtil = GridDrawingUtil.getInstance();
	}
	
	private GridDrawingUtil gridDrawingUtil;
	
	public void draw() {
		System.out.println("AttackPlacement is drawing");
	}
	
}
