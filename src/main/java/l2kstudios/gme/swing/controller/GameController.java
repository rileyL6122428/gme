package l2kstudios.gme.swing.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

import static l2kstudios.gme.model.interaction.Input.*;

import l2kstudios.gme.model.interaction.Interactable;
import l2kstudios.gme.swing.GamePanel;
import l2kstudios.gme.swing.controller.keybinding.BackSpaceKeyBinding;
import l2kstudios.gme.swing.controller.keybinding.DownKeyBinding;
import l2kstudios.gme.swing.controller.keybinding.KeyBinding;
import l2kstudios.gme.swing.controller.keybinding.LeftKeyBinding;
import l2kstudios.gme.swing.controller.keybinding.RightKeyBinding;
import l2kstudios.gme.swing.controller.keybinding.SpaceKeyBinding;
import l2kstudios.gme.swing.controller.keybinding.SwitchKeyBinding;
import l2kstudios.gme.swing.controller.keybinding.UpKeyBinding;

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
			add(new SwitchKeyBinding());
		}};
	}

	public void setKeyBindingsOn(final GamePanel gamePanel) {
		keyBindings.forEach((keyBinding) -> {
			keyBinding.setGameContext(gamePanel);
			keyBinding.apply();
		});
	}

}
