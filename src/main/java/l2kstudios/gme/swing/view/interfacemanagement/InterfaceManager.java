package l2kstudios.gme.swing.view.interfacemanagement;

import java.util.HashMap;
import java.util.Map;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.swing.view.LevelView;
import l2kstudios.gme.swing.view.unitdetail.UnitDetailView;

public class InterfaceManager implements Interactable {
	
	private static Map<FocusableInterface, Interactable> focusableInterfaces;
	
	static {
		focusableInterfaces = new HashMap<FocusableInterface, Interactable>();
	}

	private LevelView levelView;
	private UnitDetailView unitDetailView;
	
	private Interactable focusedInteractable;
	
	public void receiveInput(Input input) {
		// TODO Auto-generated method stub 
		
	}

	public LevelView getLevelView() {
		return levelView;
	}

	public void setLevelView(LevelView levelView) {
		this.levelView = levelView;
	}

	public UnitDetailView getUnitDetailView() {
		return unitDetailView;
	}

	public void setUnitDetailView(UnitDetailView unitDetailView) {
		this.unitDetailView = unitDetailView;
	}
	
	public void afterPropertiesSet() {
		// set focused interactable to level view
	}

}
