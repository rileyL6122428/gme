package l2kstudios.gme.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.unit.Unit;
import processing.core.PApplet;

public class MoveOrderView implements View{
	
	@Autowired
	private PlayingGrid playingGrid;
	@Autowired
	private PApplet ctx;
	
	private int verticalOffset;
	private int verticalMargin;
	
	public void draw() {
		List<Unit> moveOrder = playingGrid.getMoveOrder();
		
		for(int idx = 0; idx < moveOrder.size(); idx++) {
			Unit nextUnit = moveOrder.get(idx);
			ctx.text(nextUnit.getName(), ctx.width - 100, idx * verticalMargin + verticalOffset);
		}
	}

	public int getVerticalOffset() {
		return verticalOffset;
	}

	public void setVerticalOffset(int verticalOffset) {
		this.verticalOffset = verticalOffset;
	}

	public int getVerticalMargin() {
		return verticalMargin;
	}

	public void setVerticalMargin(int verticalMargin) {
		this.verticalMargin = verticalMargin;
	}
}