package l2kstudios.gme.swing.gameinterface.level;

import java.awt.Graphics;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.interaction.Input;
import static l2kstudios.gme.model.interaction.Input.*;

import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.gameinterface.turn.TurnInterfaceManager;
import l2kstudios.gme.swing.gameinterface.unitdetail.UnitDetailInterface;
import l2kstudios.gme.swing.view.BoardView;
import l2kstudios.gme.swing.view.LevelViewFactory;

public class LevelInterface implements Interface {
	
	private Level level;

	private BoardView boardView;
	
	private TurnInterfaceManager turnInterfaceManager;
	private UnitDetailInterface unitDetailInterface;
	private Interface focusedInteractable;
	
	public LevelInterface() {
		turnInterfaceManager = new TurnInterfaceManager();
		unitDetailInterface = new UnitDetailInterface();
		
		focusedInteractable = turnInterfaceManager;
	}
	
	@Override
	public void draw(Graphics drawingCtx) {
		focusedInteractable.draw(drawingCtx);
	}
	
	public void receiveInput(Input input) {
		if(input == SWITCH) 
			toggleFocusedInteractable();
		else 
			focusedInteractable.receiveInput(input);
	}

	private void toggleFocusedInteractable() {
		focusedInteractable = (focusedInteractable == turnInterfaceManager) ? unitDetailInterface : turnInterfaceManager;
	}
	
	public void afterPropertiesSet() {
		boardView = LevelViewFactory.newLevelView(level);
		
		turnInterfaceManager.setLevel(level);
		turnInterfaceManager.setBoardView(boardView);
		
		unitDetailInterface.setPlayingGrid(level.getPlayingGrid());
		unitDetailInterface.setBoardView(boardView);
		unitDetailInterface.afterPropertiesSet();
	}

	public TurnInterfaceManager getTurnInterfaceManager() {
		return turnInterfaceManager;
	}

	public void setTurnInterfaceManager(TurnInterfaceManager turnInterfaceManager) {
		this.turnInterfaceManager = turnInterfaceManager;
	}

	public UnitDetailInterface getUnitDetailInterface() {
		return unitDetailInterface;
	}

	public void setUnitDetailInterface(UnitDetailInterface unitDetailInterface) {
		this.unitDetailInterface = unitDetailInterface;
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
