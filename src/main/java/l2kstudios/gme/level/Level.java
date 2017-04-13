package l2kstudios.gme.level;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.level.InputDispatcher.Input;
import l2kstudios.gme.level.grid.PlayingGrid;

public class Level implements InitializingBean {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Unit testUnit = new Unit();
		testUnit.setPosition(new Position(1, 1));
		playingGrid.addUnit(testUnit);
	}	

	@Autowired
	private PlayingGrid playingGrid;
	
	@Autowired
	private InputDispatcher inputDispatcher;
	
	public void registerInput(Input input) {
		inputDispatcher.dispatchInput(input);
	}	
	
	public void moveCursorPositionBy(int deltaX, int deltaY) {
		playingGrid.moveCursorBy(deltaX, deltaY);
	}
	
	public Position getCursorPosition() {
		return playingGrid.getCursorPosition();
	}
	
	public int getGridWidth() {
		return playingGrid.getWidth();
	}
	
	public int getGridHeight() {
		return playingGrid.getHeight();
	}
	
	void setPlayingGrid(PlayingGrid grid) {
		this.playingGrid = grid;
	}
	
	public List<Unit> getUnits() {
		return playingGrid.getUnits();
	}

}
