package l2kstudios.gme.swing.gameinterface;

import java.util.List;

import l2kstudios.gme.model.grid.Position;

public interface TextMenu {
	
	public List<String> getSelectableItemNames();
	public int size();
	public Position actingUnitPosition();
	public int getCursorY();
}
