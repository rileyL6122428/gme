package l2kstudios.gme.swing.controller.keybinding;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.swing.GameGUI;
import l2kstudios.gme.swing.GamePanel;

public class KeyBinding {
	
	private static int actionId = 0;
	
	protected int keyCode;
	protected Action action;
	protected GamePanel gameContext;
	
	public void apply() {
		int nextActionId = actionId++;
		InputMap inputMap = gameContext.getInputMap();
		ActionMap actionMap = gameContext.getActionMap();
		
		inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), nextActionId);
		actionMap.put(nextActionId, action);
	}

	public void setGameContext(GamePanel gameContext) {
		this.gameContext = gameContext;
	}
	
}
