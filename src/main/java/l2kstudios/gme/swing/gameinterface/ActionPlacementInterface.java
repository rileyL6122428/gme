package l2kstudios.gme.swing.gameinterface;

import java.util.List;
import java.util.Set;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;

public interface ActionPlacementInterface {
	
	public Set<PlayingGridSpace> getChooseableSpaces();
	public Position getCursorPosition();
	
}
