package l2kstudios.gme.swing.controller.keybinding;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import l2kstudios.gme.model.interaction.Input;

public class DownKeyBinding extends KeyBinding {
	
	{
		keyCode = KeyEvent.VK_DOWN;
		
		action = new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				gameContext.receiveInput(Input.DOWN);
			}
		};
	}
	
}
