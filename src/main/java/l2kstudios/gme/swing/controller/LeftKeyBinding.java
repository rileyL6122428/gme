package l2kstudios.gme.swing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import l2kstudios.gme.model.interaction.Input;

public class LeftKeyBinding extends KeyBinding {
	
	{
		keyCode = KeyEvent.VK_LEFT;
		
		action = new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				gameContext.receiveInput(Input.LEFT);
			}
		};
	}
	
}
