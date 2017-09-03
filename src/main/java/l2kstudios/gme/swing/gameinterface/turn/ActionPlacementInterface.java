package l2kstudios.gme.swing.gameinterface.turn;

import java.util.Set;

import l2kstudios.gme.model.action.rangeofeffect.RangeOfEffect;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.model.grid.position.Position;

public interface ActionPlacementInterface {
	
	public Set<PlayingGridSpace> getChooseableSpaces();
	
	public Position getCursorPosition();
	
	public RangeOfEffect getRangeOfEffect();

	public boolean canChoose(Position cursorPosition);
	
}
