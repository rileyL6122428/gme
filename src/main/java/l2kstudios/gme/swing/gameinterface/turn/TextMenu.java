package l2kstudios.gme.swing.gameinterface.turn;

import java.util.List;

import l2kstudios.gme.model.grid.position.Position;

public interface TextMenu {
	
	public List<String> getSelectableItemNames();
	public int size();
	public Position actingUnitPosition();
	public int getCursorY();
}
