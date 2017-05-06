package l2kstudios.gme.model.level;

import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.level.InputDispatcher.Input;

public class Level {
	
	@Autowired
	private InputDispatcher inputDispatcher;
	
	public void registerInput(Input input) {
		inputDispatcher.dispatchInput(input);
	}	
}
