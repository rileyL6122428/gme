package l2kstudios.gme.swing.view.interfacemanagement;

import java.awt.Graphics;

import l2kstudios.gme.model.interaction.Input;
import static l2kstudios.gme.model.interaction.Input.*;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.view.LevelView;
import l2kstudios.gme.swing.view.LevelViewFactory;
import l2kstudios.gme.swing.view.unitdetail.UnitDetailInterface;
import static l2kstudios.gme.swing.view.interfacemanagement.LevelInterface.ViewState.*;

public class LevelInterface implements Interface {
	
	enum ViewState {
		VIEWING_UNIT_DETAILS, VIEWING_GRID
	}
	
	private Level level;
	
	private ViewState viewState;

	private LevelView levelView;
	
	private TurnInterfaceManager turnInterfaceManager;
	private UnitDetailInterface unitDetailInterface;
	private Interface focusedInteractable;
	
	public LevelInterface() {
		turnInterfaceManager = new TurnInterfaceManager();
		unitDetailInterface = new UnitDetailInterface();
		
		focusedInteractable = turnInterfaceManager;
		
		viewState = VIEWING_GRID;
	}
	
	public void receiveInput(Input input) {
		if(input == SWITCH) 
			toggleFocusedInteractable();
		else 
			focusedInteractable.receiveInput(input);
	}

	@Override
	public void draw(Graphics drawingCtx) {
		if(viewState == VIEWING_GRID) {
			levelView.draw(drawingCtx);
			turnInterfaceManager.draw(drawingCtx);
		} else {
			unitDetailInterface.draw(drawingCtx);
		}
	}

	private void toggleFocusedInteractable() {
		if(focusedInteractable == turnInterfaceManager) {
			focusedInteractable = unitDetailInterface;
			viewState = VIEWING_UNIT_DETAILS;
		} else {
			focusedInteractable = turnInterfaceManager;
			viewState = VIEWING_GRID;
		}

	}
	
	public void afterPropertiesSet() {
		levelView = LevelViewFactory.newLevelView(level);
		turnInterfaceManager.setLevel(level);
		unitDetailInterface.setLevel(level);
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

	public LevelView getLevelView() {
		return levelView;
	}

	public void setLevelView(LevelView levelView) {
		this.levelView = levelView;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
