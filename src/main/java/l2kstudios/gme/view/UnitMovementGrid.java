package l2kstudios.gme.view;

import static l2kstudios.gme.model.unit.Unit.BoardState.*;
import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_HEIGHT;
import static l2kstudios.gme.view.PlayingGridView.GRID_BOX_WIDTH;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import processing.core.PApplet;

public class UnitMovementGrid {
	
	private PlayingGrid playingGrid;
	private PApplet ctx;
	private Unit unit;
	
	public UnitMovementGrid(Unit unit, PApplet ctx, PlayingGrid playingGrid) {
		this.setUnit(unit);
		this.setCtx(ctx);
		this.setPlayingGrid(playingGrid);
	}
	
	public UnitMovementGrid() {
		// TODO Auto-generated constructor stub
	}

	public void draw() {
		if(!isChoosingMove(getUnit())) return;
		
		getCtx().fill(150, 100);
		movementOptions().forEach(this::fillInGridSpace);
	}
	
	private boolean isChoosingMove(Unit unit) {
		return getPlayingGrid().isActingUnit(unit) && unit.isInBoardState(MOVING);
	}
	
	private List<Position> movementOptions() {
		List<Position> options = new ArrayList<Position>();
		Position unitPos = getUnit().getPosition();
		int remainingEnergy = (int)getUnit().getEnergy().getVal();
		
		for(int vertical = -remainingEnergy; vertical <= remainingEnergy; vertical++) {
			int horizontalCap = Math.abs(remainingEnergy - Math.abs(vertical));
			for(int horizontal = -horizontalCap; horizontal <= horizontalCap; horizontal++) {
				options.add(new Position(unitPos.getX() + horizontal, unitPos.getY() + vertical));
			}
		}
		
		return options;
	}
	
	private void fillInGridSpace(Position moveOptionPos) {
		if(getPlayingGrid().isInBounds(moveOptionPos))
			getCtx().rect(moveOptionPos.getX() * GRID_BOX_WIDTH, moveOptionPos.getY() * GRID_BOX_WIDTH, GRID_BOX_WIDTH, GRID_BOX_HEIGHT);					
	}

	public PlayingGrid getPlayingGrid() {
		return playingGrid;
	}

	public void setPlayingGrid(PlayingGrid playingGrid) {
		this.playingGrid = playingGrid;
	}

	public PApplet getCtx() {
		return ctx;
	}

	public void setCtx(PApplet ctx) {
		this.ctx = ctx;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
