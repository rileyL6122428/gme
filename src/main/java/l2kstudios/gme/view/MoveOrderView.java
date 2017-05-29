package l2kstudios.gme.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.movement.MovementCycle;
import l2kstudios.gme.model.unit.Unit;

public class MoveOrderView extends View<MovementCycle> {

	private int verticalOffset = 15;
	private int verticalMargin = 15;
	
	public void draw() {
		List<Unit> moveOrder = model.getOrder();
		
		for(int idx = 0; idx < moveOrder.size(); idx++) {
			Unit nextUnit = moveOrder.get(idx);
			ctx.text(nextUnit.getName(), ctx.width - 150, idx * verticalMargin + verticalOffset);
			ctx.text(nextUnit.getRemainingHealth(), ctx.width - 50, idx * verticalMargin + verticalOffset);
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
