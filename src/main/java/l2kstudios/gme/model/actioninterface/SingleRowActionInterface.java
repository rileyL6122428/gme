package l2kstudios.gme.model.actioninterface;

import java.util.ArrayList;
import java.util.List;

import l2kstudios.gme.model.grid.Space;

public class SingleRowActionInterface extends ActionInterface {
	
	private static int SINGLE_ROW_IDX = 0;
	
	@Override
	public void moveCursorDown() {
		super.moveCursorLeft();
	}
	
	@Override
	public void moveCursorUp() {
		super.moveCursorRight();
	}
	
	public Space getSpaceAt(int x) {
		if(isInBounds(x)) 
			return spaces.get(SINGLE_ROW_IDX).get(x);
		else
			return null;
	}
	
	public boolean isInBounds(int x) {
		return x < spaces.get(SINGLE_ROW_IDX).size() && x >= 0;
	}
	
	public List<Space> getRow() {
		return spaces.get(SINGLE_ROW_IDX);
	}
	
	public void setRow(List<Space> row) {
		List<List<Space>> spaces = new ArrayList<List<Space>>();
		spaces.add(row);
		setSpaces(spaces);
	}
	
	public void setSpaces(List<List<Space>> spaces) {
		validateIsSingleRowDimension(spaces);
		super.setSpaces(spaces);
	}
	
	private void validateIsSingleRowDimension(List<List<Space>> spaces) {
		if(spaces.size() != 1) throw new RuntimeException("SPACES ARE NOT SINGLE ROW");
	}
}
