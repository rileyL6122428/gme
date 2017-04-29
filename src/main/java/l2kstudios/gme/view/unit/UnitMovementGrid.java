package l2kstudios.gme.view.unit;

import static l2kstudios.gme.model.unit.Unit.BoardState.*;
import static l2kstudios.gme.view.constants.GridConstants.*;

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

	public void draw() {
		if(!isChoosingMove(unit)) return;
		
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
			getCtx().rect(moveOptionPos.getX() * SPACE_WIDTH, moveOptionPos.getY() * SPACE_WIDTH, SPACE_WIDTH, SPACE_HEIGHT);					
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
