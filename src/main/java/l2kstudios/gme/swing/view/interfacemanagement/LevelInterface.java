package l2kstudios.gme.swing.view.interfacemanagement;

import java.awt.Graphics;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.swing.view.LevelView;
import l2kstudios.gme.swing.view.unitdetail.UnitDetailInterface;

public class LevelInterface implements Interface {

	private LevelView levelView;
//	private UnitDetailInterface unitDetailInterface;
//	
//	private Interface focusedInteractable;
	
	public LevelInterface() {
		levelView = new LevelView();
//		unitDetailInterface = new UnitDetailInterface();
		
	}
	
	public void receiveInput(Input input) {
//		if(input == SWITCH) {
////			toggleFocusedInteractable();
//		} else {
//			focusedInteractable.receiveInput(input);
//		}
		
		System.out.println(input);
	}

	@Override
	public void draw(Graphics drawingCtx) {
		levelView.draw(drawingCtx);
	}

//	private void toggleFocusedInteractable() {
//		focusedInteractable = (focusedInteractable == levelGridInterface) ? unitDetailInterface : levelGridInterface;
//	}
//
//	public LevelView getLevelGridInterface() {
//		return levelGridInterface;
//	}
//
//	public void setLevelGridInterface(LevelView levelView) {
//		this.levelGridInterface = levelView;
//	}
//
//	public UnitDetailInterface getUnitDetailInteface() {
//		return unitDetailInterface;
//	}
//
//	public void setUnitDetailInterface(UnitDetailInterface unitDetailInterface) {
//		this.unitDetailInterface = unitDetailInterface;
//	}
//	
	public void setLevel(Level level) {
		levelView.setLevel(level);
//		unitDetailInterface.setLevel(level);
	}


}
