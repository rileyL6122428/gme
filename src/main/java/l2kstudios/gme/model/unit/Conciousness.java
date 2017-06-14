package l2kstudios.gme.model.unit;

import l2kstudios.gme.model.grid.Space;

public interface Conciousness {
	
	public Space getMoveSpace();
	
	public Class getPostMoveActionType();
	
	public Class getPostMoveActionInstanceClass();
	
	public Space getPostMoveActionSpace();
}
