package l2kstudios.gme.swing.controller.keybinding;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import l2kstudios.gme.model.interaction.Input;

public class BackSpaceKeyBinding extends KeyBinding {
	
	{
		keyCode = KeyEvent.VK_BACK_SPACE;
		
		action = new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				gameContext.receiveInput(Input.BACK);
			}			
		};
	}
	
}
