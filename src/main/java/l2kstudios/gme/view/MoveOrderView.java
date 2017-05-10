package l2kstudios.gme.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.grid.ActingUnitTracker;
import l2kstudios.gme.model.unit.Unit;

public class MoveOrderView extends View<List<Unit>> {

	private ActingUnitTracker actingUnitTracker;	

	private int verticalOffset = 15;
	private int verticalMargin = 15;
	
	public void draw() {
		List<Unit> moveOrder = actingUnitTracker.getUnitMoveOrder();
		
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
	
	public void setActingUnitTracker(ActingUnitTracker actingUnitTracker) {
		this.actingUnitTracker = actingUnitTracker;
	}
}
