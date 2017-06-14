package l2kstudios.gme.model.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import l2kstudios.gme.model.action.wait.BasicWait;
import l2kstudios.gme.model.action.wait.Wait;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.path.PathUtil;

public class BasicConciousness implements Conciousness {
	
	private Random random;
	private PathUtil pathUtil;
	
	private Unit unit;
	
	{
		random = new Random();
		pathUtil = new PathUtil();
	}
	
	public Space getMoveSpace() {
		List<Space> moveableSpaces = new ArrayList(pathUtil.moveableSpaces(unit));
		return moveableSpaces.get(random.nextInt(moveableSpaces.size()));
	}
	
	public Class getPostMoveActionType() {
		return Wait.class;
	}
	
	public Class getPostMoveActionInstanceClass() {
		return BasicWait.class;
	}
	
	public Space getPostMoveActionSpace() {
		return unit.getOccupiedSpace();
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
