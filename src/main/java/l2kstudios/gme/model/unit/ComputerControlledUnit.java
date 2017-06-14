package l2kstudios.gme.model.unit;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;

public class ComputerControlledUnit extends Unit {
	
	protected Conciousness conciousness;
	
	public Space getMoveSpace() {
		return conciousness.getMoveSpace();
	}
	
	public Class getPostMoveActionType() {
		return conciousness.getPostMoveActionType();
	}
	
	public Class getPostMoveActionInstanceClass() {
		return conciousness.getPostMoveActionInstanceClass();
	}
	
	public Space getPostMoveActionPosition() {
		return conciousness.getPostMoveActionSpace();
	}
}
