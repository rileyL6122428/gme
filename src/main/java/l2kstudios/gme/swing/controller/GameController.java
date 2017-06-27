package l2kstudios.gme.swing.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

import static l2kstudios.gme.model.interaction.Input.*;

import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.swing.GamePanel;

public class GameController {
	
	private List<KeyBinding> keyBindings;
	
	{
		keyBindings = new ArrayList<KeyBinding>(){{
			add(new UpKeyBinding());
			add(new DownKeyBinding());
			add(new RightKeyBinding());
			add(new LeftKeyBinding());
			add(new SpaceKeyBinding());
			add(new BackSpaceKeyBinding());
		}};
	}

	public void setKeyBindingsOn(final GamePanel gamePanel) {
		keyBindings.forEach((keyBinding) -> {
			keyBinding.setGameContext(gamePanel);
			keyBinding.apply();
		});
	}

}
