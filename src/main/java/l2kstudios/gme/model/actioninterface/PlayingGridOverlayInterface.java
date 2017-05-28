package l2kstudios.gme.model.actioninterface;

import java.util.List;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.turn.Transaction;
import l2kstudios.gme.model.turn.Turn;
import l2kstudios.gme.model.unit.Unit;

public class PlayingGridOverlayInterface extends ActionInterface {
	
	protected Unit actingUnit;
	
	protected PlayingGrid playingGrid;
	
	protected List<Space> chooseableSpaces;
	
	protected Transaction transaction;

	public List<Space> getChooseableSpaces() {
		return chooseableSpaces;
	}
	
	public void initialize(Turn turn) {
		transaction = turn.getTransaction();
		actingUnit = turn.getActingUnit();
		playingGrid = turn.getPlayingGrid();
		setSpaces(playingGrid.getSpaces());
	}
}
