package l2kstudios.gme.levelview;

import static l2kstudios.gme.levelview.PlayingGridView.GRID_BOX_HEIGHT;
import static l2kstudios.gme.levelview.PlayingGridView.GRID_BOX_WIDTH;

import l2kstudios.gme.level.Position;
import l2kstudios.gme.level.Unit;
import l2kstudios.gme.level.grid.PlayingGrid;
import processing.core.PApplet;

public class UnitView implements View {
	
	private PApplet ctx;
	private Unit unit;
	private PlayingGrid playingGrid;
	private UnitOverView unitOverView;
	
	public UnitView(PApplet ctx, Unit unit, PlayingGrid playingGrid) {
		this.ctx = ctx;
		this.unit = unit;
		this.playingGrid = playingGrid;
		unitOverView = new UnitOverView(unit, ctx, playingGrid);
	}
	
	public void draw() {
		drawMovementGrid();
		unitOverView.draw();
		setUnitFill();
		drawUnit();
	}

	private void drawMovementGrid() {
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
	
	private void setUnitFill() {
		if(playingGrid.isActingUnit(unit)) {
			ctx.fill(0, 0, 255);			
		} else {
			ctx.fill(0, 255, 0);
		}		
	}
	
	private void drawUnit() {
		Position unitPos = unit.getPosition();
		ctx.ellipse(unitPos.getX() * GRID_BOX_WIDTH, unitPos.getY() * GRID_BOX_HEIGHT, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);		
	}
}
