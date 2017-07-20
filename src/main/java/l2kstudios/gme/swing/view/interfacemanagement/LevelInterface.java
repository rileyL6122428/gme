package l2kstudios.gme.swing.view.interfacemanagement;

import static l2kstudios.gme.model.interaction.Input.SWITCH;

import java.awt.Graphics;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.view.LevelGridInterface;
import l2kstudios.gme.swing.view.unitdetail.UnitDetailInterface;

public class LevelInterface implements Interface {

	private LevelGridInterface levelGridInterface;
	private UnitDetailInterface unitDetailInterface;
	
	private Interface focusedInteractable;
	
	public LevelInterface() {
		levelGridInterface = new LevelGridInterface();
		unitDetailInterface = new UnitDetailInterface();
		
		focusedInteractable = levelGridInterface;
	}
	
	public void receiveInput(Input input) {
		if(input == SWITCH) {
			toggleFocusedInteractable();
		} else {
			focusedInteractable.receiveInput(input);
		}
	}

	private void toggleFocusedInteractable() {
		focusedInteractable = (focusedInteractable == levelGridInterface) ? unitDetailInterface : levelGridInterface;
	}

	public LevelGridInterface getLevelGridInterface() {
		return levelGridInterface;
	}

	public void setLevelGridInterface(LevelGridInterface levelView) {
		this.levelGridInterface = levelView;
	}

	public UnitDetailInterface getUnitDetailInteface() {
		return unitDetailInterface;
	}

	public void setUnitDetailInterface(UnitDetailInterface unitDetailInterface) {
		this.unitDetailInterface = unitDetailInterface;
	}
	
	public void setLevel(Level level) {
		levelGridInterface.setLevel(level);
		unitDetailInterface.setLevel(level);
	}

	public void draw(Graphics drawingCtx) {
		focusedInteractable.draw(drawingCtx);
	}

}
