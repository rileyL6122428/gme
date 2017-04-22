package l2kstudios.gme.view;

import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_HEIGHT;
import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_WIDTH;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.level.Position;
import l2kstudios.gme.model.level.Unit;
import processing.core.PApplet;

public class UnitMovementGrid {
	
	private PlayingGrid playingGrid;
	private PApplet ctx;
	private Unit unit;
	
	public UnitMovementGrid(Unit unit, PApplet ctx, PlayingGrid playingGrid) {
		this.unit = unit;
		this.ctx = ctx;
		this.playingGrid = playingGrid;
	}
	
	public void draw() {
		if(!playingGrid.isActingUnit(unit)) return;
		
		ctx.fill(150, 100);
		Position unitPos = unit.getPosition();
		int remainingEnergy = (int)unit.getEnergy();
		for(int vertical = -remainingEnergy; vertical <= remainingEnergy; vertical++) {
			int horizontalCap = Math.abs(remainingEnergy - Math.abs(vertical));
			for(int horizontal = -horizontalCap; horizontal <= horizontalCap; horizontal++) {
				Position moveOptionPos = new Position(unitPos.getX() + horizontal, unitPos.getY() + vertical); 
				if(playingGrid.isInBounds(moveOptionPos)) {
					ctx.rect(moveOptionPos.getX() * GRID_BOX_WIDTH, moveOptionPos.getY() * GRID_BOX_WIDTH, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);					
				}
			}
		}
	}
}
